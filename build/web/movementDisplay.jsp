
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
                            <div class="containerTable">
                                <table class ="table">
                                    <thead>
                                        <tr class="head">
                                            <th class="column1">Fecha</th>
                                            <th class="column2">Débito</th>
                                            <th class="column3">Crédito</th>
                                            <th class="column4">Comprobante</th>
                                            <th class="column6">Descripción</th>
                                        </tr>
                                    </thead>

                                    <tbody>

                                    <%
                                        List <model.Movement> movementsList =  (java.util.ArrayList <model.Movement>) request.getAttribute("movementsList");
                    
                                        
                                        int index = 0;
                                        for (int i = 1; i <= movementsList.size(); i++) {
                                            index = i - 1;

                                            out.println("<tr>");
                                            out.println(String.format("<td class=\"%s\">%s</td>", "column1", movementsList.get(index).getDate()));
                                            out.println(String.format("<td class=\"%s\">%f</td>", "column2", movementsList.get(index).getDebit()));
                                            out.println(String.format("<td class=\"%s\">%f</td>", "column3", movementsList.get(index).getCredit()));

                                            out.println(String.format("<td class=\"%s\">%d</td>", "column4", movementsList.get(index).getId()));
                                            out.println(String.format("<td class=\"%s\">%s</td>", "column6", movementsList.get(index).getDescription()));

                                        }

                                    %>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
