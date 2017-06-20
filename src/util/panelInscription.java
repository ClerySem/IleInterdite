/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author anthoing
 */
public class panelInscription extends JPanel {

    private Image image;
    private Integer width, height;
    JLabel titre;
    JTextField champNom, champPrenom;

    public panelInscription(int width, int height) {

        super();
        this.width = width;
        this.height = height;

        try {
            this.image = ImageIO.read(new File(System.getProperty("user.dir") + "/src/images/ileperdue.jpg"));
        } catch (IOException ex) {
            System.err.println("Erreur de lecture");
        }

        this.setLayout(new BorderLayout());

        titre = new JLabel("Inscription", JLabel.CENTER);
        titre.setFont(new Font(titre.getFont().getFamily(), titre.getFont().getStyle(), 24));
        titre.setForeground(Color.lightGray);
        this.add(titre, BorderLayout.NORTH);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, width, height, null, this);
    }

}
