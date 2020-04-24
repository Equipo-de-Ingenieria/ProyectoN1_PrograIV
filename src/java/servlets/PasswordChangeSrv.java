/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

/**
 *
 * @author Erick
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.util.Optional;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import services.UserService;

/**
 *
 * @author Erick
 */
@WebServlet(
        name = "PasswordChangeSrv",
        urlPatterns = {"/PasswordChange", "/password-change"}
)

public class PasswordChangeSrv extends HttpServlet {

    private void processRequest(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String currentPassword, newPassword, message;

        currentPassword = request.getParameter("current-password");
        newPassword = request.getParameter("new-password");
        message = null;


        User user = (User) request.getSession(true).getAttribute("userData");
        UserService userService = new UserService();

        Optional<User> aux = userService.getPassword(user.getId());

        if (!aux.isPresent()) {
            message = "Error";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("clientmessage.jsp");
            dispatcher.forward(request, response);
        }

        if (!aux.get().getPassword().equals(currentPassword)) {
            message = "La contraseña actual es erronea";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("clientmessage.jsp");
        }

        if (!userService.updatePassword(newPassword)) {
            message = "Error actualizando la contraseña";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("clientmessage.jsp");
            dispatcher.forward(request, response);
        }

        message = "Se actualizo exitosamente la contraseña";
        request.setAttribute("message", message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("clientmessage.jsp");
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
