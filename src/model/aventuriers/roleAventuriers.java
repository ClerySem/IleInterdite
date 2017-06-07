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
    pilote ("Pilote", Pion.BLEU, 2, 3),
    plongeur ("Plongeur", Pion.VIOLET, 1, 2),
    navigateur ("Navigateur", Pion.JAUNE, 1, 3),
    explorateur ("Explorateur", Pion.VERT, 2, 4),
    ingenieur ("Ingénieur", Pion.ROUGE, 0, 3),
    messager ("Messager", Pion.ORANGE, 2, 1);
    
    private final String nom;
    private final Pion pion;
    private final int coordonneesX;
    private final int coordonneesY;
    
    private roleAventuriers (String nom, Pion pion,int x , int y) {
        this.nom = nom;
        this.pion = pion;
        this.coordonneesX = x;
        this.coordonneesY = y;
    }

    public String getNom() {
        return nom;
    }

    public Pion getPion() {
        return pion;
    }

    public int getCoordonneesX() {
        return coordonneesX;
    }

    public int getCoordonneesY() {
        return coordonneesY;
    }
    
    
    
    
}
