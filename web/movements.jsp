
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
        <link href="css/movements.css" rel="stylesheet" type="text/css"/>
        <meta charset="UTF-8">

    </head>
    <body>
        <jsp:useBean class="model.User" id="aux" scope="session">
        </jsp:useBean>

        <%
            AccountService service = new AccountService();
            List<Account> accounts = service.getAccounts(aux.getId());
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
                            <li><a href="password-change.jsp">Cambiar Constraseña</a></li>
                        </ul>
                    </div> 

                    <div class="maincontents">
                        <div class="containerBox">
                            <div class="containerFields">
                                <form class="formBox" action="client-movement">
                                    <div class="boxTitle1">
                                        <span>
                                            <strong>
                                                Consultar
                                            </strong>
                                        </span>
                                    </div>



                                    <div class="selectBox">
                                        <select class="select" name="accountID"  required>
                                            <option value="" disabled selected hidden>
                                                Cuenta a Consultar
                                            </option>

                                        <%
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



                                <div class="buttonBox">
                                    <button class="submitBtn" type="submit">
                                        Buscar
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
