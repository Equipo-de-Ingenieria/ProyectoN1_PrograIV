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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import javax.swing.JOptionPane;
import model.Account;

/**
 *
 * @author Erick
 */
public class AccountService {

    private static final String CMD_CREATEACCOUNT = "insert into Account (balance, user_id, currency_name, account_type_id, transaction_limit, is_active) values (?, ?, ?, ?, ?, ?)";

    private static final String CMD_GETACCOUNTSBYUSERID = "select id, balance, user_id, currency_name, account_type_id, transaction_limit, is_active from account where user_id=?;";
    private static final String CMD_GETACCOUNTBYID = "select id, balance, user_id, currency_name, account_type_id, transaction_limit, is_active from account where id=? ";

    private static final String CMD_UPDATEACCOUNTBYACCOUNTIDALL= "update account set transaction_limit=?, is_active=?, balance=? where id=?";
        private static final String CMD_UPDATEACCOUNTBYACCOUNTID = "update account set transaction_limit=?, is_active=?  where id=?";

    public boolean createAccount(Account account) {
        try (Connection connection = getConnection();
                PreparedStatement stm = connection.prepareStatement(CMD_CREATEACCOUNT);) {
            stm.clearParameters();

            stm.setDouble(1, account.getBalance());
            stm.setInt(2, account.getUserId());
            stm.setString(3, account.getCurrencyName());
            stm.setInt(4, account.getAccountTypeID());
            stm.setDouble(5, account.getTransactionLimit());
            stm.setInt(6, account.getIsActive());

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

    public Optional<Account> getAccount(String accountID) {
        Optional<Account> r = Optional.empty();

        try (Connection connection = getConnection();
                PreparedStatement stm = connection.prepareStatement(CMD_GETACCOUNTBYID);) {
            stm.clearParameters();
            stm.setString(1, accountID);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = Optional.of(new Account(
                            rs.getInt("id"),
                            rs.getDouble("balance"),
                            rs.getInt("user_id"),
                            rs.getString("currency_name"),
                            rs.getInt("account_type_id"),
                            rs.getDouble("transaction_limit"),
                            rs.getInt("is_active")
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
        return r;
    }

    public List<Account> getAccounts(int userID) {
        List<Account> accountList = new ArrayList<>();
        try (Connection connection = getConnection();
                Statement stm = connection.createStatement();
                ResultSet rs = stm.executeQuery(CMD_GETACCOUNTSBYUSERID)) {
            while (rs.next()) {
                Account account = new Account(
                        rs.getInt("id"),
                        rs.getDouble("balance"),
                        rs.getInt("user_id"),
                        rs.getString("currency_name"),
                        rs.getInt("account_type_id"),
                        rs.getDouble("transaction_limit"),
                        rs.getInt("is_active")
                );
                accountList.add(account);
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return accountList;
    }

    public boolean updateAllAccount(int id, double transactionLimit, int isActive, double balance) {
        try (Connection connection = getConnection();
                PreparedStatement stm = connection.prepareStatement(CMD_UPDATEACCOUNTBYACCOUNTIDALL)) {
            stm.clearParameters();
            stm.setDouble(1, transactionLimit);
            stm.setInt(2, isActive);
            stm.setDouble(3, balance);
            stm.setInt(4, id);

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
    public boolean updateAccount(int id, double transactionLimit, int isActive) {
        try (Connection connection = getConnection();
                PreparedStatement stm = connection.prepareStatement(CMD_UPDATEACCOUNTBYACCOUNTID)) {
            stm.clearParameters();

            stm.setDouble(1, transactionLimit);
            stm.setInt(2, isActive);
            stm.setInt(3, id);
 

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
