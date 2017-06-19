/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.aventuriers;

import java.util.ArrayList;
import java.util.HashSet;
import model.grille.Grille;
import model.grille.Tuile;
import util.Utils;

/**
 *
 * @author sarrasie
 */
public class Plongeur extends Aventurier{

    public Plongeur(Tuile positionDepart) {
        super(roleAventuriers.plongeur, "capacite",positionDepart);

    }

    
    public void deplacementPlongeur(Tuile anciennePosition,Tuile position, HashSet<Tuile> tuilesPlongeur,Grille grille){
        
        int l = position.getNumLigne();
        int c = position.getNumColonne();
        
        ArrayList<Tuile> tuiles = new ArrayList<>();
        
        //tuile dessus//
        if (l>=1){
            int cDessus= c;
            int lDessus= l - 1;
            tuiles.add(grille.getTuiles()[lDessus][cDessus]);
        }
        //tuile Dessous//
        if (l<=4){
            int cDessous= c;
            int lDessous= l + 1;
            tuiles.add(grille.getTuiles()[lDessous][cDessous]);
        }
        //tuile gauche//
        if (c>=1){
            int cGauche= c -1 ;
            int lGauche= l;
            tuiles.add(grille.getTuiles()[lGauche][cGauche]);
        }
        //tuile droite//
        if (c<=4){
            int cDroite=c + 1;
            int lDroite=l;
            tuiles.add(grille.getTuiles()[lDroite][cDroite]);
        }

            for(Tuile tuile : tuiles){
                if (tuile!=null && tuile.getStatut()==Utils.EtatTuile.ASSECHEE){ //si la tuile autour de lui est seche alors on ajoute la tuile
                    tuilesPlongeur.add(tuile);
                } else if ((tuile!=null && tuile.getStatut()==Utils.EtatTuile.INONDEE || tuile!=null && tuile.getStatut()==Utils.EtatTuile.COULEE)
                            && !anciennePosition.equals(tuile)){ // si la tuile est innondée au coulée on ajoute les tuiles sèches autours
                    
                    deplacementPlongeur(position,tuile,tuilesPlongeur,grille);
                }
            }

    }
    @Override
    public ArrayList<Tuile> RecupererTuile(Tuile position, Grille grille) {
       
        ArrayList<Tuile> tuilesPlongeurFin = new ArrayList<>();
        tuilesPlongeurFin = super.RecupererTuile(position, grille);
        HashSet<Tuile> tuilesPlongeur = new HashSet<>();
        deplacementPlongeur(position, position, tuilesPlongeur,grille);
            
            for (Tuile tuile : tuilesPlongeur){
                if(!position.equals(tuile)) tuilesPlongeurFin.add(tuile);
            }
    
            return tuilesPlongeurFin;
        }
    
    
    
 
    
    
}
