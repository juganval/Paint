
package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JColorChooser;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;
public class ActionChangerCouleur extends javax.swing.AbstractAction {
  private static final long serialVersionUID =  1L;

  public static final String NOM_ACTION =  "changer Couleur";

  private fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin panneauDessin;

  private int indice;

  public ActionChangerCouleur(fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
  }

  public void actionPerformed(ActionEvent event) {
		indice = this.panneauDessin.getIndice();
		Color choisirCouleur = JColorChooser.showDialog(this.panneauDessin, NOM_ACTION,
				this.panneauDessin.getCouleurCourante());
		if (choisirCouleur != null) {
			this.panneauDessin.getVueFormes().get(indice).getForme().setCouleur(choisirCouleur);
			this.panneauDessin.repaint();
		}
  }

}
