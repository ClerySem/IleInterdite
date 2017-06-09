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
        super(roleAventuriers.pilote, "capacite",positionDepart);

    }
    
   
    
    public void voler(Tuile tuile){
        setEstSur(tuile);
        tuile.ajouterAventurier(this);
        setNbaction(getNbaction() + 1);
    }
}


    /*if (aventuriers.get("Gaspard").getRole()==pilote){
                    if (!msg.texte.equals("")){
                        String Texte = msg.texte;


                        String[] positionString;
                        positionString = Texte.split(",");
                        int[] position = new int[2];
                        position[0] = Integer.parseInt(positionString[0]);
                        position[1] = Integer.parseInt(positionString[1]);

                        //if (!tuilesAutours.contains(grille.getTuiles()[position[0]][position[1]])){System.out.println("Deplacement impossible");}else{
                        aventuriers.get("Gaspard").seDeplacer(getGrille().getTuiles()[position[0]][position[1]]);
                     }*/
                

                

