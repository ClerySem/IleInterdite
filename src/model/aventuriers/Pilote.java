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
public class Pilote extends Aventurier {

    public Pilote(Tuile positionDepart) {
        super(roleAventuriers.pilote, "capacite");
        this.setEstSur(positionDepart);

    }
    
   
    
    public void voler(){
        
    }
}
