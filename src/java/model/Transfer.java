package model;

import java.io.Serializable;
import java.sql.Date;

public class Transfer implements Serializable {

    private int id;
    private int depositorAccount;
    private int creditorAccount;
    private double amount;
    private Date date;
    private String detail;

    public Transfer(int id, int depositorAccount, int creditorAccount, double amount, Date date, String detail) {
        this.id = id;
        this.depositorAccount = depositorAccount;
        this.creditorAccount = creditorAccount;
        this.amount = amount;
        this.date = date;
        this.detail = detail;
    }

    public Transfer(int depositorAccount, int creditorAccount, double amount, Date date, String detail) {
        this.depositorAccount = depositorAccount;
        this.creditorAccount = creditorAccount;
        this.amount = amount;
        this.date = date;
        this.detail = detail;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
//</editor-fold>

}
