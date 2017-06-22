/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.grille;

import java.util.ArrayList;
import javax.swing.JButton;
import model.aventuriers.Aventurier;
import util.Utils;
import static util.Utils.EtatTuile.*;



/**
 *
 * @author anthoing
 */
public class Tuile extends JButton {
    private String nom;
    private Utils.EtatTuile statut;
    private int numLigne;
    private int numColonne;
    private ArrayList<Aventurier> possede;
    private boolean possedeTresor = false;

    public Tuile(int numLigne , int numColonne) {
       
       this.numLigne = numLigne;
       this.numColonne =numColonne;
       if (numLigne == 0 && numColonne ==2){
           this.nom = "Le Pont Des Abimes";
           this.statut = ASSECHEE;
       }
       if (numLigne == 0 && numColonne ==3){
           this.nom = "La Porte De Bronze";
           this.statut = COULEE;
       }
       if (numLigne == 1 && numColonne ==1){
           this.nom = "La Caverne Des Ombres";
           this.statut = ASSECHEE;
           //a un tresor
           this.possedeTresor= true;
       }
       if (numLigne == 1 && numColonne ==2){
           this.nom = "La Porte De Fer";
           this.statut = ASSECHEE;
       }
       if (numLigne == 1 && numColonne ==3){
           this.nom = "La Porte d'Or";
           this.statut = ASSECHEE;
       }
       if (numLigne == 1 && numColonne ==4){
           this.nom = "Les Falaises De L'Oubli";
           this.statut = ASSECHEE;
       }
       if (numLigne == 2 && numColonne ==0){
           this.nom = "Le Palais De Corail";
           this.statut = ASSECHEE;
           //a un tresor
           this.possedeTresor= true;
       }
       if (numLigne == 2 && numColonne ==1){
           this.nom = "La Porte d'Argent";
           this.statut = ASSECHEE;
       }
       if (numLigne == 2 && numColonne ==2){
           this.nom = "Les Dunes De L'Illusion";
           this.statut = COULEE;
       }
       if (numLigne == 2 && numColonne ==3){
           this.nom = "Heliport";
           this.statut = ASSECHEE;
       }
       if (numLigne == 2 && numColonne ==4){
           this.nom = "La Porte De Cuivre";
           this.statut = ASSECHEE;
       }
       if (numLigne == 2 && numColonne ==5){
           this.nom = "Le Jardin Des Hurlements";
           this.statut = ASSECHEE;
           //a un tresor
           this.possedeTresor= true;
       }
       if (numLigne == 3 && numColonne ==0){
           this.nom = "La Foret Pourpre";
           this.statut = ASSECHEE;
       }
       if (numLigne == 3 && numColonne ==1){
           this.nom = "Le Lagon Perdu";
           this.statut = INONDEE;
       }
       if (numLigne == 3 && numColonne ==2){
           this.nom = "Le Marais Brumeux";
           this.statut = COULEE;
       }
       if (numLigne == 3 && numColonne ==3){
           this.nom = "Observatoire";
           this.statut = INONDEE;
       }
       if (numLigne == 3 && numColonne ==4){
           this.nom = "Le Rocher Fantome";
           this.statut = COULEE;
       }
       if (numLigne == 3 && numColonne ==5){
           this.nom = "La Caverne Du Brasier";
           this.statut = INONDEE;
           //a un tresor
           this.possedeTresor= true;
       }
       if (numLigne == 4 && numColonne ==1){
           this.nom = "Le Temple Du Soleil";
           this.statut = ASSECHEE;
           //a un tresor
           this.possedeTresor= true;
       }
       if (numLigne == 4 && numColonne ==2){
           this.nom = "Le Temple De La Lune";
           this.statut = COULEE;
           //a un tresor
           this.possedeTresor= true;
       }
       if (numLigne == 4 && numColonne ==3){
           this.nom = "Le Palais Des Marais";
           this.statut = ASSECHEE;
           //a un tresor
           this.possedeTresor= true;
       }
       if (numLigne == 4 && numColonne ==4){
           this.nom = "Le Val Du Crepuscule";
           this.statut = ASSECHEE;
       }
       if (numLigne == 5 && numColonne ==2){
           this.nom = "La Tour Du Guet";
           this.statut = ASSECHEE;
       }
       if (numLigne == 5 && numColonne ==3){
           this.nom = "Le Jardin Des Murmures";
           this.statut = INONDEE;
           //a un tresor
           this.possedeTresor= true;
       }
       this.possede = new ArrayList<>();
       
    }

   
    //////////////////////GET_SET_NOM//////////////////////
     public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
    //////////////////////GET_SET_LIGNE/////////////////////
    public int getNumLigne() {
        return numLigne;
    }
    public void setNumLigne(int numLigne) {
        this.numLigne = numLigne;
    }

    
    //////////////////////GET_SET_COLONNE/////////////////////
    public int getNumColonne() {
        return numColonne;
    }
    public void setNumColonne(int numColonne) {
        this.numColonne = numColonne;
    }

    
    
    
    //////////////////////GET_SET_STATUT/////////////////////
    public Utils.EtatTuile getStatut() {
        return statut;
    }
    public void setStatut(Utils.EtatTuile statut) {
        this.statut = statut;
    }

    
    
   /////////////////////// TUILE SECHE? /////////////////////
    public boolean EstSeche(){
            return this.getStatut() == ASSECHEE;    
    }
    
    
    ////////////////////AJOUTER UN AVENTURIER A UNE LISTE///////////////////////
    public void ajouterAventurier(Aventurier aventurier){
        getPossede().add(aventurier);
    }
    //////////////////RETOURNE ARRAYLIST AVENTURIER////////////////////////////////////////////////
    public ArrayList<Aventurier> getPossede() {
        return possede;
    }
    
    public void removeAventurier(Aventurier aventurier){
        getPossede().remove(aventurier);
    }
    
    
}


 
