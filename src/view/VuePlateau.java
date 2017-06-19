/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.Observable;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import model.grille.Grille;

/**
 *
 * @author sarrasie
 */
public class VuePlateau extends Observable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        /////////////////////////////////////
        //Instanciation de la fenêtre 
        JFrame fenetre = new JFrame("Plateau de jeu");
        fenetre.setSize(1000, 1000);
        fenetre.setLayout(new BorderLayout());
        fenetre.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

        /////////////////////////////////////
        //Creation de panel et ajout d'un titre
        JPanel panelNord = new JPanel();
        panelNord.setLayout(new GridBagLayout());
        panelNord.setPreferredSize(new Dimension(0, 75)); // modification de la taille du panel 

        //InputStream is = VuePlateau.classgetResourcesAsStream("./font/Pieces of Eight.ttf");
        JLabel titre = new JLabel("Île interdite");
        titre.setForeground(Color.BLUE);
        titre.setFont(new Font("Serif", Font.BOLD, 20));

        panelNord.add(titre);
        panelNord.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // permet de centrer le texte au milieu du panel
        fenetre.add(panelNord, BorderLayout.NORTH);

        /////////////////////////////////////
        //Création de la grille pour les cases du plateau de jeu
        JPanel grille = new JPanel(new GridLayout(6, 6, 15, 15));
        fenetre.add(grille, BorderLayout.CENTER);
        fenetre.setVisible(true);

        /////////////////////////////////////
        // Création des tuiles du plateau
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
                    grille.add(new JLabel(""));
                } else {                    // les tuiles non vide 
                    TuileGrille tuile = new TuileGrille(i, j);
                    tuile.setText(i + "," + j);
                    tuile.setBorder(BorderFactory.createLineBorder(Color.green));// modifie la couleur de la bordure
                    grille.add((JButton) tuile);
                }
            }

        }
        ////////////////////////
        // création des boutons 
        JPanel grilleSud = new JPanel(new GridLayout(3, 2, 5, 5)); // permet de creer une grille avec des espaces entre les différents boutons 
        grilleSud.setPreferredSize(new Dimension(0, 80));
        fenetre.add(grilleSud, BorderLayout.SOUTH);

        JButton deplacer = new JButton("Déplacer");

        JButton autresActions = new JButton("Autres Actions");
        JButton assecher = new JButton("Assécher");
        JButton terminerT = new JButton("Terminer tour");

        for (int i = 1; i <= 6; i++) {
            if (i == 3) {
                grilleSud.add(deplacer);
            } else if (i == 4) {
                grilleSud.add(assecher);
            } else if (i == 5) {
                grilleSud.add(autresActions);
            } else if (i == 6) {
                grilleSud.add(terminerT);
            } else {
                grilleSud.add(new JLabel(""));
            }

        }
        deplacer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Déplacement");
            }
        });
        
        assecher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Assechement");

            }
        });
        
        terminerT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("tour terminé");
  
            }
        });
        
        autresActions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Autres Actions réalisées");
  
            }
        });
    }

}
