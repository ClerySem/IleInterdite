/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.aventuriers;

import model.grille.Tuile;

/**
 *
 * @author sarrasie
 */
public abstract class Aventurier {
    private roleAventuriers role;
    private String capacite;
    private String nomJ;
    private Tuile estSur;
    
    public Aventurier(roleAventuriers r,String c,String nom){
        this.role = r;
        this.capacite = c;
        this.nomJ = nom;
    }
    public String getNom(){
        return nomJ;
    }
    public void setNom (String nom){
        this.nomJ = nom;
    }
    public void assecherTuile(){
        /*recuperer 4 tuiles et creer 4 tuile et mettre manuellement la position */
        Tuile tuile1 = new Tuile(4,5);
        Tuile
    }
    public void seDeplacer(){
        
    }
    public void donnerCarteJoueur(){
        
    }
    private int getTuile(){
       return (estSur.getNumLigne()+estSur.getNumColonne());
    }
}
