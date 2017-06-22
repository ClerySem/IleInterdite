package view;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import model.grille.Tuile;
import util.Utils;

public final class VueTuile extends JPanel {

    private JButton boutonTuile;
    private Tuile tuile;

    public VueTuile(Tuile tuile) {
        this.tuile = tuile;
        this.boutonTuile = new JButton();

        getBoutonTuile().setText(tuile.getNom());
        add(boutonTuile);

        if (tuile.getStatut() != null) switch (tuile.getStatut()) {
            case COULEE:
                getBoutonTuile().setBackground(Color.DARK_GRAY);
                getBoutonTuile().setBorder(BorderFactory.createLineBorder(Color.WHITE));
                repaint();
                break;
            case INONDEE:
                getBoutonTuile().setBackground(Color.CYAN);
                getBoutonTuile().setBorder(BorderFactory.createLineBorder(Color.BLACK));
                repaint();
                break;
            case ASSECHEE:
                getBoutonTuile().setBackground(Color.ORANGE);
                getBoutonTuile().setBorder(BorderFactory.createLineBorder(Color.RED));
                repaint();
                break;
            default:
                break;
        }

    }

    public JButton getBoutonTuile() {
        return boutonTuile;
    }

}
