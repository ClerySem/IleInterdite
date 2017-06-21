package view;

import ile_interdite.Message;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.aventuriers.Aventurier;
import model.aventuriers.Explorateur;
import model.aventuriers.Pilote;
import model.aventuriers.roleAventuriers;
import model.grille.Grille;
import model.grille.Tuile;
import util.Utils;
 
public class VueGrille extends JPanel{
   
    private Tuile [][] tuiles;
    private Grille grille;
    
    private static class MyObservable extends Observable {
        
        @Override
        public void setChanged() {
            super.setChanged();
        }

        @Override
        public void clearChanged() {
            super.clearChanged();
        }
    }
    private MyObservable observable = new MyObservable();
    
    public VueGrille(Grille grille) {
        this.setLayout(new GridLayout(6,6,5,5));//creation d'une grille 6*6 avec des espaces entre chaque bouton de la grille
      
        this.tuiles = new Tuile [6][6];
          for(int i =0; i< tuiles.length; i++){;
            int [] colonne = new int[6];
            for(int j =0; j< colonne.length; j++){
                if (       i == 0 && j == 0
                        || i == 0 && j == 1
                        || i == 0 && j == 4
                        || i == 0 && j == 5 // toutes les cases vides de la première ligne
                        || i == 1 && j == 0
                        || i == 1 && j == 5 // toutes les cases vides de la 2eme ligne
                        || i == 4 && j == 0
                        || i == 4 && j == 5 // toutes les cases vides de la 5eme ligne
                        || i == 5 && j == 0
                        || i == 5 && j == 1
                        || i == 5 && j == 4
                        || i == 5 && j == 5 // toutes les cases vides de la 6eme ligne
                        ) {
                    this.add(new JLabel(""));
                } else {          // les tuiles non vide
                    
                    Tuile tuile = new Tuile(i, j);
                    tuile.setText(tuile.getNom());
                    // modifie la couleur de la bordure
                    this.add((JButton) tuile);
                    tuile.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.out.println(tuile.getNumLigne() + "," + tuile.getNumColonne());
                            observable.setChanged();
                            MessageVue m = new MessageVue(tuile.getNumLigne() + "," + tuile.getNumColonne());
                            observable.notifyObservers(m);
                            observable.clearChanged();
                            
                            
                            
                        }
                    });
                    
                    if (tuile.getStatut()==Utils.EtatTuile.COULEE){
                        tuile.setBackground(Color.DARK_GRAY);
                        tuile.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                    }else if(tuile.getStatut()==Utils.EtatTuile.INONDEE){
                        tuile.setBackground(Color.CYAN);
                        tuile.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                        
                    }else if(tuile.getStatut()==Utils.EtatTuile.ASSECHEE){
                        tuile.setBackground(Color.ORANGE);
                        tuile.setBorder(BorderFactory.createLineBorder(Color.RED));
                    }
   
                   /*  Aventurier aventu = new Explorateur(tuiles[4][3]);
                     if(aventu.getRole() == roleAventuriers.explorateur){
                         System.out.println("564");
                     }
                   
                       for(Aventurier avent : tuile.getPossede()){
                           
                        System.out.println("111");
                        if(avent.getRole() == roleAventuriers.pilote){
                            avent.getEstSur().setBackground(avent.getRole().getPion().getCouleur());
                            System.out.println("aaa");
                        }else{
                            tuile.setBackground(Color.red);
                            System.out.println("bbb");
                        }
                    }*/
                    
                }
            }

        }
        }

    public MyObservable getObservable() {
        return observable;
    }
    
        
        public void setTuileColor(Tuile tuile, Color couleur){
            tuile.setBackground(couleur);
        }
        
        public Grille getGrille(){
            return grille;
        }

        
       
       
    }


    