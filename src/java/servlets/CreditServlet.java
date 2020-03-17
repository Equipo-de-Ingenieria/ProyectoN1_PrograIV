/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.AccountType;
import services.AccountService;
import services.AccountTypeService;

/**
 *
 * @author Extreme PC
 */
@WebServlet(
        name = "CreditServlet",
        urlPatterns = {"/CreditServlet"})
public class CreditServlet extends HttpServlet {

    private void processRequest(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccountService accountservice = new AccountService();
        AccountTypeService typeservice = new AccountTypeService();
        Optional<Account> account = accountservice.getAccount(request.getParameter("cuenta"));
        Optional<AccountType> type = typeservice.getAccount(request.getParameter(account.get).getAccountTypeID());
        double interests = type.get().getInterest() * account.get().getBalance();
        double sum = interests + account.get().getBalance();

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
