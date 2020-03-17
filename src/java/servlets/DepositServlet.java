/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import services.AccountService;
import services.TransferService;
import services.UserService;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Optional;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.Transfer;
import model.User;

/**
 *
 * @author Extreme PC
 */
@WebServlet(
        name = "DepositServlet",
        urlPatterns = {"/DepositServlet"}
)
public class DepositServlet extends HttpServlet {

    private void processRequest(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccountService accountservice = new AccountService();
        TransferService transferservice = new TransferService();
        Optional<Account> aux = null;
        aux = accountservice.getAccount(request.getParameter("numcuenta"));
        double balance = aux.get().getBalance();
        double sum = balance + Double.parseDouble(request.getParameter("monto"));
        accountservice.updateAllAccount(aux.get().getId(), aux.get().getTransactionLimit(), aux.get().getIsActive(), sum);
        Transfer transaux = null;
        
        java.util.Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        
        transaux = new Transfer(0, 1, aux.get().getId(), sum, sqlDate);
        transferservice.createTransfer(transaux);
        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "depositmenu.jsp");
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
