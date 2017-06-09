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
    private boolean avole;

    public Pilote(Tuile positionDepart,boolean avole) {
        super(roleAventuriers.pilote, "capacite",positionDepart);
        this.avole=avole;

    }
    
   
    
    public void voler(Tuile tuile){
        setEstSur(tuile);
        tuile.ajouterAventurier(this);
        setNbaction(getNbaction() + 1);
    }

    /**
     * @return the avole
     */
    public boolean getAvole() {
        return avole;
    }

    /**
     * @param avole the avole to set
     */
    public void setAvole(boolean avole) {
        this.avole = avole;
    }
}


   
                

                

