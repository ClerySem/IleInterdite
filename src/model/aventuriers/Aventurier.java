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
    private final String capacite;
    private String nomJ;
    private Tuile estSur;
    private int nbaction;
    
    public Aventurier(roleAventuriers role ,String capacite, Tuile estSur){
        this.role = role;
        this.capacite = capacite;
        this.nbaction = 1;
        this.estSur = estSur;
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

    public roleAventuriers getRole() {
        return role;
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

    public void setRole(roleAventuriers role) {
        this.role = role;
    }
    
   
    
}
