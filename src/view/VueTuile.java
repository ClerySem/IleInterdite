package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import model.aventuriers.Aventurier;
import model.grille.Tuile;
import util.Utils;

public final class VueTuile extends JPanel {


    private Tuile tuile;
    private JButton boutonTuile;
    
    public VueTuile(Tuile tuile) {
        this.tuile = tuile;
        this.boutonTuile = new JButton();
        
        setLayout(new BorderLayout());
        add(getBoutonTuile(), BorderLayout.CENTER);
        
        getBoutonTuile().setText(tuile.getNom());

        if (tuile.getStatut() != null) switch (tuile.getStatut()) {
            case COULEE:
                getBoutonTuile().setBackground(Color.DARK_GRAY);
                getBoutonTuile().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                getBoutonTuile().setForeground(Color.white);
                break;
                
            case INONDEE:
                getBoutonTuile().setBackground(Color.CYAN);
                getBoutonTuile().setBorder(BorderFactory.createLineBorder(Color.BLACK));
                break;
                
            case ASSECHEE:
                getBoutonTuile().setBackground(Color.ORANGE);
               getBoutonTuile().setBorder(BorderFactory.createLineBorder(Color.RED));
                break;
                
            default:
                break;
        }
        
        JPanel panelBas = new JPanel(new GridLayout(1,1));
        add(panelBas, BorderLayout.SOUTH);
        
        if (tuile.getPossede().size() == 2){
              
            panelBas = new JPanel(new GridLayout(1,2));
            add(panelBas, BorderLayout.SOUTH);
           
            } else if (tuile.getPossede().size() > 2){
                panelBas = new JPanel(new GridLayout(2,2));
                add(panelBas, BorderLayout.SOUTH);
            }
                
        
        for (Aventurier aventurier : tuile.getPossede()){
            
            JPanel panelAventurier = new JPanel();
            panelAventurier.setBackground(aventurier.getRole().getPion().getCouleur());
            panelBas.add(panelAventurier, BorderLayout.SOUTH);
            
        }

    }

    public JButton getBoutonTuile() {
        return boutonTuile;
    }

    
    

}
