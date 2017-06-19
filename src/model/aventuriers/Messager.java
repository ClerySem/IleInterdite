/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.aventuriers;

import java.util.ArrayList;
import model.grille.Grille;
import model.grille.Tuile;

/**
 *
 * @author sarrasie
 */
public class Messager extends Aventurier {
    
    public Messager(Tuile positionDepart) {
        super(roleAventuriers.messager, "capacite",positionDepart);

    }
    
    @Override
    public void seDeplacer(Tuile tuile){
        super.seDeplacer(tuile);
    }

    @Override
    public ArrayList<Tuile> RecupererTuile(Tuile position, Grille grille) {
        return super.RecupererTuile(position, grille); //To change body of generated methods, choose Tools | Templates.
    }
    
    
  
}
