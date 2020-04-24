package model;

import java.io.Serializable;

public class User implements Serializable {

    private int id;
    private String userID;
    private String name;
    private String phone;
    private int type;
    private String password;

    public User(int id, String name, String phone, int type, String password, String userID) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.type = type;
        this.password = password;
        this.userID = userID;
    }

    public User(String name, String phone, int type, String password, String userID) {
        this.name = name;
        this.phone = phone;
        this.type = type;
        this.password = password;
        this.userID = userID;
    }

    public User(String name, String phone, int type, String userID) {
        this.userID = userID;
        this.name = name;
        this.phone = phone;
        this.type = type;
    }

    public User(String name) {
        this.name = name;
    }
    
  
    

    public User() {

    }

    //<editor-fold defaultstate="collapsed" desc="Geter and Setter">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
//</editor-fold>

    public void setUser(User aux) {
        this.id = aux.getId();
        this.name = aux.getName();
        this.phone = aux.getPhone();
        this.type = aux.getType();
        this.password = aux.getPassword();
        this.userID = aux.getUserID();
    }

}
