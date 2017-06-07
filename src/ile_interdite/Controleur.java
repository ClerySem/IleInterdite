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
import java.util.Scanner;
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
    

    public Controleur() {
        
        //initialisation des attributs
        this.aventuriers = new HashMap<>();
        
        System.out.println("Lancement de la partie");
        demarrerPartie();
        
        vue = new VueAventurier("Gaspard", aventuriers.get("Gaspard").getRole().getNom(), aventuriers.get("Gaspard").getRole().getPion().getCouleur());
        afficherGrilleConsole();
        vue.setObservateur(this);
        
        
        //vue.affiche();
        
    }
    
   
    @Override
    public void traiterMessage(Message msg) {
        
        switch(msg.type){
            case Deplacer:
                
                ArrayList<Tuile> tuilesAutours = RecupererTuile(aventuriers.get("Gaspard").getEstSur());
                tuilesAutours.forEach(tuile -> {
                    System.out.println(tuile.getNumLigne()+","+tuile.getNumColonne());
                });
                
                boolean deplacementPossible = false;
                String positionPossible = "";
                if (tuilesAutours.size() != 0){
                    for(int k = 0; k < tuilesAutours.size() - 1; k++){
                        positionPossible += (tuilesAutours.get(k).getNumLigne()+","+tuilesAutours.get(k).getNumColonne()+" ou ");
                    }
                    positionPossible += tuilesAutours.get(tuilesAutours.size()-1).getNumLigne()+","+tuilesAutours.get(tuilesAutours.size()-1).getNumColonne();
                    deplacementPossible = true;
                } else {
                    positionPossible = "Impossible de se déplacer";
                }
                
                vue.setPosition(positionPossible);
                
                if (deplacementPossible){
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Après avoir entré un champ dans le champ sur la fenêtre, cliquer ici puis taper sur la touche Entrée");
                    String suite = scanner.nextLine();
                    String Texte = vue.getTexte();
                    System.out.println("Vous avez saisi : " + Texte);
                   
                    /*String[] positionString = new String[2];
                    positionString = Texte.split(",");
                    int[] position = new int[2];
                    position[0] = Integer.parseInt(positionString[0]);
                    position[1] = Integer.parseInt(positionString[1]);
  
                    aventuriers.get("Gaspard").seDeplacer(getGrille().getTuiles()[position[0]][position[1]]);*/
                }
                System.out.println(aventuriers.get("Gaspard").getEstSur().getNumLigne());
                System.out.println(aventuriers.get("Gaspard").getEstSur().getNumColonne());
                
              
                //...
            break;
            case Assecher:
                ArrayList<Tuile> tuilesaAssecher = AssecherTuile(aventuriers.get("Gaspard").getEstSur());
                tuilesaAssecher.forEach(tuile -> {
                    System.out.println(tuile.getNumLigne()+","+tuile.getNumColonne());
                   
                });
                vue.setPosition("assechement tuile");
                
            break;
            case Autre:
                vue.setPosition("autre");
                //...
            break;
            case Terminer:
                vue.setPosition("Tour terminer, joueur suivant");
                //...
            break;
                
            
        }
       
    }
    
    public final void demarrerPartie() {
        this.grille = new Grille();
        
        //to-do : récuperer les noms des différents joueurs, pour le moment je les aient initialisés à la main,
        ArrayList<String> joueurs = new ArrayList<>();
        joueurs.add("Gaspard");
        joueurs.add("Eddy");
        joueurs.add("Clery");
        joueurs.add("Sacha");
        
        //creation des aventuriers
        
        Explorateur explorateur = new Explorateur(getGrille().getTuiles()[2][3]);
        
        Ingenieur ingenieur = new Ingenieur(getGrille().getTuiles()[1][2]);
        
        Messager messager = new Messager(getGrille().getTuiles()[1][3]);
        
        Navigateur navigateur = new Navigateur(getGrille().getTuiles()[2][4]);
        
        Pilote pilote = new Pilote(getGrille().getTuiles()[0][3]);
        
        Plongeur plongeur = new Plongeur(getGrille().getTuiles()[2][1]);
        
        ArrayList<Aventurier> listeaventuriersjouables = new ArrayList();
        listeaventuriersjouables.add(explorateur);
        listeaventuriersjouables.add(ingenieur);
        listeaventuriersjouables.add(messager);
        listeaventuriersjouables.add(navigateur);
        listeaventuriersjouables.add(pilote);
        listeaventuriersjouables.add(plongeur);
        Collections.shuffle((List<?>) listeaventuriersjouables); //melange des aventuriers
        
        
        for (int k = 0; k < 4; k++){ //comme il y a 4 joueurs on ajoute 4 aventuriers à notre collection aventuriers
              listeaventuriersjouables.get(k).setNom(joueurs.get(k)); // on donne un nom à l'aventurier
            getAventuriers().put(joueurs.get(k), listeaventuriersjouables.get(k)); // on l'ajoute à aventuriers
        }
        
        
    }
    
    public Tuile getPosition(Aventurier aventurier){
        Tuile position = aventurier.getEstSur();
        return position;
    }
    
    public int getLigne(Tuile position){
       int c =position.getNumLigne();
       return c;
    }
    
     public int getColonne(Tuile position){
       int l =position.getNumColonne();
       return l;
    }

    public Grille getGrille() {
        return grille;
    }
     
     
     
     public ArrayList<Tuile> RecupererTuile(Tuile position){
        
         int l = getLigne(position);
        int c = getColonne(position);
         System.out.println("Vous etes en "+ l +","+ c);
        ArrayList<Tuile> tuiles = new ArrayList<>();
        ArrayList<Tuile> tuilesFin = new ArrayList<>();
        
        //tuile dessus//
        if (l<=4){
            int cDessus= c;
            int lDessus= l + 1;
            tuiles.add(grille.getTuiles()[lDessus][cDessus]);
            
        }
        //tuile Dessous//
        if (l>=1){
            int cDessous= c;
            int lDessous= l - 1;
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
           
        for (Tuile tuile : tuiles) {
            if (tuile!=null && tuile.getStatut()!=Utils.EtatTuile.INONDEE ){
                tuilesFin.add(tuile);
            }
        }
       return tuilesFin;
     }
     
     
     public ArrayList<Tuile> AssecherTuile(Tuile position){
        int l = getLigne(position);
        int c = getColonne(position);
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
            if (tuile!=null && tuile.getStatut()==Utils.EtatTuile.INONDEE ){
                tuilesFin.add(tuile);
            }
        }
       return tuilesFin;
     }
     
     public void afficherGrilleConsole(){
         for (int i = 0; i <6; i ++) {
             for (int k = 0; k <6; k++) {
                 if(grille.getTuiles()[i][k] != null){
                     System.out.print(" |" + i + ","+ k + "| ");
                 } else {
                     System.out.print( " |   | ");
                 }
            }
             System.out.print("\n");
         }
     }


    public HashMap<String, Aventurier> getAventuriers() {
        return aventuriers;
    }

/*    public void setVue(String nomJoueur, String nomAventurier, Color couleur) {
       this.vue = new VueAventurier(nomJoueur, nomAventurier, couleur);
    }*/
    
    
  
    
}
