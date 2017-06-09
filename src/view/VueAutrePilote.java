/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author sarrasie
 */
public class VueAutrePilote {
    private JFrame fenetre;
    private JPanel panel;
    private JButton capacite;
    private JButton donnerCarte;
   public VueAutrePilote(){
    
        JFrame fenetre = new JFrame("Choix");
        fenetre.setSize(500,150);
        fenetre.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
       
        
        JPanel grille = new JPanel(new GridLayout(3,3));
        grille.setBackground(Color.blue);
        fenetre.add(grille);
     
        JButton capacite = new JButton("Voler");
        JButton donnerCarte = new JButton("Donner une carte");
        
        for(int i = 0; i<9 ; i++){
        if(i==3){
            grille.add(capacite);
        }
        else if(i==5){
            grille.add(donnerCarte);
            
        }else{
            grille.add(new JLabel(""));
        }
            
        }
        fenetre.setVisible(true);
        
        capacite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("bouton cliqué");
            }
        });
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        VueAutrePilote vue = new VueAutrePilote();
    }
    
}
