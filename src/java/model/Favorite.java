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
public class Favorite implements Serializable{
    private int user, favorite;

    public Favorite(int user, int favorite) {
        this.user = user;
        this.favorite = favorite;
    }

    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
    public int getUser() {
        return user;
    }
    
    public void setUser(int user) {
        this.user = user;
    }
    
    public int getFavorite() {
        return favorite;
    }
    
    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }
//</editor-fold>
    
}
