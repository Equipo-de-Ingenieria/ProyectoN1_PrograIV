package model;

import java.io.Serializable;

public class Account implements Serializable {

    private int id, accountTypeID;
    private double balance;
    private int userId;
    private String currencyName;
    private double transactionLimit;
    private int isActive;

    public Account(int id, double balance, int userId, String currencyName, int accountTypeID, double transactionLimit, int isActive) {
        this.id = id;
        this.accountTypeID = accountTypeID;
        this.balance = balance;
        this.userId = userId;
        this.currencyName = currencyName;
        this.transactionLimit = transactionLimit;
        this.isActive = isActive;
    }

    public Account(double balance, int userId, String currencyName, int accountTypeID, double transactionLimit, int isActive) {
        this.accountTypeID = accountTypeID;
        this.balance = balance;
        this.userId = userId;
        this.currencyName = currencyName;
        this.transactionLimit = transactionLimit;
        this.isActive = isActive;
    }

    public Account() {
    }

    public Account(int id, double transactionLimit, int isActive) {
        this.id = id;
        this.transactionLimit = transactionLimit;
        this.isActive = isActive;
    }

    
    

    
    
//<editor-fold defaultstate="collapsed" desc="Getter and Setters">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountTypeID() {
        return accountTypeID;
    }

    public void setAccountTypeID(int accountTypeID) {
        this.accountTypeID = accountTypeID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public double getTransactionLimit() {
        return transactionLimit;
    }

    public void setTransactionLimit(double transactionLimit) {
        this.transactionLimit = transactionLimit;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }
//</editor-fold>

}
