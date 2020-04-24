package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.UserService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.User;

@WebServlet(
        name = "UserServlet",
        urlPatterns = {"/UserInfo", "/user-registry"}
)
public class UserServlet extends HttpServlet {

    private final UserService userService = new UserService();

    private void processRequest(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /* Consigue los parametros de los inputs luego del submit del form*/
        String id = request.getParameter("userInput");
        String pass = request.getParameter("passInput");
        User aux = null;
        if (id != null && pass != null) {
            /*Puede ser un nombre aleatorio para trabajar en el servlet luego UserData*/
            request.setAttribute("userData", null);

            /*Trae la informacion de las bases de datos y  se lo asigna al userData*/
            userService.getUser(id, pass)
                    .ifPresent(user -> request.setAttribute("userData", user));

            aux = (User) request.getAttribute("userData");
            int i = 0;

        }
        if (aux == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(
                    "index.jsp");
            dispatcher.forward(request, response);
        }
        if (aux.getType() == 1) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(
                    "WEB-INF/views/cashier.jsp");
            dispatcher.forward(request, response);
        } else if (aux.getType() == 0) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(
                    "WEB-INF/views/client.jsp");
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

    private String checkId(String txt) {
        String r = txt;

        Pattern pat = Pattern.compile("([1-9,A])-?([0-9]{4})-?([0-9]{4})");
        Matcher m = pat.matcher(txt);
        if (m.find()) {
            r = String.format("%s%s%s", m.group(1), m.group(2), m.group(3));
        }

        return r;
    }

}
