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
public class Explorateur extends Aventurier {
    private Grille grille;

    public Explorateur(Tuile positionDepart) {
        super(roleAventuriers.explorateur, "capacite",positionDepart);
    }
    
    
///////////////////////////DEPLACER+DIAGONALES//////////////////////////////////////
    @Override
    public ArrayList<Tuile> RecupererTuile(Tuile position, Grille grille) {
        ArrayList<Tuile> tuilesExp = new ArrayList<>();
        ArrayList<Tuile> tuilesFin = new ArrayList<>();
        tuilesFin = super.RecupererTuile(position, grille);
        int l = position.getNumLigne();
        int c = position.getNumColonne();
        
           //tuile hautGauche//
            if(c>=1 && l>=1){
                int cHGauche=c -1;
                int lHGauche=l - 1;
                tuilesExp.add(grille.getTuiles()[lHGauche][cHGauche]);
            }
            //tuile hautDroit//
            if(c<=4 && l>=1){
                int cHDroite=c +1;
                int lHDroite=l - 1;
                tuilesExp.add(grille.getTuiles()[lHDroite][cHDroite]);
            }
            //tuile basGauche//
            if(c>=1 && l<=4){
                int cBGauche=c -1;
                int lBGauche=l + 1;
                tuilesExp.add(grille.getTuiles()[lBGauche][cBGauche]);
            }
            //tuile basDroite//
            if (c<=4 && l<=4){
                int cBDroite=c +1;
                int lBDroite=l + 1;
                tuilesExp.add(grille.getTuiles()[lBDroite][cBDroite]);
            }
                
      for (Tuile tuile : tuilesExp) { //on ajoute toutes les tuiles sèche à tuilesFin
            if (tuile!=null && tuile.getStatut()==Utils.EtatTuile.ASSECHEE ){
                tuilesFin.add(tuile);
            }
      }
    return tuilesFin;
      }

    
    //////////////////////////////ASSECHER+DIAGONALES//////////////////////////////////////
    @Override
    public ArrayList<Tuile> AssecherTuile(Tuile position,Grille grille){  
         ArrayList<Tuile> tuilesExp = new ArrayList<>();
        ArrayList<Tuile> tuilesFin = new ArrayList<>();
        tuilesFin = super.AssecherTuile(position,grille);
        int l = position.getNumLigne();
        int c = position.getNumColonne();
        
        //tuile hautGauche//
        if(c>=1 && l>=1){
            int cHGauche=c -1;
            int lHGauche=l - 1;
            tuilesExp.add(grille.getTuiles()[lHGauche][cHGauche]);
        }
        //tuile hautDroit//
        if(c<=4 && l>=1){
            int cHDroite=c +1;
            int lHDroite=l - 1;
            tuilesExp.add(grille.getTuiles()[lHDroite][cHDroite]);
        }
        //tuile basGauche//
        if(c>=1 && l<=4){
            int cBGauche=c -1;
            int lBGauche=l + 1;
            tuilesExp.add(grille.getTuiles()[lBGauche][cBGauche]);
        }
        //tuile basDroite//
        if (c<=4 && l<=4){
            int cBDroite=c +1;
            int lBDroite=l + 1;
            tuilesExp.add(grille.getTuiles()[lBDroite][cBDroite]);
        }
          for (Tuile tuile : tuilesExp) {
            if (tuile!=null && tuile.getStatut()==Utils.EtatTuile.INONDEE  ){
                tuilesFin.add(tuile);
            }
         }
            return tuilesFin;
    }
}
    
    
    
    
   
    
   

