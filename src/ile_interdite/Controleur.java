/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;

import java.awt.Color;
import java.util.HashMap;
import model.aventuriers.Aventurier;
import model.aventuriers.explorateur;
import model.aventuriers.roleAventuriers;
import static model.aventuriers.roleAventuriers.explorateur;
import view.VueAventurier;

/**
 *
 * @author semanazc
 */
public class Controleur implements Observateur {
    private Aventurier aventurier;
    private final VueAventurier vue;

    public Controleur() {
        vue = new VueAventurier("Clery", "explorateur", Color.blue);
        aventurier = new explorateur(explorateur,"rr");
        vue.setObservateur(this);
        vue.affiche();
    }

    @Override
    public void traiterMessage(Message msg) {
        String joueur;
        
        switch(msg.type){
            case Deplacer:
                System.out.println("deplacement réalisé");
                //...
            break;
            case Assecher:
                System.out.println("assechement tuile");
                //...
            break;
            case Autre:
                System.out.println("autre pute");
                //...
            break;
            case Terminer:
                System.out.println("terminer tour");
                //...
            break;
                
            
        }
    }

    private static class Explorateur {

        public Explorateur(roleAventuriers roleAventuriers, String rr) {
        }
    }
    
    
}
