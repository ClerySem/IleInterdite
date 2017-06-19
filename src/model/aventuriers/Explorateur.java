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
public class Explorateur extends Aventurier {
    private Grille grille;

    public Explorateur(Tuile positionDepart) {
        super(roleAventuriers.explorateur, "capacite",positionDepart);
    }
    
    

    @Override
    public ArrayList<Tuile> RecupererTuile(Tuile position, Grille grille) {
        ArrayList<Tuile> tuilesExp = new ArrayList<>();
        tuilesExp = super.RecupererTuile(position, grille);
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
      
    return tuilesExp;
    }

    @Override
    public void Afficher(ArrayList<Tuile> tuiles) {
        tuiles=RecupererTuile(getEstSur(),grille);
          System.out.println("Les tuiles sur lesquels vous pouvez vous déplacer sont : ");
        
                String positionPossible = "";
                if (!tuiles.isEmpty()){ //Si il y a des tuiles sur lesquels ont peut se déplacer
                        for(int k = 0; k < tuiles.size() - 1; k++){
                            positionPossible += (tuiles.get(k).getNumLigne()+","+tuiles.get(k).getNumColonne()+" ou ");
                        }
                    positionPossible += tuiles.get(tuiles.size()-1).getNumLigne()+","+tuiles.get(tuiles.size()-1).getNumColonne();
                   
                }else{
                    positionPossible = "Impossible de se déplacer";
                }
                System.out.println(positionPossible);
     }
    }
    
    
    
    
   
    
   

