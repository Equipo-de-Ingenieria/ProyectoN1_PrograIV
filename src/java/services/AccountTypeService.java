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
import java.util.Optional;
import java.util.Properties;
import javax.swing.JOptionPane;
import model.AccountType;

/**
 *
 * @author erick
 */
public class AccountTypeService {

    public final static String CMD_READ_INTEREST_RATE_BY_TYPEID = "select  id, description, interest_rate from account_type where id=?";

    public Optional<AccountType> getAccount(int typeID) {
        Optional<AccountType> accountOptional = Optional.empty();

        try (Connection connection = getConnection();
                PreparedStatement stm = connection.prepareStatement(CMD_READ_INTEREST_RATE_BY_TYPEID)) {
            stm.clearParameters();
            stm.setInt(1, typeID);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    accountOptional = Optional.of(new AccountType(
                            rs.getInt("id"),
                            rs.getString("description"),
                            rs.getDouble("interest_rate")
                    ));
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return accountOptional;
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
