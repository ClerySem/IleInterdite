/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.aventuriers;

import model.grille.*;
import util.Utils;
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
    private int nbaction;
    
    public Aventurier(roleAventuriers r,String c,String nom){
        this.role = r;
        this.capacite = c;
        this.nomJ = nom;
        this.nbaction = 0;
    }
    public String getNom(){
        return nomJ;
    }

    public Tuile getEstSur() {
        return estSur;
    }

    public int getNbaction() {
        return nbaction;
    }

    private int getTuile(){
       return (estSur.getNumLigne()+estSur.getNumColonne());
    }    
    
    public void setNom (String nom){
        this.nomJ = nom;
    }

    public void setEstSur(Tuile estSur) {
        this.estSur = estSur;
    }

    public void setNbaction(int nbaction) {
        this.nbaction = nbaction;
    }
    
    //Les methodes qui suivent sont les actions réalisées par l'aventurier
    
    public void assecherTuile(Tuile tuile){
        tuile.setStatut(Utils.EtatTuile.ASSECHEE);
        setNbaction(getNbaction() + 1);
    }
    
    public void seDeplacer(Tuile tuile){
        setEstSur(tuile);
        tuile.ajouterAventurier(this);
        setNbaction(getNbaction() + 1);
    }
    
    public void donnerCarteJoueur(){
        
    }

}
