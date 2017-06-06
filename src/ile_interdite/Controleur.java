/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;

import static ile_interdite.TypesMessages.Deplacer;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import model.aventuriers.Aventurier;
import model.aventuriers.Explorateur;
import model.aventuriers.Ingenieur;
import model.aventuriers.roleAventuriers;
import static model.aventuriers.roleAventuriers.explorateur;
import model.grille.Grille;
import model.grille.Tuile;
import view.VueAventurier;
import util.Utils;
import model.aventuriers.*;


/**
 *
 * @author semanazc
 */
public class Controleur implements Observateur {
    
    private final VueAventurier vue;
    private HashMap<String,Aventurier> aventuriers;
    private Grille grille;
    private ArrayList<String> nomsJoueurs;
    

    public Controleur() {
        
        demarrerPartie();
        
        
        vue.setObservateur(this);
        vue.affiche();
        
    }

    @Override
    public void traiterMessage(Message msg) {
        
        switch(msg.type){
            case Deplacer:
                vue.setPosition("deplacement réalisé");
                //...
            break;
            case Assecher:
                vue.setPosition("assechement tuile");
                //...
            break;
            case Autre:
                vue.setPosition("autre");
                //...
            break;
            case Terminer:
                vue.setPosition("terminer tour");
                //...
            break;
                
            
        }
       
    }
    
    public void demarrerPartie() {
        grille = new Grille();
        
        //to-do : récuperer les noms des différents joueurs, pour le moment je les aient initialisés à la main,
        
        getNomsJoueurs().add("Gaspard");
        getNomsJoueurs().add("Eddy");
        getNomsJoueurs().add("Clery");
        getNomsJoueurs().add("Sacha");
        
        //creation des aventuriers
        
        Explorateur explorateur = new Explorateur();
        Ingenieur ingenieur = new Ingenieur();
        Messager messager = new Messager();
        Navigateur navigateur = new Navigateur();
        Pilote pilote = new Pilote();
        Plongeur plongeur = new Plongeur();
        
        ArrayList<Aventurier> listeaventuriersjouables = new ArrayList();
        listeaventuriersjouables.add(explorateur);
        listeaventuriersjouables.add(ingenieur);
        listeaventuriersjouables.add(messager);
        listeaventuriersjouables.add(navigateur);
        listeaventuriersjouables.add(pilote);
        listeaventuriersjouables.add(plongeur);
        Collections.shuffle((List<?>) listeaventuriersjouables);
        
        
        for (int k = 0; k < 5; k++){ //comme il y a 4 joueurs on ajoute 4 aventuriers à notre collection aventuriers
              listeaventuriersjouables.get(k).setNom(getNomsJoueurs().get(k)); // on donne un nom à l'aventurier
            getAventuriers().put(getNomsJoueurs().get(k), listeaventuriersjouables.get(k)); // on l'ajoute à aventuriers
        }pions.get(i)
        
       
                


        //Creation de la vue des joueurs
                
        
        
/*        aventuriers.forEach((nomjoueur, aventurier) -> {
            setVue(nomjoueur, aventurier.getRole().getNom(), aventurier.getCouleur()); 
            
        }); */
                
    }
    public Tuile getPosition(Aventurier aventurier){
        Tuile position = aventurier.getEstSur();
        return position;
    }
    
    public int getLigne(Tuile position){
       int y =position.getNumLigne();
       return y;
    }
    
     public int getColonne(Tuile position){
       int x =position.getNumColonne();
       return x;
    }
     
     public ArrayList<Tuile> RecupererTuile(Tuile position){
        int y = getLigne(position);
        int x = getColonne(position);
        ArrayList<Tuile> tuiles = new ArrayList<>();
        ArrayList<Tuile> tuilesFin = new ArrayList<>();
        
        //tuile dessus//
        if (y>=1){
            int yDessus= y-1;
            int xDessus= x;
            tuiles.add(grille.getTuiles()[xDessus][yDessus]);
            
        }
        //tuile Dessous//
        if (y<=4){
            int yDessous= y+1;
            int xDessous= x;
            tuiles.add(grille.getTuiles()[xDessous][yDessous]);
        }
        //tuile gauche//
        if (x>=1){
            int yGauche= y;
            int xGauche= x-1;
            tuiles.add(grille.getTuiles()[xGauche][yGauche]);
        }
        //tuile droite//
        if (x<=4){
            int yDroite=y;
            int xDroite=x+1;
            tuiles.add(grille.getTuiles()[xDroite][yDroite]);
        }
           
        for (Tuile tuile : tuiles) {
            if (tuile!=null && tuile.getStatut()!=Utils.EtatTuile.INONDEE ){
                tuilesFin.add(tuile);
            }
        }
       return tuilesFin;
     }
     
     
     public ArrayList<Tuile> AssecherTuile(Tuile position){
        int y = getLigne(position);
        int x = getColonne(position);
        ArrayList<Tuile> tuiles = new ArrayList<>();
        ArrayList<Tuile> tuilesFin = new ArrayList<>();
        
        
        //tuile du joueur//
        tuiles.add(grille.getTuiles()[x][y]);
        //tuile dessus//
        if (y>=1){
            int yDessus= y-1;
            int xDessus= x;
            tuiles.add(grille.getTuiles()[xDessus][yDessus]);
            
        }
        //tuile Dessous//
        if (y<=4){
            int yDessous= y+1;
            int xDessous= x;
            tuiles.add(grille.getTuiles()[xDessous][yDessous]);
        }
        //tuile gauche//
        if (x>=1){
            int yGauche= y;
            int xGauche= x-1;
            tuiles.add(grille.getTuiles()[xGauche][yGauche]);
        }
        //tuile droite//
        if (x<=4){
            int yDroite=y;
            int xDroite=x+1;
            tuiles.add(grille.getTuiles()[xDroite][yDroite]);
        }
           
        for (Tuile tuile : tuiles) {
            if (tuile!=null && tuile.getStatut()==Utils.EtatTuile.INONDEE ){
                tuilesFin.add(tuile);
            }
        }
       return tuilesFin;
     }
     
     public void afficherGrille(){
         for (int i = 0; i <6; i ++) {
             for (int k = 0; k <6; k++) {
                 System.out.print(" | " +grille.getTuiles()[i][k].getNom() + " | ");
            }
             System.out.print("\n");
         }
     }

    public ArrayList<String> getNomsJoueurs() {
        return nomsJoueurs;
    }

    public HashMap<String, Aventurier> getAventuriers() {
        return aventuriers;
    }

    public void setVue(String nomJoueur, String nomAventurier, Color couleur) {
       this.vue = new VueAventurier(nomJoueur, nomAventurier, couleur);
    }
    
    
  
    
}
