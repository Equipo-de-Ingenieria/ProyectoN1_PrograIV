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
import model.User;

public class UserService {

    private static final String CMD_RECUPERAR
            = "SELECT id, name, phone, type, password, id_user FROM user WHERE id=? AND password=?; ";
    private static final String CMD_GET_USER_BY_ID = "SELECT id, name, phone, type, id_user FROM user WHERE id=? ";
    private static final String CMD_LISTAR
            = "SELECT id, apellidos, nombre FROM estudiante ORDER BY apellidos; ";
    private static final String CMD_CREATEUSER = "insert into User(name, phone, type, password, id_user) values (?, ?, ?, ?, ?)";
    private static final String CMD_UPDATE_PASSWORD = "update user set password = ?";
    private static final String CMD_GET_PASSWORD = "select password from user where id  = ?";

    public boolean createUser(User user) {
        try (Connection connection = getConnection();
                PreparedStatement stm = connection.prepareStatement(CMD_CREATEUSER)) {
            stm.clearParameters();

            stm.setString(1, user.getName());
            stm.setString(2, user.getPhone());
            stm.setInt(3, user.getType());
            stm.setString(4, user.getPassword());
            stm.setString(5, user.getUserID());

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

    public boolean updatePassword(String password) {
        try (Connection connection = getConnection();
                PreparedStatement stm = connection.prepareStatement(CMD_UPDATE_PASSWORD)) {
            stm.clearParameters();

            stm.setString(1, password);

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

    public Optional<User> getUser(String id, String password) {
        Optional<User> r = Optional.empty();
        try (Connection connection = getConnection();
                PreparedStatement stm = connection.prepareStatement(CMD_RECUPERAR);) {
            stm.clearParameters();

            stm.setInt(1, Integer.parseInt(id));
            stm.setString(2, password);

            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = Optional.of(new User(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("phone"),
                            rs.getInt("type"),
                            rs.getString("password"),
                            rs.getString("id_user")
                    ));
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return r;
    }

    public Optional<User> getPassword(int id) {
        Optional<User> r = Optional.empty();
        try (Connection connection = getConnection();
                PreparedStatement stm = connection.prepareStatement(CMD_GET_PASSWORD)) {
            stm.clearParameters();

            stm.setInt(1, id);

            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = Optional.of(new User(
                            null,
                            null,
                            0,
                            rs.getString("password"),
                            null
                    ));
                }
            }   

 
}
catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return r;
    }

    public Optional<User> getUserByID(int id) {
        Optional<User> r = Optional.empty();
        try (Connection connection = getConnection();
                PreparedStatement stm = connection.prepareStatement(CMD_GET_USER_BY_ID);) {
            stm.clearParameters();

            stm.setInt(1, id);

            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = Optional.of(new User(
                            rs.getString("name"),
                            rs.getString("phone"),
                            rs.getInt("type"),
                            rs.getString("id_user")
                    ));
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return r;
    }

    public List<User> getUserList() {
        List<User> r = new ArrayList<>();
        try (Connection connection = getConnection();
                Statement stm = connection.createStatement();
                ResultSet rs = stm.executeQuery(CMD_LISTAR)) {
            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getInt("type"),
                        rs.getString("password"),
                        rs.getString("id_user")
                );
                r.add(user);
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return r;
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

    public static void main(String[] args) {
        UserService us = new UserService();
        List<User> userAL = us.getUserList();
        int i = 0;
        for (User user : userAL) {
            System.out.printf("%4d: %s,%n", ++i, user);
        }
    }

}
