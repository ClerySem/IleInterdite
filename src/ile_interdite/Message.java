/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;

import util.Utils;

/**
 *
 * @author semanazc
 */
public class Message {
    //Liste des types de message
    public TypesMessages type; //type de message
    public String texte;
    private final Utils.Commandes commande ;
    private final Integer idAventurier ;
    private final Integer idCarte ;
    private final  Utils.Tresor tresor ;
    private final Integer idTuile ;
    
    public Message(Utils.Commandes commande, Integer idAventurier, Integer idCarte,  Utils.Tresor tresor, Integer idTuile) {
        this.commande = commande ;
        this.idAventurier = idAventurier ;
        this.idCarte = idCarte ;
        this.tresor = tresor ;
        this.idTuile = idTuile ;
    }

    /**
     * @return the commande
     */
    public Boolean hasCommande() {
        return commande != null ;
    }
    public Utils.Commandes getCommande() {
        return commande;
    }

    /**
     * @return the idAventurier`
     */
    public Boolean hasIdAventurier() {
        return idAventurier != null ;
    }
    public Integer getIdAventurier() {
        return idAventurier;
    }

    /**
     * @return the idCarte
     */
    public Boolean hasIdCarte() {
        return idCarte != null ;
    }
    public Integer getIdCarte() {
        return idCarte;
    }

    /**
     * @return the tresor
     */
    public Boolean hasTresor() {
        return tresor != null ;
    }
    public  Utils.Tresor getTresor() {
        return tresor;
    }

    /**
     * @return the idTuile
     */
    public Boolean hasIdTuile() {
        return idTuile != null;
    }
    public Integer getIdTuile() {
        return idTuile;
    }
    
    @Override
    public String toString() {
        String txt = "" ;
        txt += commande.toString() + " " ;
        if (hasIdAventurier()) {
            txt += " aventurier=" + idAventurier ;
        }
        if (hasIdCarte()) {
            txt += " carte=" + idCarte ;
        }
        if (hasIdTuile()) {
            txt += " tuile=" + idTuile ;
        }
        if (hasTresor()) {
            txt += " tresor=" + tresor.toString() ;
        }
        return txt ;
    }
}
