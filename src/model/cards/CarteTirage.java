/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.cards;

import util.Utils;

/**
 *
 * @author khelifza
 */
public class CarteTirage {
   
    private typeCarte type;
    private Utils.Tresor typeTresor;

    public CarteTirage(typeCarte type) {
        this.type = type;
    }
    public CarteTirage(Utils.Tresor typeTresor) {
        this.type = typeCarte.Carte_Tresor;
        this.typeTresor = typeTresor;
    }

    public typeCarte getType() {
        return type;
    }

    public void setType(typeCarte type) {
        this.type = type;
    }
   
}