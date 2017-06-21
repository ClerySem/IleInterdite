/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;
import static ile_interdite.TypesMessages.Deplacer;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import model.aventuriers.Aventurier;
import model.aventuriers.Explorateur;
import model.aventuriers.Ingenieur;
import model.aventuriers.roleAventuriers;
import model.grille.Grille;
import model.grille.Tuile;
import view.*;
import util.Utils;
import model.aventuriers.*;

/**
 *
 * @author semanazc
 */
public class Controleur2 implements Observateur {
    
    //private final VueAventurier vue;
    private final VuePlateau vueP;
    private final HashMap<String,Aventurier> aventuriers;
    private Grille grille;
    private boolean premierClic;
    private ArrayList<Tuile> tuilesAutours;
    private ArrayList<Tuile> tuilesAutoursNonSeches;
    private boolean choixFinTour;
    private ArrayList<String> joueurs= new ArrayList<>();
    private String aventurierCourant;
    
    public Controleur2() {
        
        //initialisation des attributs
        this.aventuriers = new HashMap<>();
        this.premierClic = true;
        this.tuilesAutours = new ArrayList<>();
        this.tuilesAutoursNonSeches = new ArrayList<>();
        this.choixFinTour = false;
        /*
         --------------------------------------------------------------
         |                  Lancement de la partie                    |
         --------------------------------------------------------------
        */
        System.out.println("Lancement de la partie");
        demarrerPartie();
        /*
            La ligne ci-dessous est à utiliser si l'on veut forcer un aventurier en particulier à une position particulière (/!\ Constructeur de pilote différent des autres)
        */
        //aventuriers.put("Gaspard", new Ingenieur(getGrille().getTuiles()[4][3]));
        //vue = new VueAventurier("Gaspard", aventuriers.get("Gaspard").getRole().getNom(), aventuriers.get("Gaspard").getRole().getPion().getCouleur());
        afficherGrilleConsole();
        // loop tant que partie pas fini
        
        
        vueP = new VuePlateau(aventuriers.get("Gaspard"));
        vueP.Affiche();
    
        //vue.setObservateur(this);
        if(aventuriers.get("Gaspard").getNbaction() > 3 || choixFinTour){
            //fermeture de la fenêtre et ouverture de celle du nouvel aventurier
            vueP.close();
        } 
      

    }
    @Override
    public void traiterMessage(Message msg) {
        Exception AucunePositionEntreeException = new Exception();
        Exception AssechementImpossibleException = new Exception();
        Exception DeplacementImpossibleException = new Exception();
         
        switch(msg.type){
 
            case Deplacer:
                
                try{if(aventuriers.get("Gaspard").getNbaction() > 3 || choixFinTour){
            //fermeture de la fenêtre et ouverture de celle du nouvel aventurier
            vueP.close();
        }
                    if (premierClic){
                        tuilesAutours = aventuriers.get("Gaspard").RecupererTuile(aventuriers.get("Gaspard").getEstSur(),grille);
                       aventuriers.get("Gaspard").Afficher(tuilesAutours);
                        setPremierClic(false);
                    }else { // on va entamer la procédure de deplacement du joueur sur les coordonnées entrées
                        if (!msg.texte.equals("")){ //si la case message à été remplie
                            String texte = msg.texte;

                            System.out.println("Deplacement en cours");

                            String[] positionString;
                            positionString = texte.split(","); //parsing des coordonnées
                            int[] position = new int[2];
                            position[0] = Integer.parseInt(positionString[0]); //ligne
                            position[1] = Integer.parseInt(positionString[1]); //colonne
                            
                            if (!tuilesAutours.contains(grille.getTuiles()[position[0]][position[1]])){
                                System.err.println("Deplacement impossible");
                                throw DeplacementImpossibleException;
                            }else{ //on finalise la procédure de déplacement

                                aventuriers.get("Gaspard").seDeplacer(getGrille().getTuiles()[position[0]][position[1]]);
                                System.out.println("Deplacement bien effectué, vous êtes maintenant en : " + aventuriers.get("Gaspard").getEstSur().getNumLigne()+ "," + aventuriers.get("Gaspard").getEstSur().getNumColonne());
                                premierClic = true;
                            }  

                        }else {
                            System.err.println("Aucune position entrée");
                           throw AucunePositionEntreeException;
                        }

                    }    
               }catch(Exception e){
                    System.err.println("Une erreur c'est produite merci de recommencer");
                    setPremierClic(true);
                }      
                
                //vueP.setPosition(""); //clear de la zone de texte de la vue
            break;
           case Assecher:
                
                try {
                    if (premierClic){
                        tuilesAutoursNonSeches = aventuriers.get("Gaspard").AssecherTuile(aventuriers.get("Gaspard").getEstSur(),grille);
                        aventuriers.get("Gaspard").AfficherAssecher(tuilesAutoursNonSeches);
                        setPremierClic(false);
                    }else { //on entamme la procédure d'asséchement
                        System.out.println("Vous avez choisit de sécher une case : \n ");
                        if (!msg.texte.equals("")){ //si la case message à été remplie
                            String texte = msg.texte;

                            System.out.println("Assechement en cours");

                            String[] positionString;
                            positionString = texte.split(","); //parsing des coordonnées
                            int[] position = new int[2];
                            position[0] = Integer.parseInt(positionString[0]); //ligne
                            position[1] = Integer.parseInt(positionString[1]); //colonne
                            
                            if (!tuilesAutoursNonSeches.contains(grille.getTuiles()[position[0]][position[1]])){
                                System.err.println("Assechement impossible");
                                throw AssechementImpossibleException;
                            }else{ //on finalise la procédure d'asséchement

                                aventuriers.get("Gaspard").assecherTuile(getGrille().getTuiles()[position[0]][position[1]]);
                                System.out.println("Asséchement bien effectué,la tuile : " + getGrille().getTuiles()[position[0]][position[1]].getNumLigne()+ ","
                                        + getGrille().getTuiles()[position[0]][position[1]].getNumColonne() + " est " + getGrille().getTuiles()[position[0]][position[1]].getStatut().toString());
                                premierClic = true;
                            }

                        }else {
                            System.err.println("Aucune position entrée");
                            throw AucunePositionEntreeException;
                        }

                    }
                }catch(Exception e){
                    System.err.println("Une erreur c'est produite merci de recommencer");
                    setPremierClic(true);
                }
               
                
                //vue.setPosition(""); //clear de la zone de texte de la vue
            break;
            case Autre:
               
                
             ////////////////////////////////////////////////////////////////////////////
            //////////////////////////////Pilote////////////////////////////////////////
           ////////////////////////////////////////////////////////////////////////////
                try{
                    if (aventuriers.get("Gaspard").getRole()==roleAventuriers.pilote){
                        ((Pilote)aventuriers.get("Gaspard")).setVeutVoler(true);

                        if (premierClic){
                            
                            tuilesAutours = aventuriers.get("Gaspard").RecupererTuile(aventuriers.get("Gaspard").getEstSur(),grille);
                            aventuriers.get("Gaspard").Afficher(tuilesAutours);
                            setPremierClic(false);
                        }else { // on va entamer la procédure de deplacement du joueur sur les coordonnées entrées
                            if (!msg.texte.equals("")){ //si la case message à été remplie
                                String texte = msg.texte;
                                System.out.println("Deplacement en cours");

                                String[] positionString;
                                positionString = texte.split(","); //parsing des coordonnées
                                int[] position = new int[2];
                                position[0] = Integer.parseInt(positionString[0]); //ligne
                                position[1] = Integer.parseInt(positionString[1]); //colonne

                                if (!tuilesAutours.contains(grille.getTuiles()[position[0]][position[1]])){
                                    System.err.println("Deplacement impossible");
                                    throw DeplacementImpossibleException;

                                }else{ //on finalise la procédure de déplacement

                                    aventuriers.get("Gaspard").seDeplacer(getGrille().getTuiles()[position[0]][position[1]]);
                                    System.out.println("Deplacement bien effectué, vous êtes maintenant en : " + aventuriers.get("Gaspard").getEstSur().getNumLigne()+ "," + aventuriers.get("Gaspard").getEstSur().getNumColonne());
                                    premierClic = true;
                                }  
                            }else {
                                System.err.println("Aucune position entrée");
                               throw AucunePositionEntreeException;
                            }
                        }
                    }
                } catch(Exception e){
                    System.err.println("Une erreur c'est produite merci de recommencer");
                    setPremierClic(true);                    
                }
                
                 /////////////////////////////////////////////////////////////////////////////////
                ////////////////////////////////INGENIEUR////////////////////////////////////////
               /////////////////////////////////////////////////////////////////////////////////
                  if (aventuriers.get("Gaspard").getRole()==roleAventuriers.ingenieur){
                
                try {
                    if (premierClic){
                        tuilesAutoursNonSeches = aventuriers.get("Gaspard").AssecherTuile(aventuriers.get("Gaspard").getEstSur(),grille);
                        aventuriers.get("Gaspard").AfficherAssecher(tuilesAutoursNonSeches);
                        setPremierClic(false);
                    }else { //on entamme la procédure d'asséchement
                        System.out.println("Vous avez choisit de sécher une case : \n ");
                        if (!msg.texte.equals("")){ //si la case message à été remplie
                            String texte = msg.texte;

                            System.out.println("Assechement en cours");

                            String[] positionString;
                            positionString = texte.split(","); //parsing des coordonnées
                            int[] position = new int[4];
                            position[0] = Integer.parseInt(positionString[0]); //ligne
                            position[1] = Integer.parseInt(positionString[1]); //colonne
                            position[2] = Integer.parseInt(positionString[2]);
                            position[3] = Integer.parseInt(positionString[3]);
                            
                            if(!tuilesAutoursNonSeches.contains(grille.getTuiles()[position[0]][position[1]]) || (!tuilesAutoursNonSeches.contains(grille.getTuiles()[position[2]][position[3]]))){
                                System.err.println("Assechement impossible");
                                throw AssechementImpossibleException;
                            }else{ //on finalise la procédure d'asséchement

                                ((Ingenieur)aventuriers.get("Gaspard")).assecher2Tuiles(getGrille().getTuiles()[position[0]][position[1]],getGrille().getTuiles()[position[2]][position[3]]);
                                System.out.println("Asséchement bien effectué,la tuile : " + getGrille().getTuiles()[position[0]][position[1]].getNumLigne()+ ","
                                        + getGrille().getTuiles()[position[0]][position[1]].getNumColonne() + " est " + getGrille().getTuiles()[position[0]][position[1]].getStatut().toString());
                                
                                System.out.println("Asséchement bien effectué,la tuile : " + getGrille().getTuiles()[position[2]][position[3]].getNumLigne()+ ","
                                        + getGrille().getTuiles()[position[2]][position[3]].getNumColonne() + " est " + getGrille().getTuiles()[position[2]][position[3]].getStatut().toString());
                                premierClic = true;
                                
                            }

                        }else {
                            System.err.println("Aucune position entrée");
                            throw AucunePositionEntreeException;
                        }

                    }
                }catch(Exception e){
                    System.err.println("Une erreur c'est produite merci de recommencer");
                    setPremierClic(true);
                }
      }
                    
                //vue.setPosition("");
                //...
            break;
            case Terminer:
                //vue.setPosition("Tour terminer, joueur suivant");
                choixFinTour = true;
            break;
        }
        
        if (aventuriers.get("Gaspard").getNbaction() > 3 || choixFinTour){
            System.out.println("fin du tour");
            //vue.close();
            aventuriers.get("Gaspard").setNbaction(1);
            System.exit(0);
        }
         System.out.println("Action n°"+ aventuriers.get("Gaspard").getNbaction());
    }
    
