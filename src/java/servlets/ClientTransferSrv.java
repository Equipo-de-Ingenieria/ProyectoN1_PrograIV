/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

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
import services.AccountService;
import services.CurrencyService;
import services.TransferService;

/**
 *
 * @author Erick
 */
@WebServlet(
        name = "ClientTransferServlet",
        urlPatterns = {"/ClientTransfer", "/client-transfer"}
)

public class ClientTransferSrv extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strAccount;
        String strFavorite;
        String strDetail;
        String strAmount;
        Transfer transfer;
        double debitAmount;
        double creditAmount = 0;
        String debitCurrencyName;
        String creditCurrencyName;

        AccountService accService;
        TransferService tranService;

        strAccount = request.getParameter("debitSelect");
        strFavorite = request.getParameter("creditSelect");
        strDetail = request.getParameter("detailInput");
        strAmount = request.getParameter("amountInput");

        accService = new AccountService();
        Optional<Account> debitAccount = accService.getAccount(strAccount);
        Optional<Account> creditAccount = accService.getAccount(strFavorite);

        if (debitAccount.isPresent() && creditAccount.isPresent()) {

            debitCurrencyName = debitAccount.get().getCurrencyName();
            creditCurrencyName = creditAccount.get().getCurrencyName();
            debitAmount = Double.valueOf(strAmount);

            CurrencyService currencyService = new CurrencyService();
            Optional<Currency> debitCurrency = currencyService.getCurrency(debitCurrencyName);
            Optional<Currency> creditCurrency = currencyService.getCurrency(creditCurrencyName);

            /*Calculo de monedas*/
            switch (debitCurrencyName) {
                case "EUR":
                    if ("USD".equals(creditCurrencyName)) {
                        double amountCRC = debitCurrency.get().getBuy() * debitAmount;
                        creditAmount = amountCRC / creditCurrency.get().getSell();
                    } else if ("CRC".equals(creditCurrencyName)) {
                        creditAmount = debitCurrency.get().getBuy() * debitAmount;
                    } else {
                        creditAmount = debitAmount;
                    }
                    break;

                case "USD":
                    if ("EUR".equals(creditCurrencyName)) {
                        double amountCRC = debitCurrency.get().getBuy() * debitAmount;
                        creditAmount = amountCRC / creditCurrency.get().getSell();
                    } else if ("CRC".equals(creditCurrencyName)) {
                        creditAmount = debitCurrency.get().getBuy() * debitAmount;
                    } else {
                        creditAmount = debitAmount;
                    }
                    break;

                case "CRC":
                    creditAmount = debitAmount / creditCurrency.get().getSell();
                    break;
            }

            int debitID = Integer.valueOf(strAccount);
            int creditID = Integer.valueOf(strFavorite);

            java.util.Date date = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

            /*Actualiza los montos de la cuentas y crea una transferencia*/
            double limit = debitAccount.get().getCurrentLimit() - debitAmount;
            if (limit >= 0) {

                if (accService.updateAccountBalance(debitID, -debitAmount)) {
                    if (accService.updateAccountBalance(creditID, creditAmount)) {
                        tranService = new TransferService();
                        transfer = new Transfer(debitID, creditID, debitAmount, sqlDate, strDetail);
                        tranService.createTransfer(transfer);
                        
                        accService.updateAccountCurrentLimit(debitID, limit);

                        String message = "Se realizo la transferencia exitosamente!";
                        request.setAttribute("message", message);
                        RequestDispatcher dispatcher = request.getRequestDispatcher(
                                "clientmessage.jsp");
                        dispatcher.forward(request, response);
                    }

                } else {
                    String message = "Insuficiente fondos!";
                    request.setAttribute("message", message);
                    RequestDispatcher dispatcher = request.getRequestDispatcher(
                            "clientmessage.jsp");
                    dispatcher.forward(request, response);
                }
            } else {
                String message = "Limite de transferncia alcanzado";
                request.setAttribute("message", message);
                RequestDispatcher dispatcher = request.getRequestDispatcher(
                        "clientmessage.jsp");
                dispatcher.forward(request, response);
            }

        }

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
