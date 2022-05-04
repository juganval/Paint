
package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Forme;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;
public class OutilSelectionner extends Outil {
  private fr.eseo.pdlo.projet.artiste.modele.formes.Forme formeSelectionnee;

  private fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin panneauDessin;

  public OutilSelectionner(fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin panneauDessin) {
		this.panneauDessin = panneauDessin;
  }

  public void mouseClicked(MouseEvent event) {
		boolean bool = false;
		for (int i = this.panneauDessin.getVueFormes().size() - 1; i >= 0; i--) {
			if (this.panneauDessin.getVueFormes().get(i).getForme()
					.contient(new Coordonnees(event.getX(), event.getY())) && !bool) {
				this.formeSelectionnee = this.panneauDessin.getVueFormes().get(i).getForme();
				this.panneauDessin.setIndice(i);
				JOptionPane.showMessageDialog(panneauDessin, this.formeSelectionnee.toString(),
						ActionSelectionner.NOM_ACTION, JOptionPane.INFORMATION_MESSAGE);
				bool = true;
				// break; A voir avec la prof ce qui est mieux (bool ou break)
			}
		}

  }

}
