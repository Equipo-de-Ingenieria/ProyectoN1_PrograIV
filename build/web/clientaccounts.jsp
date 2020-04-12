
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
        <link href="css/clientaccounts.css" rel="stylesheet" type="text/css"/>
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
                            <li><a href="clientaccounts.jsp">Movimientos</a></li>
                        </ul>
                    </div> 

                    <div class="maincontents">
                        <div class="containerBox">
                            <div class="containerTable">
                                <table class ="table" id="accountsTable">
                                    <thead>
                                        <tr class="head">
                                            <th class="column1">ID</th>
                                            <th class="column2">Moneda</th>
                                            <th class="column3">Balance</th>
                                            <th class="column4">Tipo</th>
                                            <th class="column5">Limite de Transferencia</th>
                                            <th class="column6">Estado</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <!--
                                                                                <tr>
                                                                                    <td class="column1"> 1</td>
                                                                                    <td class="column2">Dolars</td>
                                                                                    <td class="column3">5000</td>
                                                                                    <td class="column4">Ahorro</td>
                                                                                    <td class="column5">1000000</td>   
                                                                                    <td class="column6">Activa</td>
                                                                                </tr>
                                        
                                        -->

                                    <%
                                        int index = 0;
                                        for (int i = 1; i <= accounts.size(); i++) {
                                            index = i - 1;

                                            out.println("<tr>");
                                            out.println(String.format("<td class=\"%s\"><a onclick=\"openModal(%d)\">%d</a></td>", "column1", accounts.get(index).getId(), accounts.get(index).getId()));
                                            out.println(String.format("<td class=\"%s\">%s</td>", "column2", accounts.get(index).getCurrencyName()));
                                            out.println(String.format("<td class=\"%s\">%f</td>", "column3", accounts.get(index).getBalance()));

                                            AccountTypeService serv = new AccountTypeService();
                                            String type = serv.getAccount(accounts.get(index).getAccountTypeID()).get().getDescription();

                                            out.println(String.format("<td class=\"%s\">%s</td>", "column4", type));
                                            out.println(String.format("<td class=\"%s\">%f</td>", "column5", accounts.get(index).getTransactionLimit()));

                                            String isActive = "Activa";
                                            if (accounts.get(index).getIsActive() == 0) {
                                                isActive = "Desactiva";
                                            }
                                            out.println(String.format("<td class=\"%s\">%s</td>", "column6", isActive));

                                        }
                                    %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>


                <div class="modal" id="movementModal">
                    <div class="modal-content">
                        <span class="closeBtn" onclick="closeModal()">X</span>
                    </div>
                </div>



            </div>
        </div>

        <script src="mainjs.js"></script>
        
    </body>
</html>
