
package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilSelectionner;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;
public class ActionSelectionner extends javax.swing.AbstractAction {
  private static final long serialVersionUID =  1L;

  public static final String NOM_ACTION =  "Selectionner";

  private fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin panneauDessin;

  private fr.eseo.pdlo.projet.artiste.controleur.outils.OutilSelectionner outil;

  public ActionSelectionner(fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
  }

  public void actionPerformed(ActionEvent event) {
		this.outil = new OutilSelectionner(panneauDessin);
		this.panneauDessin.associerOutil(this.outil);
  }

}
