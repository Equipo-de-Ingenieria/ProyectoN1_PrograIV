

<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/accountopening.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Raleway&display=swap" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bank Crosaint</title>
    </head>
    <jsp:useBean class="model.User" id="aux" scope="session">
    </jsp:useBean>
    <% Account acc = null;
    %>
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
                <div id ="depositbox">
                    <div class="depContainer">
                        <form class="loginForm" action="CreateAcc">
                            <div class="box1">
                                <span>
                                    Crear cuenta
                                </span>
                            </div>
                            
                            <div class="box2">
                                <span>
                                    <input type="number"class="user" type="number" placeholder="ID Usuario" name="idUsuario" required />
                                </span>

                                <span> 
                                    <input type="number" class="number"  placeholder="Transaccion limite" name="limite" required/>
                                </span>

                                <select class = "change" name = "cambio">
                                    <option value="USD" style="text-align: center">Dolar</option>
                                    <option value="CRC" style="text-align: center">Colon</option>
                                    <option value="EUR" style="text-align: center">Euro</option>
                                </select>

                                <select class = "change" name = "tipoCuenta">
                                    <option value="0" style="text-align: center"> Corriente</option>
                                    <option value="1" style="text-align: center">Ahorro</option>
                                </select>
                            </div>

                            <div class="box3">
                                <span>
                                    <button class="summitBtn" type="submit">Crear</button>
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
