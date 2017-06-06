/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;

import static ile_interdite.TypesMessages.Deplacer;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import static javax.swing.UIManager.get;
import static javax.swing.UIManager.put;
import model.aventuriers.Aventurier;
import model.aventuriers.explorateur;
import model.aventuriers.roleAventuriers;
import static model.aventuriers.roleAventuriers.explorateur;
import model.grille.Grille;
import model.grille.Tuile;
import view.VueAventurier;

/**
 *
 * @author semanazc
 */
public class Controleur implements Observateur {
    
    private final VueAventurier vue;
    private HashMap<String,Aventurier> aventuriers;
    private Grille grille;
    

    public Controleur() {
        vue = new VueAventurier("Clery", "explorateur", Color.blue);
        grille= new Grille();
        
        vue.setObservateur(this);
        vue.affiche();
        
    }

    @Override
    public void traiterMessage(Message msg) {
        
        switch(msg.type){
            case Deplacer:
                vue.setPosition("deplacement réalisé");
                //...
            break;
            case Assecher:
                vue.setPosition("assechement tuile");
                //...
            break;
            case Autre:
                vue.setPosition("autre");
                //...
            break;
            case Terminer:
                vue.setPosition("terminer tour");
                //...
            break;
                
            
        }
       
    }
    
    public Tuile getPosition(Aventurier aventurier){
        Tuile position = aventurier.getEstSur();
        return position;
    }
    
    public int getLigne(Tuile position){
       int y =position.getNumLigne();
       return y;
    }
    
     public int getColonne(Tuile position){
       int x =position.getNumColonne();
       return x;
    }
     
     public ArrayList<Tuile> RecupererTuile(Tuile position){
        int y = getLigne(position);
        int x = getColonne(position);
        ArrayList<Tuile> tuiles = new ArrayList<>();
        ArrayList<Tuile> tuilesFin = new ArrayList<>();
        
        //tuile dessus//
        if (y>=1){
            int yDessus= y-1;
            int xDessus= x;
            tuiles.add(grille.getTuiles()[xDessus][yDessus]);
            
        }
        //tuile Dessous//
        if (y<=4){
            int yDessous= y+1;
            int xDessous= x;
            tuiles.add(grille.getTuiles()[xDessous][yDessous]);
        }
        //tuile gauche//
        if (x>=1){
            int yGauche= y;
            int xGauche= x-1;
            tuiles.add(grille.getTuiles()[xGauche][yGauche]);
        }
        //tuile droite//
        if (x<=4){
            int yDroite=y;
            int xDroite=x+1;
            tuiles.add(grille.getTuiles()[xDroite][yDroite]);
        }
           
        for (Tuile tuile : tuiles) {
            if (tuile!=null){
                tuilesFin.add(tuile);
            }
        }
       return tuilesFin;
     }
 
    

  
    

  
    
}
