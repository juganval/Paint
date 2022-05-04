
package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;
public class ActionEffacer extends javax.swing.AbstractAction {
  private static final long serialVersionUID =  1L;

  public static final String NOM_ACTION =  "Effacer Tout";

  private fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin panneauDessin;

  public ActionEffacer(fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
  }

  public void actionPerformed(ActionEvent event) {
		int k = JOptionPane.showConfirmDialog(panneauDessin, NOM_ACTION, NOM_ACTION, JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE);
		if (k == 0) {
			for (int i = this.panneauDessin.getVueFormes().size() - 1; i >= 0; i--) {
				this.panneauDessin.getVueFormes().remove(i);
			}
		}
		this.panneauDessin.repaint();
  }

}
