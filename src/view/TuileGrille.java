/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;

/**
 *
 * @author sarrasie
 */
public class TuileGrille extends JButton {
    
    private int ligne;
    private int colonne;

    public TuileGrille(int ligne, int colonne) {
        this.ligne = ligne;
        this.colonne = colonne;
    }

    
    public int getLigne() {
        return ligne;
    }

   
    public int getColonne() {
        return colonne;
    }

    

    
}
