/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Extreme PC
 */
public class Account_type implements Serializable{
    private int id;
    private double interest;
    private String description;

    public Account_type(int id, double interest, String description) {
        this.id = id;
        this.interest = interest;
        this.description = description;
    }

    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public double getInterest() {
        return interest;
    }
    
    public void setInterest(double interest) {
        this.interest = interest;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
//</editor-fold>
    
}
