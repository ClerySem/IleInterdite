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

    private boolean avole;

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

    public ArrayList<Tuile> RecupererTuileVole(Tuile position, Grille grille) throws Exception  {

        ArrayList<Tuile> tuilespilote = new ArrayList<>();

        int l = position.getNumLigne();
        int c = position.getNumColonne();

        
        Exception aDejaVoleException = new Exception();
        if (!getAvole()) {
            setAvole(true);
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    tuilespilote.add(grille.getTuiles()[i][j]);
                }
            }
            for (Tuile tuile : tuilespilote) {
                if(tuile != null && tuile.getStatut() == Utils.EtatTuile.ASSECHEE && tuile !=getEstSur()){
                    tuilespilote.add(tuile);
                }
            }
            
        }
        else if (getAvole()) {
            System.err.println("Erreur vous avez déjà volé");
            throw aDejaVoleException;
        }
        System.out.println("les tuiles dispo sont : ");
        for (Tuile tuile : tuilespilote) {
            System.out.println(tuile.getNom());
        }
        
        return tuilespilote;
    }

    @Override
    public void Afficher(ArrayList<Tuile> tuiles) {
        
    }
    
    
}


