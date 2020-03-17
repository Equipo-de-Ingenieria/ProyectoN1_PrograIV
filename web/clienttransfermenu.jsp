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
                        <li><a href="clientaccounts.jsp">Movimientos</a></li>
                    </ul>
                </div>
                <div id ="depositbox">
                    <div class="depContainer">
                        <form class="loginForm" action="UserInfo">
                            <div class="box1">
                                <span>
                                    Menu transferencias
                                </span>
                            </div>

                            <div class="box2">
                                <span>
                                    <input class="user" type="number" placeholder="Cuenta a depositar" name="userInput" required />
                                </span>
                                <span>
                                    <input class="user" type="number" placeholder="Cuenta a acreditar" name="userInput" required />
                                </span>
                                <span> 
                                    <input class="password"  placeholder="Nombre completo" name="passInput" required/>
                                </span>
                                <span> 
                                    <input class="password"  type = "number"placeholder="Monto" name="passInput" required/>
                                </span>
                            </div>

                            <div class="box3">
                                <span>
                                    <button class="summitBtn" type="submit">Acreditar</button>
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
