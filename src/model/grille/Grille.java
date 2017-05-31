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
    
    
    private int [][] tuiles;


    public Grille() {
        this.tuiles = new int [6][6];
        for(int i =0; i< tuiles.length; i++){;
            int [] colonne = new int[6];
            for(int j =0; j< colonne.length; j++){
                this.tuiles[i][j] = new Tuile(i,j);
            }
        }
    }
    
    
    
    
    
    
    
    
}
