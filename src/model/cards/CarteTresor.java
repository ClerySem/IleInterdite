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
public class CarteTresor extends CarteTirage{
    
    private Utils.Tresor tresor;//identifier les 4 différents types de tresor

    //constructeur
    public CarteTresor(Utils.Tresor typetresor, typeCarte type) {
        super(type);
        this.tresor = typetresor;
    }

    //rend le type de tresor
    public Utils.Tresor getTresor() {
        return tresor;
    }

    //setter du tresor
    public void setTresor(Utils.Tresor tresor) {
        this.tresor = tresor;
    }
    
    
}
