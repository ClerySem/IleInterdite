/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;

import java.awt.Color;
import java.util.HashMap;
import model.aventuriers.Aventurier;
import view.VueAventurier;

/**
 *
 * @author semanazc
 */
public class Controleur implements Observateur {
    private HashMap<NomAventurier, Aventurier> aventuriers;
    private VueAventurier vue;

    public Controleur() {
        vue = new VueAventurier("Clery", "explorateur", Color.blue);
        aventurier = new Explorateur();
        vue.setObservateur(this);
        vue.affiche();
    }

    @Override
    public void traiterMessage(Message msg) {
        String joueur;
        int n 
    }
    
    
}
