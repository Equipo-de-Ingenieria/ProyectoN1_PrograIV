

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
                <div id ="depositbox">
                    <div class="depContainer">
                        <form class="loginForm" action="UserInfo">
                            <div class="box1">
                                <span>
                                    Menu transferencia
                                </span>
                            </div>

                            <div class="box2">
                                <span>
                                    <input class="user" type="number" placeholder="Cuenta depositante" name="userInput" required />
                                </span>
                                <span>
                                    <input class="user" type="number" placeholder="Cuenta acreditante" name="userInput" required />
                                </span>
                                <span> 
                                    <input class="password"  placeholder="Nombre completo" name="passInput" required/>
                                </span>

                                <span> 
                                    <input class="password" type="password" placeholder="Monto" name="passInput" required/>
                                </span>
                            </div>

                            <div class="box3">
                                <span>
                                    <button class="summitBtn" type="submit">Transferir</button>
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
