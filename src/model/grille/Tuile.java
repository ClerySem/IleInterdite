/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.grille;

import java.util.ArrayList;
import model.aventuriers.Aventurier;
import util.Utils;
import static util.Utils.EtatTuile.*;



/**
 *
 * @author anthoing
 */
public class Tuile {
    private String nom;
    private Utils.EtatTuile statut;
    private int numLigne;
    private int numColonne;
    private ArrayList<Aventurier> possede;

    public Tuile(int numLigne , int numColonne) {
       this.statut = ASSECHEE;
       this.numLigne = numLigne;
       this.numColonne =numColonne;
       if (numLigne == 0 && numColonne ==2){
           this.nom = "Le Pont Des Abimes";
       }
       if (numLigne == 0 && numColonne ==3){
           this.nom = "La Porte De Bronze";
       }
       if (numLigne == 1 && numColonne ==1){
           this.nom = "La Caverne Des Ombres";
       }
       if (numLigne == 1 && numColonne ==2){
           this.nom = "La Porte De Fer";
       }
       if (numLigne == 1 && numColonne ==3){
           this.nom = "La Porte d'Or";
       }
       if (numLigne == 1 && numColonne ==4){
           this.nom = "Les Falaises De L'Oubli";
       }
       if (numLigne == 2 && numColonne ==0){
           this.nom = "Le Palais De Corail";
       }
       if (numLigne == 2 && numColonne ==1){
           this.nom = "La Porte d'Argent";
       }
       if (numLigne == 2 && numColonne ==2){
           this.nom = "Les Dunes De L'Illusion";
       }
       if (numLigne == 2 && numColonne ==3){
           this.nom = "Heliport";
       }
       if (numLigne == 2 && numColonne ==4){
           this.nom = "La Porte De Cuivre";
       }
       if (numLigne == 2 && numColonne ==5){
           this.nom = "Le Jardin Des Hurlements";
       }
       if (numLigne == 3 && numColonne ==0){
           this.nom = "La Foret Pourpre";
       }
       if (numLigne == 3 && numColonne ==1){
           this.nom = "Le Lagon Perdu";
       }
       if (numLigne == 3 && numColonne ==2){
           this.nom = "Le Marais Brumeux";
       }
       if (numLigne == 3 && numColonne ==3){
           this.nom = "Observatoire";
       }
       if (numLigne == 3 && numColonne ==4){
           this.nom = "Le Rocher Fantome";
       }
       if (numLigne == 3 && numColonne ==5){
           this.nom = "La Caverne Du Brasier";
       }
       if (numLigne == 4 && numColonne ==1){
           this.nom = "Le Temple Du Soleil";
       }
       if (numLigne == 4 && numColonne ==2){
           this.nom = "Le Temple De La Lune";
       }
       if (numLigne == 4 && numColonne ==3){
           this.nom = "Le Palais Des Marais";
       }
       if (numLigne == 4 && numColonne ==4){
           this.nom = "Le Val Du Crepuscule";
       }
       if (numLigne == 5 && numColonne ==2){
           this.nom = "La Tour Du Guet";
       }
       if (numLigne == 5 && numColonne ==3){
           this.nom = "Le Jardin Des Murmures";
       }
       this.possede = new ArrayList<>();
       
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setStatut(Utils.EtatTuile statut) {
        this.statut = statut;
    }
    

    /**
     * @return the numLigne
     */
    public int getNumLigne() {
        return numLigne;
    }

    /**
     * @param numLigne the numLigne to set
     */
    public void setNumLigne(int numLigne) {
        this.numLigne = numLigne;
    }

    /**
     * @return the numColonne
     */
    public int getNumColonne() {
        return numColonne;
    }

    public ArrayList<Aventurier> getPossede() {
        return possede;
    }
    

    /**
     * @param numColonne the numColonne to set
     */
    public void setNumColonne(int numColonne) {
        this.numColonne = numColonne;
    }
    
    public boolean EstSeche(){
            return this.getStatut() == ASSECHEE;    
    }
    
    public void ajouterAventurier(Aventurier aventurier){
        getPossede().add(aventurier);
    }

    /**
     * @return the statut
     */
    public Utils.EtatTuile getStatut() {
        return statut;
    }
    
}


 
