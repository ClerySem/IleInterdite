/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.cards;

import util.NomTuileEnum;

/**
 *
 * @author khelifza
 */
public class CarteInondation {
    
    private util.NomTuileEnum nomCarte;

    public CarteInondation(NomTuileEnum nomCarte) {
        this.nomCarte = nomCarte;
    }

    public NomTuileEnum getNomCarte() {
        return nomCarte;
    }

    public void setNomCarte(NomTuileEnum nomCarte) {
        this.nomCarte = nomCarte;
    }
    
}