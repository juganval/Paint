
package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;
public class ActionChoisirModeRemplissage extends javax.swing.AbstractAction {
  private static final long serialVersionUID =  1L;

  private fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin panneauDessin;

  public ActionChoisirModeRemplissage(fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin panneauDessin, fr.eseo.pdlo.projet.artiste.modele.Remplissage remplissage) {
		super(remplissage.getMode());
		this.panneauDessin = panneauDessin;
  }

  public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals(Remplissage.AUCUNE.getMode())) {
			this.panneauDessin.setModeRemplissageCourant(Remplissage.AUCUNE);
		} else {
			this.panneauDessin.setModeRemplissageCourant(Remplissage.UNIFORME);
		}
  }

}
