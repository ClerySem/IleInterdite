/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author sarrasie
 */
public class VueAutre {
    private JFrame fenetre;
    private JPanel panel;
    private JButton capacite;
    private JButton donnerCarte;
    
public VueAutre(){
        JFrame fenetre = new JFrame("Choix");
        fenetre.setSize(500,150);
        fenetre.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
       
        JPanel Grille = new JPanel(new GridLayout(3,3));
        fenetre.add(Grille);
     
        JButton capacite = new JButton("capacité");
        JButton donnerCarte = new JButton("Donner une carte");
        
        for(int i = 0; i<9 ; i++){
        if(i==3){
            Grille.add(capacite);
        }
        else if(i==5){
            Grille.add(donnerCarte);
            
        }else{
            Grille.add(new JLabel(""));
        }
            
        }
        fenetre.setVisible(true);
        
        capacite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Bouton cliqué");
            }
        });
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        VueAutre vueAutre = new VueAutre();
    }
    
}
