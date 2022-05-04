
package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JColorChooser;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;
public class ActionChoisirCouleur extends javax.swing.AbstractAction {
  private static final long serialVersionUID =  1L;

  public static final String NOM_ACTION =  "Choisir Couleur";

  private fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin panneauDessin;

  public ActionChoisirCouleur(fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
  }

  public void actionPerformed(ActionEvent event) {
		Color choisirCouleur = JColorChooser.showDialog(this.panneauDessin, NOM_ACTION,
				this.panneauDessin.getCouleurCourante());
		if (choisirCouleur != null) {
			this.panneauDessin.setCouleurCourante(choisirCouleur);
			this.panneauDessin.repaint();
		}
  }

}
