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
import model.Favorite;

/**
 *
 * @author Erick
 */
public class FavoriteService {

    private static final String CMD_ADDFAVORITE = "insert into Favorite (id_user, id_account) values (?, ?)";

    private static final String CMD_LISTFAVORITESBYUSER = "select id_user, id_account from favorite where id_user=?";

    public List<Favorite> getAccounts(int userID) {

        List<Favorite> favoriteList = new ArrayList<>();

        try (Connection connection = getConnection();
                PreparedStatement stm = connection.prepareStatement(CMD_LISTFAVORITESBYUSER);) {
            stm.clearParameters();
            stm.setInt(1, userID);
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    Favorite favorite = new Favorite(
                            rs.getInt("id_user"),
                            rs.getInt("id_account")
                    );
                    favoriteList.add(favorite);
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return favoriteList;
    }

    public boolean createFavorite(int idUser, int idAccount) {
        try (Connection connection = getConnection();
                PreparedStatement stm = connection.prepareStatement(CMD_ADDFAVORITE);) {
            stm.clearParameters();

            stm.setInt(1, idUser);
            stm.setInt(2, idAccount);

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
