/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author erick
 */
public class Currency implements Serializable {

    private String name, symbol;
    private double buy, sell;

    public Currency(String name, double buy, double sell, String symbol) {
        this.name = name;
        this.symbol = symbol;
        this.buy = buy;
        this.sell = sell;
    }

    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getBuy() {
        return buy;
    }

    public void setBuy(double buy) {
        this.buy = buy;
    }

    public double getSell() {
        return sell;
    }

    public void setSell(double sell) {
        this.sell = sell;
    }
//</editor-fold>

}
