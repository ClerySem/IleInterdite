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
import model.cards.CarteTresor;
import model.cards.typeCarte;
import model.grille.Grille;
import util.Utils;
import model.grille.Tuile;
import util.Utils.Tresor;

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
    
    private ArrayList<Tresor> tresors = new ArrayList<Tresor>();
    private ArrayList<CarteTirage> cartesMainAventurier;
    private ArrayList<CarteTresor> cartesTresorMainAventurier;
    private int nbPierre =0;
    private int nbCalice =0;
    private int nbZephyr = 0;
    private int nbCristal = 0;
    
    
    //////////CONSTRUCTEUR///////
    public Aventurier(roleAventuriers role ,String capacite, Tuile estSur){
        this.role = role;
        this.capacite = capacite;
        this.nbaction = 1;
        this.estSur = estSur;
        this.cartesMainAventurier = new ArrayList<>();
        estSur.ajouterAventurier(this);
       
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
        getEstSur().removeAventurier(this);
        setEstSur(tuile);
        tuile.ajouterAventurier(this);
        setNbaction(getNbaction() + 1);
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

    
   
    
    ////////////////////////////////ASTRING_DEPLACER///////////////////////////////////////
    public String getAfficher(ArrayList<Tuile> tuiles){
        String texte;
          texte =("Les tuiles sur lesquels vous pouvez vous déplacer sont : ");
        
                if (!tuiles.isEmpty()){ //Si il y a des tuiles sur lesquels ont peut se déplacer
                        for(int k = 0; k < tuiles.size() - 1; k++){
                            texte = texte +  (tuiles.get(k).getNom() +" ou ");
                        }
                    texte =texte + tuiles.get(tuiles.size()-1).getNom();
                   
                }else{
                    texte = "Impossible de se déplacer";
                }
    return texte;                 
     }
    
    ////////////////////////////////////STRING_TUILES_POSSIBLES///////////////////////////////////////////////
    public String getAfficherAssecher(ArrayList<Tuile> tuiles){
        String texte;
         texte = ("Les tuiles que vous pouvez assécher : ");
                
                String positionPossible = "";
                if (!tuiles.isEmpty()){ //Si il y a des tuiles sur lesquels ont peut se déplacer
                    for(int k = 0; k < tuiles.size() - 1; k++){
                        texte = texte +(tuiles.get(k).getNom()+" ou ");
                    }
                    texte = texte +(tuiles.get(tuiles.size()-1).getNom());
                   
                } else {
                    texte = "Impossible d'assecher";
                }
               
                return texte;
    }
    
     ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////METHODES CARTES////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
    
    
    public ArrayList<CarteTirage> getCartesMainAventurier() {
        
        return cartesMainAventurier;
    }
// Methode:
public ArrayList<CarteTresor> getCartesTresorMainAventurier() {
        return cartesTresorMainAventurier;
    }
public int getNbPierre() {
        return nbPierre;
    }

    public int getNbCalice() {
        return nbCalice;
    }

    public int getNbZephyr() {
        return nbZephyr;
    }

    public int getNbCristal() {
        return nbCristal;
    }
   
    //permet de piocher une carte
   
    public ArrayList<Tresor> getTresors(){
        return tresors;
    }
   
    public void recupererTresor(){
        Tuile position = this.getEstSur();
       

       
        for (CarteTresor carteTresor : cartesTresorMainAventurier) {
            if (carteTresor.getTresor() == Tresor.PIERRE){
                nbPierre = nbPierre +1;
            }
            if (carteTresor.getTresor() == Tresor.CALICE){
                nbCalice = nbCalice +1;
            }
            if (carteTresor.getTresor() == Tresor.CRISTAL){
                nbCristal = nbCristal +1;
            }
            else{
                nbZephyr = nbZephyr +1;
            }
          
        }
           
        if(position.getNumLigne()==4 && (position.getNumColonne() == 1 ||position.getNumColonne() == 2 )){
            // positions des tuiles tresors Pierre
            if (nbPierre >3 ){
                tresors.add(Tresor.PIERRE);
                
            }
        }
        if((position.getNumLigne()==5 && position.getNumColonne() == 3 )||(position.getNumLigne()==2 && position.getNumColonne() == 5 )){
            // positions des tuiles tresors Zephyr
            if (nbZephyr >3 ){
                tresors.add(Tresor.ZEPHYR);
            }
        }
        if((position.getNumLigne()==1 && position.getNumColonne() == 1 )||(position.getNumLigne()==3 && position.getNumColonne() == 5 )){
            // positions des tuiles tresors Cristal
            if (nbCristal >3){
                tresors.add(Tresor.CRISTAL);
            }
        }
        if((position.getNumLigne()==2 && position.getNumColonne() == 0 )||(position.getNumLigne()==4 && position.getNumColonne() == 3 )){
            // positions des tuiles tresors Calice
            if (nbCalice >3 ){
                tresors.add(Tresor.CALICE);
            }
        }
        else{
            System.out.println("l'aventurier n'est pas sur une tuile trésor");
        }
    }
    
    public void afficherCartesMain(){
        for (CarteTirage carte : getCartesMainAventurier()) {
            System.out.println(carte.getType().toString());
        }
    }
}

