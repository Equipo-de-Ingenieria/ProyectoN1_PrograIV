/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import data.DataBase;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import model.Transfer;

/**
 *
 * @author Erick
 */
public class TransferService {

    private static final String CREATETRANSFER = "insert into Transfer(depositor_account, creditor_account, amount, date, detail) values (?, ?, ?, ?, ?, ?)";
    private static final String LISTTRANSFERSBYDEPOSITIOR = "select depositor_account, creditor_account, amount, date, detail from transfer where depositor_account = ?";
    private static final String LISTTRANSFERSBYDECREDITOR = "select depositor_account, creditor_account, amount, date, detail from transfer where creditor_account = ?";

    public List<Transfer> getDepositorTransfers(int depositorID) {

        List<Transfer> transfersDepositor = new ArrayList<>();

        try (Connection connection = getConnection();
                PreparedStatement stm = connection.prepareStatement(LISTTRANSFERSBYDEPOSITIOR)) {
            stm.clearParameters();
            stm.setInt(1, depositorID);
            
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    Transfer transfer = new Transfer(
                            rs.getInt("id"),
                            rs.getInt("depositior_account"),
                            rs.getInt("creditor_account"),
                            rs.getDouble("amount"),
                            rs.getDate("date"),
                            rs.getString("detail")
                    );
                    transfersDepositor.add(transfer);
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return transfersDepositor;
    }

    public List<Transfer> getCreditorTransfers(int creditorID) {

        List<Transfer> transfersDepositor = new ArrayList<>();

        try (Connection connection = getConnection();
                PreparedStatement stm = connection.prepareStatement(LISTTRANSFERSBYDECREDITOR)) {
            stm.clearParameters();
            stm.setInt(1, creditorID);
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    Transfer transfer = new Transfer(
                            rs.getInt("id"),
                            rs.getInt("depositior_account"),
                            rs.getInt("creditor_account"),
                            rs.getDouble("amount"),
                            rs.getDate("date"),
                            rs.getString("detail")
                    );
                    transfersDepositor.add(transfer);
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return transfersDepositor;
    }

    public boolean createTransfer(Transfer transfer) {
        try (Connection connection = getConnection();
                PreparedStatement stm = connection.prepareStatement(CREATETRANSFER)) {
            stm.clearParameters();
       
            stm.setInt(1, transfer.getDepositorAccount());
            stm.setInt(2, transfer.getCreditorAccount());
            stm.setDouble(3, transfer.getAmount());
            stm.setDate(4, transfer.getDate());
            stm.setString(5, transfer.getDetail());

            /* Los inserts se hacen con execute vs execute query*/
                  if (stm.executeUpdate() != -1) {
                return true;
            }


        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());

        }
        return false;

    }

    public Connection getConnection() throws
            ClassNotFoundException,
            IllegalAccessException,
            InstantiationException,
            IOException,
            SQLException {
        DataBase db = DataBase.getInstance();
        Properties cfg = db.getConfig();
        Connection connection = db.getConnection(
                cfg.getProperty("database"),
                cfg.getProperty("user"),
                cfg.getProperty("password")
        );
        return connection;
    }

}
