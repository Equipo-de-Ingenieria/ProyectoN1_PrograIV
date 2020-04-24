<%-- 
   Document   : index
   Created on : Mar 7, 2020, 8:09:44 PM
   Author     : erick
--%>

<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/client.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Raleway&display=swap" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bank Crosaint</title>
        <jsp:useBean class="model.User" id="aux" scope="session">
        </jsp:useBean>
        <%
            User aux1 = (User) request.getAttribute("userData");
            aux.setUser(aux1);
        %>

    </head>
    <body>
        <div id="wrapper">
            <div id="content">
                <div id="menubar">
                    <ul>
                        <li class="nombre"><jsp:getProperty name="aux" property="name"></jsp:getProperty></li>
                        <li><a href="clientaccounts.jsp">Cuentas</a></li>
                        <li><a href="syncmenu.jsp">Vinculacion de cuentas</a></li>
                        <li><a href="clienttransfermenu.jsp">Transferencia remota</a></li>
                        <li><a href="movements.jsp">Movimientos</a></li>
                    </ul>
                </div>

                <div id="main">

                </div>
            </div>
        </div>

    </body>
</html>
