/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;

import java.util.ArrayList;
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
    private final ArrayList<String> joueurs;
    
    public Message(Utils.Commandes commande, Integer idAventurier, Integer idCarte,  Utils.Tresor tresor, Integer idTuile) {
        this.commande = commande ;
        this.idAventurier = idAventurier ;
        this.idCarte = idCarte ;
        this.tresor = tresor ;
        this.idTuile = idTuile ;
        this.joueurs = null;
    }

    public Message() {
        this.commande = Utils.Commandes.VALIDER_JOUEURS ;
        this.idAventurier = null ;
        this.idCarte = null ;
        this.tresor = null ;
        this.idTuile = null ;
        this.joueurs = new ArrayList<>();
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
    
    public void addJoueur(String joueur) {
        getJoueurs().add(joueur);
    }
    
    public ArrayList<String> getJoueurs() {
        return joueurs;
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
