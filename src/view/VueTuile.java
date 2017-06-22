package view;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import model.grille.Tuile;
import util.Utils;

public final class VueTuile extends JButton {


    private Tuile tuile;

    public VueTuile(Tuile tuile) {
        this.tuile = tuile;

        setText(tuile.getNom());

        if (tuile.getStatut() != null) switch (tuile.getStatut()) {
            case COULEE:
                setBackground(Color.DARK_GRAY);
                setBorder(BorderFactory.createLineBorder(Color.WHITE));
                repaint();
                
                break;
            case INONDEE:
                setBackground(Color.CYAN);
                setBorder(BorderFactory.createLineBorder(Color.BLACK));
                repaint();
                break;
            case ASSECHEE:
                setBackground(Color.ORANGE);
               setBorder(BorderFactory.createLineBorder(Color.RED));
               repaint();
                break;
            default:
                break;
        }

    }



}
