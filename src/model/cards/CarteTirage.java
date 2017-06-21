/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.cards;

/**
 *
 * @author khelifza
 */
public class CarteTirage {
    
    private typeCarte type;

    public CarteTirage(typeCarte type) {
        this.type = type;
    }

    public typeCarte getType() {
        return type;
    }

    public void setType(typeCarte type) {
        this.type = type;
    }
}
