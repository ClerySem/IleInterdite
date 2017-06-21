/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ile_interdite.Message;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.InputStream;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import model.aventuriers.*;
import model.grille.Grille;
import model.grille.Tuile;
import util.Utils;


/**
 *
 * @author sarrasie
 */
public class VuePlateau extends Observable implements Observer {

    private Grille grille;
    private final Aventurier joueur;
 
   JFrame fenetre = new JFrame("Plateau de jeu");

    public VuePlateau(Aventurier joueur) {
       this.joueur=joueur;

        /////////////////////////////////////
        //Instanciation de la fenêtre
        
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
        // Création des tuiles du plateau
        VueGrille tuileGrille = new VueGrille(grille);
        fenetre.add(tuileGrille, BorderLayout.CENTER);
        

        /////////////////////////////////////
        //Création de la fenêtre de saisie et des boutons
       
       VueAventurier2 aventurier = new VueAventurier2(joueur.getRole().getNom(),joueur.getRole().getPion().getCouleur());
       
       
        JPanel panelSud = new JPanel();
       
        

        
        
        ((Observable) aventurier.getObservable()).addObserver(this);
        panelSud.add(aventurier);

        fenetre.add(panelSud, BorderLayout.SOUTH);
        ////////////////////////
        // création des boutons
        JPanel panelEast = new JPanel(new GridLayout(7,3));
        JButton niveau = new JButton("Niveau d'eau");
        for(int i = 0; i < 21;i++){
            if(i==11){
                panelEast.add(niveau);
            }else{
                panelEast.add(new JLabel(""));
            }
        }
       
        fenetre.add(panelEast,BorderLayout.EAST);
       
       
        niveau.addMouseListener(new MouseListener() {
              VueNiveau niveauEau = new VueNiveau(1);
            @Override
            public void mouseClicked(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
               //niveauEau.Affiche();
            }
            @Override
            public void mouseReleased(MouseEvent e) {
               //niveauEau.close();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                niveauEau.Affiche();
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
          
    });
               
        /*JPanel grilleSud = new JPanel(new GridLayout(3, 2, 5, 5)); // permet de creer une grille avec des espaces entre les différents boutons
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

        }*/
 /* deplacer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Déplacement");
               
                setChanged();
                Message m = new Message(Utils.Commandes.BOUGER, Integer.MIN_VALUE, Integer.MIN_VALUE, Utils.Tresor.PIERRE, Integer.SIZE);
                notifyObservers(m);
                clearChanged();
            }
        });
       
        assecher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Assechement");
               
                setChanged();
                Message m = new Message(Utils.Commandes.ASSECHER, Integer.MIN_VALUE, Integer.MIN_VALUE, Utils.Tresor.PIERRE, Integer.SIZE);
                notifyObservers(m);
                clearChanged();

            }
        });
       
        terminerT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("tour terminé");
 
                setChanged();
                Message m = new Message(Utils.Commandes.TERMINER, Integer.MIN_VALUE, Integer.MIN_VALUE, Utils.Tresor.PIERRE, Integer.SIZE);
                notifyObservers(m);
                clearChanged();
            }
        });
       
        autresActions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Autres Actions réalisées"
                        + "00000000000000000.");
 
                setChanged();
                Message m = new Message(Utils.Commandes.DONNER, Integer.MIN_VALUE, Integer.MIN_VALUE, Utils.Tresor.PIERRE, Integer.SIZE);
                notifyObservers(m);
                clearChanged();
            }
        });*/
   
       
      
    }
    public void close(){
        fenetre.setVisible(false);
    }
    public void Affiche(){
        fenetre.setVisible(true);
    }
   

    /*public static void main(String[] args) {
        // TODO code application logic here
 
       
        VuePlateau vueplateau = new VuePlateau();
    }*/

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("recu");
    }
    
    
    

}


