/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.AccountService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Extreme PC
 */
@WebServlet(
        name = "UpdateAccountServlet",
        urlPatterns = {"/UpdateAcoount", "/update-account"}
)
public class UpdateAccountServlet extends HttpServlet {

    private final AccountService accountService = new AccountService();

    private void processRequest(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

      
        int idAccount = Integer.parseInt(request.getParameter("cuenta"));
        double transactionLimit = Double.parseDouble(request.getParameter("limite"));
        int isActive = Integer.parseInt(request.getParameter("isActive"));



        if (accountService.updateAccount(idAccount, transactionLimit, isActive)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(
                    "accountupdate.jsp");
            dispatcher.forward(request, response);
        }
        else{
             RequestDispatcher dispatcher = request.getRequestDispatcher(
                    "accountupdate.jsp");
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
