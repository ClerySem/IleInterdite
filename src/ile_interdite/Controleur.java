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
                if (aventuriers.get("Gaspard").getRole()== roleAventuriers.ingenieur || aventuriers.get("Gaspard").getRole()== roleAventuriers.messager ||
                    aventuriers.get("Gaspard").getRole()== roleAventuriers.navigateur){
                    
                if (!msg.texte.equals("")){
                    String Texte = msg.texte;
                    
                   
                    String[] positionString;
                    positionString = Texte.split(",");
                    int[] position = new int[2];
                    position[0] = Integer.parseInt(positionString[0]);
                    position[1] = Integer.parseInt(positionString[1]);
                    
                    //if (!tuilesAutours.contains(grille.getTuiles()[position[0]][position[1]])){System.out.println("Deplacement impossible");}else{
                    aventuriers.get("Gaspard").seDeplacer(getGrille().getTuiles()[position[0]][position[1]]);
                }
                ArrayList<Tuile> tuilesAutours = RecupererTuile(aventuriers.get("Gaspard").getEstSur());
                }
                
                
                
                if (aventuriers.get("Gaspard").getRole()==roleAventuriers.explorateur){
                    
                    if (!msg.texte.equals("")){
                    String Texte = msg.texte;
                    
                   
                    String[] positionString;
                    positionString = Texte.split(",");
                    int[] position = new int[2];
                    position[0] = Integer.parseInt(positionString[0]);
                    position[1] = Integer.parseInt(positionString[1]);
                    
                    //if (!tuilesAutours.contains(grille.getTuiles()[position[0]][position[1]])){System.out.println("Deplacement impossible");}else{
                    aventuriers.get("Gaspard").seDeplacer(getGrille().getTuiles()[position[0]][position[1]]);
                }
                 ArrayList<Tuile> tuilesAutours = RecupererTuile(aventuriers.get("Gaspard").getEstSur());   
                }
                
                
                
                
                
              
                //...
            break;
            case Assecher:
                if (aventuriers.get("Gaspard").getRole()== roleAventuriers.ingenieur || aventuriers.get("Gaspard").getRole()== roleAventuriers.messager ||
                    aventuriers.get("Gaspard").getRole()== roleAventuriers.navigateur){
                if (!msg.texte.equals("")){
                    String Texte = msg.texte;
                    
                   
                    String[] positionString;
                    positionString = Texte.split(",");
                    int[] position = new int[2];
                    position[0] = Integer.parseInt(positionString[0]);
                    position[1] = Integer.parseInt(positionString[1]);
                    
                    //if (!tuilesAutours.contains(grille.getTuiles()[position[0]][position[1]])){System.out.println("Deplacement impossible");}else{
                    aventuriers.get("Gaspard").assecherTuile(getGrille().getTuiles()[position[0]][position[1]]);
                    
                }
                ArrayList<Tuile> tuilesaAssecher = AssecherTuile(aventuriers.get("Gaspard").getEstSur());
                }
                if (aventuriers.get("Gaspard").getRole()==roleAventuriers.explorateur){
                     if (!msg.texte.equals("")){
                    String Texte = msg.texte;
                    
                   
                    String[] positionString;
                    positionString = Texte.split(",");
                    int[] position = new int[2];
                    position[0] = Integer.parseInt(positionString[0]);
                    position[1] = Integer.parseInt(positionString[1]);
                    
                    //if (!tuilesAutours.contains(grille.getTuiles()[position[0]][position[1]])){System.out.println("Deplacement impossible");}else{
                    aventuriers.get("Gaspard").assecherTuile(getGrille().getTuiles()[position[0]][position[1]]);
                }
                    
                ArrayList<Tuile> tuilesaAssecher = AssecherTuile(aventuriers.get("Gaspard").getEstSur());
                
                }
                
                
            break;
            case Autre:
                
                 if (aventuriers.get("Gaspard").getRole()==roleAventuriers.pilote){
                    if (!msg.texte.equals("")){
                        String Texte = msg.texte;


                        String[] positionString;
                        positionString = Texte.split(",");
                        int[] position = new int[2];
                        position[0] = Integer.parseInt(positionString[0]);
                        position[1] = Integer.parseInt(positionString[1]);

                        //if (!tuilesAutours.contains(grille.getTuiles()[position[0]][position[1]])){System.out.println("Deplacement impossible");}else{
                        aventuriers.get("Gaspard").seDeplacer(getGrille().getTuiles()[position[0]][position[1]]);
                     }
                }
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
     
   
    ////SE DEPLACER///////////////////////////////////////////////////
     
     public ArrayList<Tuile> RecupererTuile(Tuile position){
        int l = getLigne(position);
        int c = getColonne(position);
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
        if(aventuriers.get("Gaspard").getRole()==roleAventuriers.explorateur){
          //tuile hautGauche//
        if(c>=1 && l>=1){
            int cHGauche=c -1;
            int lHGauche=l - 1;
            tuiles.add(grille.getTuiles()[lHGauche][cHGauche]);
        }
        //tuile hautDroit//
        if(c<=4 && l>=1){
            int cHDroite=c +1;
            int lHDroite=l - 1;
            tuiles.add(grille.getTuiles()[lHDroite][cHDroite]);
        }
        //tuile basGauche//
        if(c>=1 && l<=4){
            int cBGauche=c -1;
            int lBGauche=l + 1;
            tuiles.add(grille.getTuiles()[lBGauche][cBGauche]);
        }
        //tuile basDroite//
        if (c<=4 && l<=4){
            int cBDroite=c +1;
            int lBDroite=l + 1;
            tuiles.add(grille.getTuiles()[lBDroite][cBDroite]);
        }
        }
           
        for (Tuile tuile : tuiles) {
            if (tuile!=null && tuile.getStatut()==Utils.EtatTuile.ASSECHEE ){
                tuilesFin.add(tuile);
            }
        }
        
        System.out.println("Les tuiles sur lesquels vous pouvez vous déplacer sont : ");
        
                String positionPossible = "";
                if (!tuilesFin.isEmpty()){ //Si il y a des tuiles sur lesquels ont peut se déplacer
                        for(int k = 0; k < tuilesFin.size() - 1; k++){
                            positionPossible += (tuilesFin.get(k).getNumLigne()+","+tuilesFin.get(k).getNumColonne()+" ou ");
                        }
                    positionPossible += tuilesFin.get(tuilesFin.size()-1).getNumLigne()+","+tuilesFin.get(tuilesFin.size()-1).getNumColonne();
                   
                }else{
                    positionPossible = "Impossible de se déplacer";
                }
                
                System.out.println(positionPossible);
       return tuilesFin;
     }
     
     
     
     /////////////ASSECHER TUILE ///////////////////////////////////////////////
     
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
        if(aventuriers.get("Gaspard").getRole()==roleAventuriers.explorateur){
          //tuile hautGauche//
        if(c>=1 && l>=1){
            int cHGauche=c -1;
            int lHGauche=l - 1;
            tuiles.add(grille.getTuiles()[lHGauche][cHGauche]);
        }
        //tuile hautDroit//
        if(c<=4 && l>=1){
            int cHDroite=c +1;
            int lHDroite=l - 1;
            tuiles.add(grille.getTuiles()[lHDroite][cHDroite]);
        }
        //tuile basGauche//
        if(c>=1 && l<=4){
            int cBGauche=c -1;
            int lBGauche=l + 1;
            tuiles.add(grille.getTuiles()[lBGauche][cBGauche]);
        }
        //tuile basDroite//
        if (c<=4 && l<=4){
            int cBDroite=c +1;
            int lBDroite=l + 1;
            tuiles.add(grille.getTuiles()[lBDroite][cBDroite]);
        }
        }
           
        for (Tuile tuile : tuiles) {
            if (tuile!=null && tuile.getStatut()==Utils.EtatTuile.INONDEE  ){
                tuilesFin.add(tuile);
            }
        }
        System.out.println("Les tuiles que vous pouvez assécher : ");
                
               
                String positionPossible = "";
                if (!tuilesFin.isEmpty()){ //Si il y a des tuiles sur lesquels ont peut se déplacer
                    for(int k = 0; k < tuilesFin.size() - 1; k++){
                        positionPossible += (tuilesFin.get(k).getNumLigne()+","+tuilesFin.get(k).getNumColonne()+" ou ");
                    }
                    positionPossible += tuilesFin.get(tuilesFin.size()-1).getNumLigne()+","+tuilesFin.get(tuilesFin.size()-1).getNumColonne();
                   
                } else {
                    positionPossible = "Impossible d'assecher";
                }
                
                System.out.println(positionPossible);
       
     
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

    
    
  
    
}
