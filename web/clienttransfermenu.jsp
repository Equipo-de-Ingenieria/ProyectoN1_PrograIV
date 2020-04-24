<%-- 
   Document   : index
   Created on : Mar 7, 2020, 8:09:44 PM
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
        AccountService accService = new AccountService();
        FavoriteService favService = new FavoriteService();
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
                            <li><a href="password-change.jsp">Cambiar Constraseña</a></li>
                        </ul>
                    </div> 

                    <div class="maincontents">
                        <div class="containerBox">
                            <div class="containerFields">
                                <form class="formBox" action="client-transfer">
                                    <div class="boxTitle1">
                                        <span>
                                            <strong>
                                                Transferencias
                                            </strong>
                                        </span>
                                    </div>

                                    <div class="selectBox">

                                        <select class="select" name="debitSelect"  required>
                                            <option value="" disabled selected hidden>
                                                Cuenta debitar
                                            </option>

                                        <%
                                            List<Account> accounts = accService.getAccounts(aux.getId());

                                            if (!accounts.isEmpty()) {
                                                String formatActive = "<option name value=\"%d\">%d</option>";
                                                String formatInactive = "<option value=\"\" disabled selected hidden>%d</option>";

                                                for (Account account : accounts) {
                                                    switch (account.getIsActive()) {
                                                        case 0:
                                                            out.println(String.format(formatInactive, account.getId()));
                                                            break;

                                                        case 1:
                                                            out.println(String.format(formatActive, account.getId(), account.getId()));
                                                            break;

                                                        default:
                                                            out.println("");
                                                            break;
                                                    }
                                                }

                                            }


                                        %>

                                    </select>

                                </div>

                                <div class="selectBox">
                                    <select class="select" name="creditSelect" value="Cuenta Acreditar" required>
                                        <option value="" disabled selected hidden>
                                            Cuenta Acreditar
                                        </option>

                                        <%                                           
                                            List<Favorite> favorites = favService.getAccounts(aux.getId());

                                            if (!favorites.isEmpty()) {
                                                String format = "<option value=\"%d\">%d</option>";

                                                for (Favorite favorite : favorites) {
                                                    out.println(String.format(format, favorite.getFavorite(), favorite.getFavorite()));
                                                }

                                            }

                                        %>


                                    </select>

                                </div>

                                <div class="inputBox">
                                    <span>
                                        <input type="text" name="detailInput" placeholder="Detalle"  />
                                    </span>
                                </div>

                                <div class="inputBox">
                                    <span>
                                        <input type="number" name="amountInput" placeholder="Monto" />
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
