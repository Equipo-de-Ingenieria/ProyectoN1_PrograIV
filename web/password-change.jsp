<%-- 
    Document   : password-change
    Created on : Apr 24, 2020, 10:40:39 AM
    Author     : Erick
--%>


<%@page import="model.AccountType"%>
<%@page import="services.AccountTypeService"%>
<%@page import="java.util.List"%>
<%@page import="model.Account"%>
<%@page import="model.User"%>
<%@page import="services.AccountService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://fonts.googleapis.com/css?family=Raleway&display=swap" rel="stylesheet">
        <link href="css/clienttransfermenu.css" rel="stylesheet" type="text/css"/>
        <meta charset="UTF-8">

        <jsp:useBean class="model.User" id="aux" scope="session">
        </jsp:useBean>

    </head>
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
                        <li><a href="password-change.jsp">Cambiar Constraseña</a></li>
                    </ul>
                </div>  

                <div class="maincontents">
                    <div class="containerBox">
                        <div class="containerFields">
                            <form class="formBox" action="PasswordChange" method="post">
                                <div class="boxTitle1">
                                    <span>
                                        <strong>
                                            Cambio de Constraseña
                                        </strong>
                                    </span>
                                </div>

                                <div class="inputBox">
                                    <span>
                                        <input type="password" name="current-password" placeholder="Contraseña actual"  />
                                    </span>
                                </div>
                                
                                <div class="inputBox">
                                    <span>
                                        <input type="password" name="new-password" placeholder="Contraseña nueva"  />
                                    </span>
                                </div>

                                <div class="buttonBox">
                                    <button class="submitBtn" type="submit">
                                        Confirmar
                                    </button>
                                </div>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

