package model;

import java.io.Serializable;
import java.sql.Date;

public class Transfer implements Serializable {

    private int id;
    private int depositorAccount;
    private int creditorAccount;
    private double amount;
    private Date date;

    public Transfer(int id, int depositorAccount, int creditorAccount, double amount, Date date) {
        this.id = id;
        this.depositorAccount = depositorAccount;
        this.creditorAccount = creditorAccount;
        this.amount = amount;
        this.date = date;
    }

    public Transfer(int depositorAccount, int creditorAccount, double amount, Date date) {
        this.depositorAccount = depositorAccount;
        this.creditorAccount = creditorAccount;
        this.amount = amount;
        this.date = date;
    }

//<editor-fold defaultstate="collapsed" desc="Getter and Setter">
    public Transfer() {
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getDepositorAccount() {
        return depositorAccount;
    }
    
    public void setDepositorAccount(int depositorAccount) {
        this.depositorAccount = depositorAccount;
    }
    
    public int getCreditorAccount() {
        return creditorAccount;
    }
    
    public void setCreditorAccount(int creditorAccount) {
        this.creditorAccount = creditorAccount;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
//</editor-fold>

}
