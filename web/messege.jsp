

<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Raleway&display=swap" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bank Crosaint</title>
    </head>
    <jsp:useBean class="model.User" id="aux" scope="session">
    </jsp:useBean>

    <body>
        <div id="wrapper">
            <div id="content">
                <div id="menubar">
                    <ul>
                        <li class="nombre"><%= aux.getName()%></li>
                        <li><a href="depositmenu.jsp">Deposito</a></li>
                        <li><a href="retiremenu.jsp">Retiro</a></li>
                        <li><a href="transfermenu.jsp">Transferencias</a></li>
                        <li><a href="creditmenu.jsp">Acreditacion</a></li>
                        <li><a href="accountopening.jsp">Apertura de cuenta cliente</a></li>
                        <li><a href="usercreatemenu.jsp">Apertura de usuario</a></li>
                        <li><a href="accountupdate.jsp">Actualizar cuenta</a></li>
                    </ul>
                </div>
                        <%
                            String message = (String)request.getAttribute("message");
                        %>
                        <div id ="depositbox">
                    <div class="depContainer">
                        <form class="loginForm" action="RetireServlet">
                            <div class="box1">
                                <span>
                                   <%=message%>
                                </span>
                            </div>
                        </form>
                    </div>
                </div>

                <div id="main">

                </div>
            </div>
        </div>

    </body>
</html>
