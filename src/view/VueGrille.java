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

public class VueGrille extends JPanel {

    //////////////////////////VUEGRILLE DEVIENT OBSEVABLE//////////////////////
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
        creationGrille(grille);

    }

    ///////ACTUALISER LA GRILLE//////////////////////////////////////////////////////////////////////////////////////////
/////MARCHE PAS/////
    public void updateGrille(Grille grille) {
        this.removeAll();
        creationGrille(grille);
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

   

    public final void creationGrille(Grille grille) {
        
        this.setLayout(new GridLayout(6, 6, 5, 5));//creation d'une grille 6*6 avec des espaces entre chaque bouton de la grille
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == 0 && j == 0
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

                    Tuile tuile = grille.getTuiles()[i][j];
                    VueTuile btnTuile = new VueTuile(tuile);
                    // modifie la couleur de la bordure
                    this.add(btnTuile);
                    ////////////////////////////LISTENER BOUTON TUILE///////////////////////////
                    btnTuile.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            observable.setChanged();
                            MessageVue m = new MessageVue(tuile.getNumLigne() + "," + tuile.getNumColonne());
                            observable.notifyObservers(m);
                            observable.clearChanged();
                        }
                    });

                }
            }
        }
    }

    public MyObservable getObservable() {
        return observable;
    }
    
   
}
