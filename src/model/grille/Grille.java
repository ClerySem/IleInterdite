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
    
    
    private HashMap<String, Tuile> tuiles;
    private final int [] grille = new int[36];

    public Grille() {
        for (int i=1; i< grille.length; i++){
            grille[i]= tuiles.get();
        }
    }
    
    
    
    
    
    
    
    
}
