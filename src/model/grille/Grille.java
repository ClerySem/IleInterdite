/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.grille;

import java.util.HashMap;

/**
 *
 * @author anthoing
 */
public class Grille {
    
    private int numLigne;
    private int numColonne;
    private HashMap<,Tuile> tuiles;
    
    
    public int getNumLigne() {
        return numLigne;
    }

    public void setNumLigne(int numLigne) {
        this.numLigne = numLigne;
    }

    public int getNumColonne() {
        return numColonne;
    }

    public void setNumColonne(int numColonne) {
        this.numColonne = numColonne;
    }
    
    
}
