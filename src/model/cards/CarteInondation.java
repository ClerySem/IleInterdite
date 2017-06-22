/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.cards;

import model.grille.Tuile;
import util.NomTuileEnum;

/**
 *
 * @author khelifza
 */
public class CarteInondation {
    
    private util.NomTuileEnum nomCarte;
    

    
    //constructeur
    public CarteInondation(NomTuileEnum nomCarte) {
        /*
        this.nomCarte = nomCarte;
        this.tuile = tuile;
        */
        setNomCarte(nomCarte);
       
    }

    //rend nom des cartes
    public NomTuileEnum getNomCarte() {
        return nomCarte;
    }
    
    //setter du nom des cartes
    public void setNomCarte(NomTuileEnum nomCarte) {
        this.nomCarte = nomCarte;
    }

    
    
}