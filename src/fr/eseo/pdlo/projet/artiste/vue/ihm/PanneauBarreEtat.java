
package fr.eseo.pdlo.projet.artiste.vue.ihm;

import javax.swing.JLabel;
import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
public class PanneauBarreEtat extends javax.swing.JPanel {
  private static final long serialVersionUID =  1L;

  private JLabel valeurX;

  private JLabel valeurY;

  public PanneauBarreEtat(PanneauDessin panneauDessin) {
		this.valeurX = new JLabel("x: 0");
		this.valeurY = new JLabel("y: 0");
		panneauDessin.addMouseMotionListener(this);
		this.add(valeurX);
		this.add(valeurY);
  }

  public void mouseDragged(java.awt.event.MouseEvent event) {
		mettreAJourAffichage(new Coordonnees(event.getX(), event.getY()));
  }

  public void mouseMoved(java.awt.event.MouseEvent event) {
		mettreAJourAffichage(new Coordonnees(event.getX(), event.getY()));
  }

  private void mettreAJourAffichage(fr.eseo.pdlo.projet.artiste.modele.Coordonnees coords) {
		this.valeurX.setText("x: " + coords.getAbscisse());
		this.valeurY.setText("y: " + coords.getOrdonnee());
  }

}
