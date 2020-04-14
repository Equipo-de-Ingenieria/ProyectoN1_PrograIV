<%-- 
   Document   : index
   Created on : Apr 2, 2020, 10:09:44 PM
   Author     : erick
--%>

<%@page import="model.Favorite"%>
<%@page import="java.util.List"%>
<%@page import="model.Account"%>
<%@page import="services.FavoriteService"%>
<%@page import="services.AccountService"%>
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/clienttransfermenu.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Raleway&display=swap" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bank Crosaint</title>
        <jsp:useBean class="model.User" id="aux" scope="session">
        </jsp:useBean>
    </head>

    <%
        String message = (String) request.getAttribute("message");
    %>

    <body>
        <div class="wrapper">
            <div class="subwrapper">
                <div class="menubar">
                    <ul>
                        <li class="nombre"><jsp:getProperty name="aux" property="name"></jsp:getProperty></li>
                            <li><a href="clientaccounts.jsp">Cuentas</a></li>
                            <li><a href="syncmenu.jsp">Vinculacion de cuentas</a></li>
                            <li><a href="clienttransfermenu.jsp">Transferencia remota</a></li>
                            <li><a href="movements.jsp">Movimientos</a></li>
                        </ul>
                    </div> 

                    <div class="maincontents">
                        <div class="containerBox">
                            <div class="containerFields">
                                <form class="formBox" action="client-transfer">
                                    <div class="boxTitle1">
                                        <span>
                                            <strong>
                                            <%=message%>
                                        </strong>
                                    </span>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
