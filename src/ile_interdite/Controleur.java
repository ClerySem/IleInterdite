/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;

import static ile_interdite.TypesMessages.Deplacer;
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
import view.VueAventurier;
import util.Utils;
import model.aventuriers.*;

/**
 *
 * @author semanazc
 */
public class Controleur implements Observateur {
    
    private final VueAventurier vue;
    private final HashMap<String,Aventurier> aventuriers;
    private Grille grille;
    private boolean premierClic;
    private ArrayList<Tuile> tuilesAutours;
    private ArrayList<Tuile> tuilesAutoursNonSeches;
    private boolean choixFinTour;
    private boolean veutVoler;
    
    public Controleur() {
        
        //initialisation des attributs
        this.aventuriers = new HashMap<>();
        this.premierClic = true;
        this.tuilesAutours = new ArrayList<>();
        this.tuilesAutoursNonSeches = new ArrayList<>();
        this.choixFinTour = false;
        this.veutVoler=false;
        
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
        aventuriers.put("Gaspard", new Messager(getGrille().getTuiles()[1][2]));
        vue = new VueAventurier("Gaspard", aventuriers.get("Gaspard").getRole().getNom(), aventuriers.get("Gaspard").getRole().getPion().getCouleur());
        afficherGrilleConsole();
        vue.setObservateur(this);
        if(aventuriers.get("Gaspard").getNbaction() > 3 || choixFinTour){
            //fermeture de la fenêtre et ouverture de celle du nouvel aventurier
            vue.close();
        }
        
        //vue.affiche();
        
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
            vue.close();
        }
                    if (premierClic){
                        tuilesAutours = aventuriers.get("Gaspard").RecupererTuile(aventuriers.get("Gaspard").getEstSur(),grille);
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
                
                vue.setPosition(""); //clear de la zone de texte de la vue
               
            break;
           case Assecher:
               
                
                try {
                    if (premierClic){
                        tuilesAutoursNonSeches = AssecherTuile(aventuriers.get("Gaspard").getEstSur());
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
               
                
                vue.setPosition(""); //clear de la zone de texte de la vue
            break;
            case Autre:
                veutVoler=true;
                
             ////////////////////////////////////////////////////////////////////////////
            //////////////////////////////Pilote////////////////////////////////////////
           ////////////////////////////////////////////////////////////////////////////

                try{
                    if (aventuriers.get("Gaspard").getRole()==roleAventuriers.pilote){


                        if (premierClic){
                            tuilesAutours = RecupererTuile(aventuriers.get("Gaspard").getEstSur());
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
                        tuilesAutoursNonSeches = AssecherTuile(aventuriers.get("Gaspard").getEstSur());
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
                    
                vue.setPosition("");
                //...
            break;
            case Terminer:
                vue.setPosition("Tour terminer, joueur suivant");
                choixFinTour = true;
            break;
                
            
        }
        
        if (aventuriers.get("Gaspard").getNbaction() > 3 || choixFinTour){
            System.out.println("fin du tour");
            vue.close();
            aventuriers.get("Gaspard").setNbaction(1);
            System.exit(0);
            
             
        }
         System.out.println("Action n°"+ aventuriers.get("Gaspard").getNbaction());
         
       
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
     
      ////////////////////////////////////////////////////////////////////////////////////
     ////////////////////////////////////////////////////////////////////////////////////  
    ////////////////////////////////SE DEPLACER/////////////////////////////////////////
   ////////////////////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////////////////////     
    /*
     public ArrayList<Tuile> RecupererTuile(Tuile position) throws Exception{
        int l = getLigne(position);
        int c = getColonne(position);
        roleAventuriers roleAventurierCourant = aventuriers.get("Gaspard").getRole();
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
        
        /*
        -----------------------------------------------------------
                      On va gérer les cas particuliers
                           (explorateur et plongeur)
        -----------------------------------------------------------
        
        
        if(roleAventurierCourant == roleAventuriers.explorateur){ //peut se déplacer en diagonale
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
           
        for (Tuile tuile : tuiles) { //on ajoute toutes les tuiles sèche à tuilesFin
            if (tuile!=null && tuile.getStatut()==Utils.EtatTuile.ASSECHEE ){
                tuilesFin.add(tuile);
            }
        }
        
        //Gestion du cas du plongeur, il faut ajouter toutes les tuiles à cotée d'une tuile mouillée
        if(roleAventurierCourant == roleAventuriers.plongeur){
            HashSet<Tuile> tuilesPlongeur = new HashSet<>();
            deplacementPlongeur(position, position, tuilesPlongeur);
            tuilesFin.clear();
            tuilesPlongeur.forEach(tuile -> {
                if(!position.equals(tuile))tuilesFin.add(tuile);
            });
        }
        
        
        //Gestion du cas du pilote, il faut ajouter toute les tuiles seches
        
        if(roleAventurierCourant == roleAventuriers.pilote){
            Exception aDejaVoleException = new Exception();
             if (((Pilote)aventuriers.get("Gaspard")).getAvole()==false && veutVoler==true){
                ((Pilote)aventuriers.get("Gaspard")).setAvole(true);
                 setVeutVoler(false);
                tuiles.clear();
                for(int i = 0; i <6; i++){
                    for (int j = 0; j < 6; j++){
                        tuiles.add(grille.getTuiles()[i][j]);
                    }
                }
                tuilesFin.clear();
                for (Tuile tuilePilote : tuiles){
                    if(tuilePilote!=null && tuilePilote.getStatut()==Utils.EtatTuile.ASSECHEE && tuilePilote!= aventuriers.get("Gaspard").getEstSur()){
                        tuilesFin.add(tuilePilote);
                    }


                }

            }else if (((Pilote)aventuriers.get("Gaspard")).getAvole()== true  && veutVoler==true){
            System.err.println("Erreur vous avez déjà volé");
                setVeutVoler(false);
                throw aDejaVoleException;
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
     }*/
    
       ////////////////////////////////////////////////////////////////////////////////////
      ////////////////////////////////////////////////////////////////////////////////////
     //////////////////////////ASSECHER TUILE ///////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////
   ////////////////////////////////////////////////////////////////////////////////////
     
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

    private void setPremierClic(boolean b) {
        this.premierClic = b;
    }

    public void deplacementPlongeur(Tuile anciennePosition,Tuile position, HashSet<Tuile> tuilesPlongeur){
        
        int l = getLigne(position);
        int c = getColonne(position);
        
        ArrayList<Tuile> tuiles = new ArrayList<>();
        
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

            for(Tuile tuile : tuiles){
                if (tuile!=null && tuile.getStatut()==Utils.EtatTuile.ASSECHEE){ //si la tuile autour de lui est seche alors on ajoute la tuile
                    tuilesPlongeur.add(tuile);
                } else if ((tuile!=null && tuile.getStatut()==Utils.EtatTuile.INONDEE || tuile!=null && tuile.getStatut()==Utils.EtatTuile.COULEE)
                            && !anciennePosition.equals(tuile)){ // si la tuile est innondée au coulée on ajoute les tuiles sèches autours
                    
                    deplacementPlongeur(position,tuile,tuilesPlongeur);
                }
            }

    }

    public void setVeutVoler(boolean veutVoler) {
        this.veutVoler = veutVoler;
    }
    
  
    
}
