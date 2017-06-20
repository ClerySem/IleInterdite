/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import util.panelInscription;

/**
 *
 * @author anthoing
 */
public class VueInscription extends Observable {

    private final JFrame window;
    private static int LONGEUR_FENETRE = 700;
    private static int HAUTEUR_FENETRE = 500;

    public VueInscription() {
        
        this.window = new JFrame();
        JPanel mainPanel = new panelInscription(LONGEUR_FENETRE, HAUTEUR_FENETRE);
        window.setSize(LONGEUR_FENETRE, HAUTEUR_FENETRE);
        window.setTitle("Inscription");
        window.add(mainPanel);
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        
        JPanel panelCentre = new JPanel(new GridBagLayout());
        panelCentre.setOpaque(false);
        mainPanel.add(panelCentre, BorderLayout.CENTER);
        
        JLabel choixJoueurs = new JLabel("Choix du nombre de joueurs");
        /*GridBagConstraints contrainteChoixJoueurs = new GridBagConstraints();
        contrainteChoixJoueurs.fill = GridBagConstraints.HORIZONTAL;
        contrainteChoixJoueurs.gridx = 0;
        contrainteChoixJoueurs.gridy = 0;
        panelCentre.add(choixJoueurs, contrainteChoixJoueurs);*/
        
       GridBagConstraints contrainteComboBox = new GridBagConstraints();
        Integer[] choixNbJoueurs = { 2, 3, 4};
        JComboBox nbJoueurs = new JComboBox(choixNbJoueurs);
        
/*        
contrainteComboBox.fill = GridBagConstraints.HORIZONTAL;
contrainteComboBox.weightx = 0.0;
contrainteComboBox.gridx = 1;
contrainteComboBox.gridy = 0;
panelCentre.add(nbJoueurs, contrainteComboBox);*/

/*button = new JButton("5");
c.fill = GridBagConstraints.HORIZONTAL;
c.ipady = 0;       //reset to default
c.weighty = 1.0;   //request any extra vertical space
c.anchor = GridBagConstraints.PAGE_END; //bottom of space
c.insets = new Insets(10,0,0,0);  //top padding
c.gridx = 1;       //aligned with button 2
c.gridwidth = 2;   //2 columns wide
c.gridy = 2;       //third row
panelCentre.add(button, c);*/
        
        
        //panelCentre.add(nbJoueurs);
        
JButton button;

panelCentre.setLayout(new GridBagLayout());
GridBagConstraints c = new GridBagConstraints();

button = new JButton("Button 1");
c.fill = GridBagConstraints.HORIZONTAL;
c.gridx = 0;
c.gridy = 0;
panelCentre.add(choixJoueurs, c);

button = new JButton("Button 2");
c.fill = GridBagConstraints.HORIZONTAL;
c.weightx = 0.5;
c.gridx = 1;
c.gridy = 0;
panelCentre.add(nbJoueurs, c);

button = new JButton("Button 3");
c.fill = GridBagConstraints.HORIZONTAL;
c.weightx = 0.5;
c.gridx = 2;
c.gridy = 0;
panelCentre.add(button, c);

button = new JButton("Long-Named Button 4");
c.fill = GridBagConstraints.HORIZONTAL;
c.ipady = 40;      //make this component tall
c.weightx = 0.0;
c.gridwidth = 3;
c.gridx = 0;
c.gridy = 1;
panelCentre.add(button, c);

button = new JButton("5");
c.fill = GridBagConstraints.HORIZONTAL;
c.ipady = 0;       //reset to default
c.weighty = 1.0;   //request any extra vertical space
c.anchor = GridBagConstraints.PAGE_END; //bottom of space
c.insets = new Insets(10,0,0,0);  //top padding
c.gridx = 1;       //aligned with button 2
c.gridwidth = 2;   //2 columns wide
c.gridy = 2;       //third row
panelCentre.add(button, c);        
        
        JTextField nomJoueur1 = new JTextField();
        JTextField nomJoueur2 = new JTextField();
        JTextField nomJoueur3 = new JTextField();
        JTextField nomJoueur4 = new JTextField();
       
        
        JPanel panelBas = new JPanel(new GridLayout());
        panelBas.setOpaque(false);
        mainPanel.add(panelBas, BorderLayout.SOUTH);

        panelBas.add(new JLabel(""));
        JButton btnValider = new JButton("Valider");
        panelBas.add(btnValider);
        panelBas.add(new JLabel("")); 
         
         
         
         
         
         
         
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
