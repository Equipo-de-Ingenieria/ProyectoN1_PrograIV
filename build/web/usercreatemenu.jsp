

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/accountopening.css" rel="stylesheet" type="text/css"/>
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
                        <form class="loginForm" action="CreateUser">
                            <div class="box1">
                                <span>
                                    Crear usuario
                                </span>
                            </div>

                            <div class="box2">
                                <span>
                                    <input class="user" type="number" placeholder="Cedula" name="cedula" required />
                                </span>

                                <span> 
                                    <input class="password"  placeholder="Nombre completo" name="nombre" required/>
                                </span>
                                <span> 
                                    <input class="password"  placeholder="Telefono" name="telefono" required/>
                                </span>
                                <span> 
                                <!--<label class = "type">Tipo</label>-->
                                <select class = "change" name = "tipo">
                                    <option value="1" style="text-align: center">Cliente</option>
                                    <option value="0" style="text-align: center">Cajero</option>
                                </select>
                                </span>
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
