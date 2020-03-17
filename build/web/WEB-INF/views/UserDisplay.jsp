<%-- 
    Document   : UserDisplay
    Created on : Mar 11, 2020, 10:12:01 PM
    Author     : erick
--%>

<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Display Usuario</title>
        <link href="./css/default.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
            <header>
                <h1>Registro Usuario</h1>
                <h2>Datos generales</h2>
            </header>
            <div id="contents">
                <div class="info">
                    <%
                        User user = (User) request.getAttribute("userData");
                        if (user != null) {
                    %>

                    <table class="tablaDatos">
                        <tr>
                            <td class="col1">Id:</td>
                            <td class="col2"><%= user.getId()%>
                        </tr>
                        <tr>
                            <td class="col1">Name:</td>
                            <td class="col2"><%= user.getName()%>
                        </tr>
                        <tr>
                            <td class="col1">Phone:</td>
                            <td class="col2"><%= user.getPhone()%>
                        </tr>

                        <tr>
                            <td class="col1">Type:</td>
                            <td class="col2"><%= user.getType()%>
                        </tr>
                        
                        <tr>
                            <td class="col1">Password:</td>
                            <td class="col2"><%= user.getPassword()%>
                        </tr>
                    </table>

                    <%
                    } else {
                        String id = request.getParameter("userInput");
                        if ((id != null) && !id.isEmpty()) {
                    %>

                    <p class="mensajeError">
                        No se encuentra el registro para el (la) estudiante
                        con la identificación: <strong><%= id%></strong>.
                    </p>

                    <%
                    } else {
                    %>

                    <p class="mensajeError">
                        No se indicó la identificación del(la) estudiante a consultar.
                    </p>

                    <%
                            }
                        }
                    %>   
                </div>
            </div>
            <footer></footer>
        </div>
    </body>
</html>