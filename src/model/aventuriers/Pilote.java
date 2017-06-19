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
public class Pilote extends Aventurier {

    private boolean avole = false;
    private boolean veutVoler = false;

    public Pilote(Tuile positionDepart, boolean avole) {
        super(roleAventuriers.pilote, "capacite", positionDepart);
        this.avole = avole;

    }

    public void voler(Tuile tuile) {
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
    @Override
    public ArrayList<Tuile> RecupererTuile(Tuile position, Grille grille){
        
        ArrayList<Tuile> tuilespilote = new ArrayList<>();
        ArrayList<Tuile> tuilesFin = new ArrayList<>();

        if (!getAvole() && getVeutVoler()) {
            setAvole(true);
           
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    tuilespilote.add(grille.getTuiles()[i][j]);
                }
            }
            for (Tuile tuile : tuilespilote) {
               
                if(tuile != null && tuile.getStatut() == Utils.EtatTuile.ASSECHEE && tuile !=getEstSur()){
                    tuilesFin.add(tuile);
                }
            }
          
        }else if (getAvole()&&getVeutVoler()) {
            System.err.println("Erreur vous avez déjà volé");
            
        }else{
            tuilesFin= super.RecupererTuile(position, grille);
        }
       
        
        /*System.out.println("les tuiles dispo sont : ");
        for (Tuile tuile : tuilespilote) {
            System.out.println(tuile.getNom());
        }*/
        setVeutVoler(false);
        return tuilesFin;
    }

    

    /**
     * @return the veutVoler
     */
    public boolean getVeutVoler() {
        return veutVoler;
    }

    /**
     * @param veutVoler the veutVoler to set
     */
    public void setVeutVoler(boolean veutVoler) {
        this.veutVoler = veutVoler;
    }
    
    
}


