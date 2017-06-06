/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.aventuriers;

import model.grille.*;
/**
 *
 * @author sarrasie
 */
public abstract class Aventurier {
    private roleAventuriers role;
    private String capacite;
    private String nomJ;
    private Tuile estSur;
    private Grille grille;
    
    public Aventurier(roleAventuriers r,String c,String nom){
        this.role = r;
        this.capacite = c;
        this.nomJ = nom;
    }
    public String getNom(){
        return nomJ;
    }

    public Tuile getEstSur() {
        return estSur;
    }
    
    
    public void setNom (String nom){
        this.nomJ = nom;
    }
    public void assecherTuile(){
        int posx = this.getEstSur().getNumLigne(); // on récupère la position du joueur
        int posy = this.getEstSur().getNumColonne();
        
        
    }
    public void seDeplacer(){
        
    }
    public void donnerCarteJoueur(){
        
    }
    private int getTuile(){
       return (estSur.getNumLigne()+estSur.getNumColonne());
    }
}
