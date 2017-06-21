/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.aventuriers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import model.cards.CarteInondation;
import model.cards.CarteTirage;
import model.grille.Grille;
import util.Utils;
import model.grille.Tuile;

/**
 *
 * @author sarrasie
 */
public abstract class Aventurier {
    private roleAventuriers role;
    private final String capacite;
    private String nomJ;
    private Tuile estSur;
    private int nbaction;
    private Grille grille;
    
    private ArrayList<CarteTirage> cartesMainAventurier;
    
    //////////CONSTRUCTEUR///////
    public Aventurier(roleAventuriers role ,String capacite, Tuile estSur){
        this.role = role;
        this.capacite = capacite;
        this.nbaction = 1;
        this.estSur = estSur;
       
    }
    ////////////GET_SET_NOM////////////////////////
    public String getNom(){
        return nomJ;
    }
    public void setNom (String nom){
        this.nomJ = nom;
    }

    
    ///////////GET_SET_ESTSUR/////////////////////
    public Tuile getEstSur() {
        return estSur;
    }
    public void setEstSur(Tuile estSur) {
        this.estSur = estSur;
    }

    
    //////////GET_SET_ROLE////////////////////////
    public roleAventuriers getRole() {
        return role;
    }
    public void setRole(roleAventuriers role) {
        this.role = role;
    }
    
    
    /////////GET_SET_NBACTION////////////////////
    public int getNbaction() {
        return nbaction;
    }
    public void setNbaction(int nbaction) {
        this.nbaction = nbaction;
    }
    
    
    /////////GET_LIGNE_COLONNE_TUILE//////////////
    private int getTuile(){
       return (estSur.getNumLigne()+estSur.getNumColonne());
    }    
    
    
    //Les methodes qui suivent sont les actions réalisées par l'aventurier
    public void assecherTuile(Tuile tuile){
        tuile.setStatut(Utils.EtatTuile.ASSECHEE);
        setNbaction(getNbaction() + 1);
    }
    
    public void seDeplacer(Tuile tuile){
        setEstSur(tuile);
        tuile.ajouterAventurier(this);
        setNbaction(getNbaction() + 1);
    }
    public void donnerCarteJoueur(){
        
    }

    //////////////////////DEPLACER//////////////////////////////////////////
     public ArrayList<Tuile> RecupererTuile(Tuile position,Grille grille){
        int l = position.getNumLigne();
        int c = position.getNumColonne();
        System.out.println("Vous etes en "+ l +","+ c);
        ArrayList<Tuile> tuiles = new ArrayList<>();
        ArrayList<Tuile> tuilesFin = new ArrayList<>();
        
        //tuile dessus//
        if (l>=1){
            int cDessus= c;
            int lDessus= l - 1;
            tuiles.add(grille.getTuiles()[lDessus][cDessus]);
        }
        //tuile Dessous//
        if (l<=4){
            int cDessous= c;
            int lDessous= l + 1;
            tuiles.add(grille.getTuiles()[lDessous][cDessous]);
        }
        //tuile gauche//
        if (c>=1){
            int cGauche= c -1 ;
            int lGauche= l;
            tuiles.add(grille.getTuiles()[lGauche][cGauche]);
        }
        //tuile droite//
        if (c<=4){
            int cDroite=c + 1;
            int lDroite=l;
            tuiles.add(grille.getTuiles()[lDroite][cDroite]);
        }
      for (Tuile tuile : tuiles) { //on ajoute toutes les tuiles sèche à tuilesFin
            if (tuile!=null && tuile.getStatut()==Utils.EtatTuile.ASSECHEE ){
                tuilesFin.add(tuile);
            }
        }
     return tuilesFin;
    }
    ////////////////////////////////AFFICHER_DEPLACER///////////////////////////////////////
    public void Afficher(ArrayList<Tuile> tuiles){
        
          System.out.println("Les tuiles sur lesquels vous pouvez vous déplacer sont : ");
        
                String positionPossible = "";
                if (!tuiles.isEmpty()){ //Si il y a des tuiles sur lesquels ont peut se déplacer
                        for(int k = 0; k < tuiles.size() - 1; k++){
                            positionPossible += (tuiles.get(k).getNumLigne()+","+tuiles.get(k).getNumColonne()+" ou ");
                        }
                    positionPossible += tuiles.get(tuiles.size()-1).getNumLigne()+","+tuiles.get(tuiles.size()-1).getNumColonne();
                   
                }else{
                    positionPossible = "Impossible de se déplacer";
                }
                System.out.println(positionPossible);
                
     }
    ////////////////////////////////ASSECHER///////////////////////////////////////
    public ArrayList<Tuile> AssecherTuile(Tuile position,Grille grille){
        int l = position.getNumLigne();
        int c = position.getNumColonne();
         System.out.println("Vous etes en "+ l+ ","+c);
        ArrayList<Tuile> tuiles = new ArrayList<>();
        ArrayList<Tuile> tuilesFin = new ArrayList<>();
        
        
        //tuile du joueur//
        tuiles.add(grille.getTuiles()[l][c]);
        //tuile dessus//
        if (c>=1){
            int cDessus= c-1;
            int lDessus= l;
            tuiles.add(grille.getTuiles()[lDessus][cDessus]);
            
        }
        //tuile Dessous//
        if (c<=4){
            int cDessous= c+1;
            int lDessous= l;
            tuiles.add(grille.getTuiles()[lDessous][cDessous]);
        }
        //tuile gauche//
        if (l>=1){
            int cGauche= c;
            int lGauche= l-1;
            tuiles.add(grille.getTuiles()[lGauche][cGauche]);
        }
        //tuile droite//
        if (l<=4){
            int cDroite=c;
            int lDroite=l+1;
            tuiles.add(grille.getTuiles()[lDroite][cDroite]);
        }
         for (Tuile tuile : tuiles) {
            if (tuile!=null && tuile.getStatut()==Utils.EtatTuile.INONDEE  ){
                tuilesFin.add(tuile);
            }
         }
   
        return tuilesFin;
}
    
    
    ////////////////////////////////AFFICHER_ASSECHER///////////////////////////////////////
    public void AfficherAssecher(ArrayList<Tuile> tuiles){
         System.out.println("Les tuiles que vous pouvez assécher : ");
                
                String positionPossible = "";
                if (!tuiles.isEmpty()){ //Si il y a des tuiles sur lesquels ont peut se déplacer
                    for(int k = 0; k < tuiles.size() - 1; k++){
                        positionPossible += (tuiles.get(k).getNumLigne()+","+tuiles.get(k).getNumColonne()+" ou ");
                    }
                    positionPossible += tuiles.get(tuiles.size()-1).getNumLigne()+","+tuiles.get(tuiles.size()-1).getNumColonne();
                   
                } else {
                    positionPossible = "Impossible d'assecher";
                }
                System.out.println(positionPossible);
    }

    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////METHODES CARTES////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public ArrayList<CarteTirage> getCartesMainAventurier() {
        return cartesMainAventurier;
    }
    
    //permet de piocher une carte
    public void piocherCarteTirage(Stack<CarteTirage> carteTirage){
        //si la main de l'aventurier n'est pas pleine 
        if(getCartesMainAventurier().size()<8){
            getCartesMainAventurier().add(carteTirage.pop());
            //alors on ajoute la carte de la pile à la main
        }
        else{
            System.err.println("Votre main est pleine, la limte est de 9 cartes");
        }
    }
    
    
}

