/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.aventuriers;

/**
 *
 * @author sarrasie
 */
public abstract class Aventurier {
    private roleAventuriers role;
    private String capacite;
    
    public Aventurier(roleAventuriers r,String c){
        this.role = r;
        this.capacite = c;
    }
    public roleAventuriers getRole(){
        return role;
    }
    public void setRole(roleAventuriers r){
        this.role = r;
    }
    public void assecherTuile(){
        
    }
    public void seDeplacer(){
        
    }
    public void donnerCarteJoueur(){
        
    }
}
