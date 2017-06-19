/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.aventuriers;

import java.util.ArrayList;
import model.grille.Grille;
import model.grille.Tuile;
import util.Utils;

/**
 *
 * @author sarrasie
 */
public class Ingenieur extends Aventurier {

    public Ingenieur(Tuile positionDepart) {
        super(roleAventuriers.ingenieur, "capacite",positionDepart);
    }
  
        public void assecher2Tuiles(Tuile tuile1,Tuile tuile2){
            tuile1.setStatut(Utils.EtatTuile.ASSECHEE);
            tuile2.setStatut(Utils.EtatTuile.ASSECHEE);
            setNbaction(getNbaction()+1);
        }

    @Override
    public ArrayList<Tuile> RecupererTuile(Tuile position, Grille grille) {
        return super.RecupererTuile(position, grille); //To change body of generated methods, choose Tools | Templates.
    }
        
        
  }

