/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.aventuriers;

import util.Utils;
import util.Utils.Pion;

/**
 *
 * @author sarrasie
 */
public enum roleAventuriers {
    pilote ("Pilote", Pion.BLEU),
    plongeur ("Plongeur", Pion.VIOLET),
    navigateur ("Navigateur", Pion.JAUNE),
    explorateur ("Explorateur", Pion.VERT),
    ingenieur ("Ingénieur", Pion.ROUGE),
    messager ("Messager", Pion.ORANGE);

    
    private final String nom;
    private final Pion pion;
  
    
    private roleAventuriers (String nom, Pion pion) {
        this.nom = nom;
        this.pion = pion;
     
    }

    public String getNom() {
        return nom;
    }

    public Pion getPion() {
        return pion;
    }   
    
}
