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
import model.Currency;

/**
 *
 * @author Extreme PC
 */
public class CurrencyService {

    private final static String CMD_GET_CURRENCY_BY_ID = "select name, exchange_rate_buy, exchange_rate_sale, symbol from currency where name=? ";

    public Optional<Currency> getCurrency(String name) {
        Optional<Currency> currencyOptional = Optional.empty();

        try (Connection connection = getConnection();
                PreparedStatement stm = connection.prepareStatement(CMD_GET_CURRENCY_BY_ID);) {
            stm.clearParameters();
            stm.setString(1, name);

            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    currencyOptional = Optional.of(new Currency(
                            rs.getString("name"),
                            rs.getDouble("exchange_rate_buy"),
                            rs.getDouble("exchange_rate_sale"),
                            rs.getString("symbol")
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
        return currencyOptional;
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
