/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;

import java.awt.Color;
import model.aventuriers.Aventurier;
import view.VueAventurier;

/**
 *
 * @author semanazc
 */
public class Controleur implements Observateur {
    private Aventurier aventurier;
    private VueAventurier vue;

    public Controleur() {
        ihm = new VueAventurier("Clery", aventurier.getRole().toString, Color.blue);
        
    }
    
    
}