    public final void demarrerPartie() {
        this.grille = new Grille();
        
        //to-do : récuperer les noms des différents joueurs, pour le moment je les aient initialisés à la main,
        
        joueurs.add("Gaspard");
        joueurs.add("Eddy");
        joueurs.add("Clery");
        joueurs.add("Sacha");
        
        //creation des aventuriers
        Explorateur explorateur = new Explorateur(getGrille().getTuiles()[2][4]);
        
        Ingenieur ingenieur = new Ingenieur(getGrille().getTuiles()[0][3]);
        
        Messager messager = new Messager(getGrille().getTuiles()[1][3]);
        
        Navigateur navigateur = new Navigateur(getGrille().getTuiles()[1][3]);
        
        Pilote pilote = new Pilote(getGrille().getTuiles()[2][1],false);
        
        Plongeur plongeur = new Plongeur(getGrille().getTuiles()[1][2]);
        
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
       int l =position.getNumLigne();
       return l;
    }
    
     public int getColonne(Tuile position){
       int c =position.getNumColonne();
       return c;
    }

    public Grille getGrille() {
        return grille;
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

    private void setPremierClic(boolean b) {
        this.premierClic = b;
    }
    
    public String getAventurierCourant(){
        return aventurierCourant;
    }
    
    public boolean partieTerminer(){
        boolean resultat = false;
        if(aventuriers.get(getAventurierCourant()).getRole() != roleAventuriers.plongeur 
                && aventuriers.get(getAventurierCourant()).RecupererTuile(aventuriers.get(getAventurierCourant()).getEstSur(), grille).isEmpty()
                && aventuriers.get(getAventurierCourant()).AssecherTuile(aventuriers.get(getAventurierCourant()).getEstSur(), grille).isEmpty()){
                //rajouté pas de carte helico
            resultat = true;
        }
        
        return resultat;
    }
}
