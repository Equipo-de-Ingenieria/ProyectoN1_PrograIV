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
import model.Transfer;

/**
 *
 * @author Extreme PC
 */
@WebServlet(
        name = "RetireServlet",
        urlPatterns = {"/Retire"}
)
public class RetireServlet  extends HttpServlet{
      private void processRequest(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccountService accountservice = new AccountService();
        TransferService transferservice = new TransferService();
        Optional<Account> aux = null;
        aux = accountservice.getAccount(request.getParameter("numcuenta"));
        double balance = aux.get().getBalance();
        double sub = balance - Double.parseDouble(request.getParameter("monto"));
        accountservice.updateAllAccount(aux.get().getId(), aux.get().getTransactionLimit(), aux.get().getIsActive(), sub);
        Transfer transaux = null;
        
        java.util.Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        
        transaux = new Transfer(0, aux.get().getId(), 1, sub, sqlDate);
        transferservice.createTransfer(transaux);
        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "retiremenu.jsp");
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
