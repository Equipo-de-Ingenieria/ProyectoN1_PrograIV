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
import model.User;
import services.AccountService;
import services.FavoriteService;
import services.UserService;

/**
 *
 * @author Erick
 */
@WebServlet(
        name = "SyncServlet",
        urlPatterns = {"/Sync", "/sync-account"}
)

public class SyncServlet extends HttpServlet {

    private void processRequest(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AccountService accService = new AccountService();
        UserService userService = new UserService();

        //Atrapa el numero de cuenta del JSP
        String accountID = request.getParameter("accountID");
        Optional<Account> accountOP;
        Optional<User> userOP;
        Account auxAcc;

        //Comprueba si el valor del boton buscar es "Search o Add"
        if ("search".equals(request.getParameter("searchBtn")) && !request.getParameter("accountID").equals("0")) {
            accountOP = accService.getAccount(accountID);
            auxAcc = new Account(accountOP.get().getId(), accountOP.get().getBalance(), accountOP.get().getUserId(), accountOP.get().getCurrencyName(), accountOP.get().getAccountTypeID(), accountOP.get().getTransactionLimit(), accountOP.get().getIsActive());
            request.setAttribute("accountData", auxAcc);

            if (accountOP.isPresent()) {
                userOP = userService.getUserByID(accountOP.get().getUserId());
                User user = new User(userOP.get().getName());
                request.setAttribute("userSearched", user);

                RequestDispatcher dispatcher = request.getRequestDispatcher(
                        "syncmenu.jsp");
                dispatcher.forward(request, response);

            } else {
                String message = "No existe la cuenta!";
                request.setAttribute("message", message);

                RequestDispatcher dispatcher = request.getRequestDispatcher(
                        "messege.jsp");
                dispatcher.forward(request, response);

            }

        } else if ("add".equals(request.getParameter("addBtn")) && !accountID.equals("0") && !request.getParameter("mainUserID").isEmpty() && !request.getParameter("accountID").isEmpty()) {

            FavoriteService favService = new FavoriteService();

            int userID = Integer.valueOf(request.getParameter("mainUserID"));
            int accID = Integer.valueOf(request.getParameter("accountID"));

            if (favService.createFavorite(userID, accID)) {
                RequestDispatcher dispatcher = request.getRequestDispatcher(
                        "syncmenu.jsp");
                dispatcher.forward(request, response);
            }

        } else {
            String message = "Error";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher(
                    "messege.jsp");
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
