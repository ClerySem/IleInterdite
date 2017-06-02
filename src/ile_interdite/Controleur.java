/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;

import static ile_interdite.TypesMessages.Deplacer;
import java.awt.Color;
import java.util.HashMap;
import static javax.swing.UIManager.get;
import static javax.swing.UIManager.put;
import model.aventuriers.Aventurier;
import model.aventuriers.explorateur;
import model.aventuriers.roleAventuriers;
import static model.aventuriers.roleAventuriers.explorateur;
import model.grille.Grille;
import view.VueAventurier;

/**
 *
 * @author semanazc
 */
public class Controleur implements Observateur {
    private Aventurier aventurier;
    private final VueAventurier vue;
    private HashMap<String,Aventurier> aventuriers;
    private Grille grille;

    public Controleur() {
        vue = new VueAventurier("Clery", "explorateur", Color.blue);
        aventurier = new explorateur(explorateur,"rr");
        grille= new Grille();
        
        vue.setObservateur(this);
        vue.affiche();
        put(aventurier,explorateur);
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

    private static class Explorateur {

        public Explorateur(roleAventuriers roleAventuriers, String rr) {
        }
    }
  
    
}
