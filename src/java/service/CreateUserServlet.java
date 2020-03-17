/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UserService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author Extreme PC
 */
@WebServlet(
        name = "CreateUserServlet",
        urlPatterns = {"/CreateUser", "/createuser-registry"}
)
public class CreateUserServlet extends HttpServlet {

    private UserService userservice;

    private void processRequest(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        userservice = new UserService();
        User useraux = null;
        String pass = "";
        String id = request.getParameter("cedula");
        String name = request.getParameter("nombre");
        String phone = request.getParameter("telefono");
        int type = Integer.parseInt(request.getParameter("tipo"));
        pass = passwordGenerator();
        useraux = new User(0, name, phone, type, pass, id);
        userservice.createUser(useraux);
        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "usercreatemenu.jsp");
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

    private String passwordGenerator() {
        char aux = 33;
        int random;
        String pass = "";
        for (int i = 0; i < 8; i++) {
            random = (int) (92 * Math.random());
            aux = (char) (aux + random);
            pass = pass + aux;
            aux = 33;
        }
        return pass;
    }
}
