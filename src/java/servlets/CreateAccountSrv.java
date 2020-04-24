/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import services.AccountService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author Extreme PC
 */
@WebServlet(
        name = "CreateAccServlet",
        urlPatterns = {"/CreateAcc", "/createacc-registry"}
)
public class CreateAccountSrv extends HttpServlet {

    private final AccountService accountService = new AccountService();

    private void processRequest(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idUser = Integer.parseInt(request.getParameter("idUsuario"));
        String currencyName = request.getParameter("cambio");
        double transactionLimit = Double.parseDouble(request.getParameter("limite"));
        double balance = 0;
        int accountType = Integer.parseInt(request.getParameter("tipoCuenta"));
        int isActive = 1;

        Account account = new Account(balance, idUser, currencyName, accountType, transactionLimit, isActive);


        if (accountService.createAccount(account)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(
                    "accountopening.jsp");
            dispatcher.forward(request, response);
        }
        else{
             RequestDispatcher dispatcher = request.getRequestDispatcher(
                    "usercreatemenu.jsp");
            dispatcher.forward(request, response);
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
