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
    
    
    private Tuile [][] tuiles;


    public Grille() {
        this.tuiles = new Tuile [6][6];
        for(int i =0; i< tuiles.length; i++){;
            int [] colonne = new int[6];
            for(int j =0; j< colonne.length; j++){
                if (       i == 0 && j == 0
                        || i == 0 && j == 1
                        || i == 0 && j == 4
                        || i == 0 && j == 5 // toutes les cases vides de la première ligne
                        || i == 1 && j == 0 
                        || i == 1 && j == 5 // toutes les cases vides de la 2eme ligne
                        || i == 4 && j == 0
                        || i == 4 && j == 5 // toutes les cases vides de la 5eme ligne
                        || i == 5 && j == 0
                        || i == 5 && j == 1
                        || i == 5 && j == 4
                        || i == 5 && j == 5 // toutes les cases vides de la 6eme ligne
                        ) {
                    this.tuiles[i][j] = null;
                } else {                    // les tuiles non vide 
                    this.tuiles[i][j] = new Tuile(i,j);
                    
                }
            }
        }
    }
    
    public Tuile[][] getTuiles(){
        return tuiles;
    }
   
    
    
    
    
    
    
}
