/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ile_interdite.Message;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayer;
import javax.swing.JPanel;
import javax.swing.JTextField;
import util.panelInscription;

/**
 *
 * @author anthoing
 */
public class VueInscription extends Observable {

    private final JFrame window;
    private static final int LONGEUR_FENETRE = 700;
    private static final int HAUTEUR_FENETRE = 500;

    public VueInscription() {
        this.window = new JFrame();
        JPanel mainPanel = new panelInscription(LONGEUR_FENETRE, HAUTEUR_FENETRE);
        window.setSize(LONGEUR_FENETRE, HAUTEUR_FENETRE);
        window.setTitle("Inscription");
        window.add(mainPanel);
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

        JPanel panelCentre = new JPanel(new BorderLayout());
        panelCentre.setOpaque(false);
        mainPanel.add(panelCentre, BorderLayout.CENTER);

        /*  -----------------------------------------------------
            |   Creation label etc... pour ajout des joueurs    |
            -----------------------------------------------------
        */
        
        JPanel panelCentreHaut = new JPanel(new GridLayout(1, 3));
        panelCentre.add(panelCentreHaut, BorderLayout.NORTH);
        JLabel choixJoueurs = new JLabel("\t Choix du nombre de joueurs : ");
        choixJoueurs.setForeground(Color.WHITE);
        panelCentreHaut.add(choixJoueurs);
        panelCentreHaut.setOpaque(false);
        Integer[] choixNbJoueurs = {2, 3, 4};
        JComboBox nbJoueurs = new JComboBox(choixNbJoueurs);
        panelCentreHaut.add(nbJoueurs);
        panelCentreHaut.add(new JLabel(""));

        JPanel panelCentreCentre = new JPanel(new GridLayout(10, 2));
        panelCentreCentre.setOpaque(false);
        panelCentre.add(panelCentreCentre);

        JLabel j1 = new JLabel("\t Entrer le nom du joueur 1 : ");
        j1.setForeground(Color.WHITE);
        JTextField nomJoueur1 = new JTextField();
        JLabel j2 = new JLabel("\t Entrer le nom du joueur 2 : ");
        JTextField nomJoueur2 = new JTextField();
        j2.setForeground(Color.WHITE);
        JLabel j3 = new JLabel("\t Entrer le nom du joueur 3 : ");
        j3.setForeground(Color.WHITE);
        JTextField nomJoueur3 = new JTextField();
        JLabel j4 = new JLabel("\t Entrer le nom du joueur 4 : ");
        j4.setForeground(Color.WHITE);
        JTextField nomJoueur4 = new JTextField();

        j1.setVisible(false);
        j2.setVisible(false);
        j3.setVisible(false);
        j4.setVisible(false);
        nomJoueur1.setVisible(false);
        nomJoueur2.setVisible(false);
        nomJoueur3.setVisible(false);
        nomJoueur4.setVisible(false);

        for (int k = 0; k < 16; k++) {
            if (k == 2) {
                panelCentreCentre.add(j1);
                k++;
                panelCentreCentre.add(nomJoueur1);
            } else if (k == 6) {
                panelCentreCentre.add(j2);
                k++;
                panelCentreCentre.add(nomJoueur2);
            } else if (k == 10) {
                panelCentreCentre.add(j3);
                k++;
                panelCentreCentre.add(nomJoueur3);
            } else if (k == 14) {
                panelCentreCentre.add(j4);
                k++;
                panelCentreCentre.add(nomJoueur4);
            } else {
                panelCentreCentre.add(new JLabel(""));
            }
        }
        j1.setVisible(true);
        nomJoueur1.setVisible(true);
        j2.setVisible(true);
        nomJoueur2.setVisible(true);
        
        /*  --------------------------------------------------------------------
            |Gestion de l'affichage en fonction du nb de joueurs choisit       |
            --------------------------------------------------------------------
        */
        
        nbJoueurs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                int nbJoueurs = (int) cb.getSelectedItem();
                switch (nbJoueurs) {
                    case 2:
                        j3.setVisible(false);
                        nomJoueur3.setVisible(false);
                        j4.setVisible(false);
                        nomJoueur4.setVisible(false);
                        break;
                    case 3:
                        j3.setVisible(true);
                        nomJoueur3.setVisible(true);
                        j4.setVisible(false);
                        nomJoueur4.setVisible(false);
                        break;
                    case 4:
                        j3.setVisible(true);
                        nomJoueur3.setVisible(true);
                        j4.setVisible(true);
                        nomJoueur4.setVisible(true);
                        break;
                    default:
                        break;
                }
            }
        });

        JPanel panelBas = new JPanel(new GridLayout());
        panelBas.setOpaque(false);
        mainPanel.add(panelBas, BorderLayout.SOUTH);

        panelBas.add(new JLabel(""));
        JButton btnValider = new JButton("Valider");
        panelBas.add(btnValider);
        panelBas.add(new JLabel(""));
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Message m = new Message();
                
                //on vérifie si les champs sont remplie et on les ajoutes au message 
                if (!nomJoueur1.getText().isEmpty()) m.addJoueur(nomJoueur1.getText());
                if (!nomJoueur2.getText().isEmpty()) m.addJoueur(nomJoueur2.getText());
                if (!nomJoueur3.getText().isEmpty()) m.addJoueur(nomJoueur3.getText());
                if (!nomJoueur4.getText().isEmpty()) m.addJoueur(nomJoueur4.getText());
                
                setChanged();
                notifyObservers(m);
                clearChanged();
            }
        });
        
        this.window.setVisible(true);
        mainPanel.repaint();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        new VueInscription();
    }

}
