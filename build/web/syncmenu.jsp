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
        <link href="css/client.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Raleway&display=swap" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bank Crosaint</title>
        <jsp:useBean class="model.User" id="aux" scope="session">
        </jsp:useBean>

    </head>
    <body>
        <div id="wrapper">
            <div id="content">
                <div id="menubar">
                    <ul>
                        <li class="nombre"><%= aux.getName()%></li>
                        <li><a href="accountmenu.jsp">Cuentas</a></li>
                        <li><a href="syncmenu.jsp">Vinculacion de cuentas</a></li>
                        <li><a href="clienttransfermenu.jsp">Transferencia remota</a></li>
                    </ul>
                </div>
                <div id ="depositbox">
                    <div class="depContainer">
                        <form class="loginForm" action="UserInfo">
                            <div class="box1">
                                <span>
                                    Menu de vinculacion
                                </span>
                            </div>

                            <div class="box2">
                                <span>
                                    <input class="user" type="number" placeholder="Cuenta a vincular" name="userInput" required />
                                </span>
                            </div>

                            <div class="box3">
                                <span>
                                    <button class="summitBtn" type="submit">Vincular</button>
                                </span>
                            </div>
                        </form>
                    </div>
                </div>
                <div id="main">

                </div>
            </div>
            <div id="main">

            </div>
        </div>
    </div>

</body>
</html>
