
package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;
public class ActionChoisirCrenelage extends javax.swing.AbstractAction {
  private static final long serialVersionUID =  1L;

  public static final String NOM_ACTION =  "Crenelage";

  private fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin panneauDessin;

  public ActionChoisirCrenelage(fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
  }

  public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals(NOM_ACTION)
				&& panneauDessin.getModeCrenelageCourant().equals(RenderingHints.VALUE_ANTIALIAS_OFF)) {
			this.panneauDessin.setModeCrenelageCourant(RenderingHints.VALUE_ANTIALIAS_ON);
		} else {
			this.panneauDessin.setModeCrenelageCourant(RenderingHints.VALUE_ANTIALIAS_OFF);
		}
		this.panneauDessin.repaint();
  }

}
