
<%@page import="services.UserService"%>
<%@page import="java.util.Optional"%>
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
        <link href="css/sync.css" rel="stylesheet" type="text/css"/>
        <meta charset="UTF-8">

    </head>
    <body>
        <jsp:useBean class="model.User" id="aux" scope="session">
        </jsp:useBean>

        <jsp:useBean class="model.User" id="user" scope="session">
        </jsp:useBean>
        <jsp:setProperty property="*" name="user"/> 

        <jsp:useBean class="model.Account" id="account" scope="session">
        </jsp:useBean>
        <jsp:setProperty property="*" name="account"/> 




        <%

            User temp = (User) request.getAttribute("userSearched");
            Account temp2 = (Account) request.getAttribute("accountData");

            user.setUser(new User(""));
            account.setAccount(new Account());

            if (temp != null && account != null) {
                user.setUser(temp);
                account.setAccount(temp2);

            }

        %>


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
                                <form class="formBox" action="Sync">
                                    <div class="boxTitle1">
                                        <span>
                                            <strong>
                                                Vinculacion de Cuentas
                                            </strong>
                                        </span>
                                    </div>

                                    <div class="boxInput">
                                        <span>
                                            <input type="number" name="accountID" placeholder="Numero de Cuenta" value="<jsp:getProperty name="account" property="id"></jsp:getProperty>" required/>
                                        </span>
                                    </div>

                                    <div class="boxTitle2">
                                        <span>

                                        </span>
                                    </div>

                                    <div class="boxLabel">
                                        <span>
                                        <jsp:getProperty name="user" property="name"></jsp:getProperty>
                                        </span>
                                    </div>

                                    <div class="boxButtons">
                                        <span>

                                            <button  type="submit" name="searchBtn" value="search">
                                                Buscar
                                            </button>

                                            <button type="submit" name="addBtn" value="add">
                                                Agregar
                                            </button>
                                        </span>
                                    </div>

                                    <div class="boxInput">
                                        <span>
                                            <input type="hidden" name="mainUserID" value="<jsp:getProperty name="aux" property="id"></jsp:getProperty>" required/>
                                        </span>
                                    </div>
                                    <div class="boxInput">
                                        <span>
                                            <input type="hidden" name="accountID" value="<jsp:getProperty name="account" property="id"></jsp:getProperty>" required/>
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
