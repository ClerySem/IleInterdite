/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.grille;

import static model.grille.Statut.sèche;

/**
 *
 * @author anthoing
 */
public class Tuile {
    private String nom;
    private Statut statut;
    private int numLigne;
    private int numColonne;

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the numLigne
     */
    public int getNumLigne() {
        return numLigne;
    }

    /**
     * @param numLigne the numLigne to set
     */
    public void setNumLigne(int numLigne) {
        this.numLigne = numLigne;
    }

    /**
     * @return the numColonne
     */
    public int getNumColonne() {
        return numColonne;
    }

    /**
     * @param numColonne the numColonne to set
     */
    public void setNumColonne(int numColonne) {
        this.numColonne = numColonne;
    }
    public boolean EstSeche(){
            return this.statut == sèche;    
    }
    
}


 