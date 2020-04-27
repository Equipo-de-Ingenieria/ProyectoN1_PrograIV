/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import services.AccountService;
import services.TransferService;
import java.io.IOException;
import java.util.Optional;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.Currency;
import model.Transfer;
import services.CurrencyService;

/**
 *
 * @author Extreme PC
 */
@WebServlet(
        name = "RetireServlet",
        urlPatterns = {"/Retire"}
)
public class RetireServlet extends HttpServlet {

    private void processRequest(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = "";
        AccountService accountservice = new AccountService();
        TransferService transferservice = new TransferService();
        CurrencyService currencyservice = new CurrencyService();
        Optional<Account> aux = null;
        aux = accountservice.getAccount(request.getParameter("numcuenta"));
        double balance1 = Double.parseDouble(request.getParameter("monto"));
        String typeCurrency = request.getParameter("cambio");
        Optional<Currency> currency = currencyservice.getCurrency(request.getParameter("cambio"));
        double balance = aux.get().getBalance();
        //MONEDA
        if (aux.get().getCurrencyName().equals("CRC")) {//SI LA CUENTA ES COLONES
            if ("USD".equals(typeCurrency)) {
                balance1 = balance1 * 560;
            } else if ("EUR".equals(typeCurrency)) {
                balance1 = balance1 * 700;
            }
        } else if ("USD".equals(aux.get().getCurrencyName())) { //SI LA CUENTA ES DOLARES
            if ("CRC".equals(typeCurrency)) {
                balance1 = balance1 / 570;
            } else if ("EUR".equals(typeCurrency)) {
                balance1 = balance1 / 0.89;
            }
        } else if ("EUR".equals(aux.get().getCurrencyName())) { //SI LA CUENTA ES EUROS
            if ("USD".equals(typeCurrency)) {
                balance1 = balance1 / 1.12;
            } else if ("CRC".equals(typeCurrency)) {
                balance1 = balance1 / 0.0016;
            }
        }

        double sub = balance - balance1;
        if (sub >= 0) {
            if (sub != 0) {
                accountservice.updateAllAccount(aux.get().getId(), aux.get().getTransactionLimit(), aux.get().getIsActive(), sub);
            } else {
                accountservice.updateAllAccount(aux.get().getId(), aux.get().getTransactionLimit(), 0, sub);
            }
            Transfer transaux = null;

            java.util.Date date = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

            transaux = new Transfer(0, aux.get().getId(), 1, sub, sqlDate, "Retiro Cajero");
            transferservice.createTransfer(transaux);
            message = "Se realizo el retiro exitosamente!";

        } else {

            message = "Error, dinero insuficiente";
        }
        request.setAttribute("message", message);
        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "messege.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doGet(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
