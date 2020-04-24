/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Movement;
import model.Transfer;
import services.TransferService;

/**
 *
 * @author Erick
 */
@WebServlet(
        name = "MovementServlet",
        urlPatterns = {"/Movement", "/client-movement"}
)
public class movementSrv extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String strAccount;
        TransferService transferService;
        int accountID;
        List<Transfer> depositorTrans;
        List<Transfer> creditorTrans;
        List<Movement> movements;

        strAccount = request.getParameter("accountID");
        transferService = new TransferService();
        accountID = Integer.parseInt(strAccount);

        depositorTrans = transferService.getDepositorTransfers(accountID);
        creditorTrans = transferService.getCreditorTransfers(accountID);
        movements = new ArrayList();
        
        if(!depositorTrans.isEmpty()){
            for(Transfer transfer : depositorTrans){
                movements.add(new Movement(transfer.getDate(), transfer.getAmount(), 0.0, transfer.getId(), transfer.getDetail()));
            }
        }
        
        if(!creditorTrans.isEmpty()){
            for(Transfer transfer : creditorTrans){
                movements.add(new Movement(transfer.getDate(), 0.0, transfer.getAmount(), transfer.getId(), transfer.getDetail()));
            }
        }
        
        
        request.setAttribute("movementsList", movements);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "movementDisplay.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doGet(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    protected void doPost(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
