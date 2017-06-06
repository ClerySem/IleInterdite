/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.aventuriers;

/**
 *
 * @author sarrasie
 */
public enum roleAventuriers {
    pilote ("Pilote"),
    plongeur ("Plongeur"),
    navigateur ("Navigateur"),
    explorateur ("Explorateur"),
    ingenieur ("Ingénieur"),
    messager ("Messager");
    
    private final String nom;

    private roleAventuriers (String nom ) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
    
    
}
