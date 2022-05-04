
package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilCarre;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilCercle;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilEllipse;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilRectangle;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;
public class ActionChoisirForme extends javax.swing.AbstractAction {
  private static final long serialVersionUID =  1L;

  public static final String NOM_ACTION_LIGNE =  "Ligne";

  public static final String NOM_ACTION_ELLIPSE =  "Ellipse";

  public static final String NOM_ACTION_CERCLE =  "Cercle";

  public static final String NOM_ACTION_RECTANGLE =  "Rectangle";

  public static final String NOM_ACTION_CARRE =  "Carre";

  private fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin panneauDessin;

  public ActionChoisirForme(fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin panneauDessin, fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreOutils panneauOutils, String nom) {
		super(nom);
		this.panneauDessin = panneauDessin;
		this.panneauDessin.add(panneauOutils);
  }

  public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals(NOM_ACTION_LIGNE)) {
			this.panneauDessin.associerOutil(new OutilLigne());
		} 
		else if (event.getActionCommand().equals(NOM_ACTION_CERCLE)) {
			this.panneauDessin.associerOutil(new OutilCercle());
		} 
		else if (event.getActionCommand().equals(NOM_ACTION_ELLIPSE)) {
			this.panneauDessin.associerOutil(new OutilEllipse());
		}
		else if (event.getActionCommand().equals(NOM_ACTION_RECTANGLE)) {
			this.panneauDessin.associerOutil(new OutilRectangle());
		}
		else if (event.getActionCommand().equals(NOM_ACTION_CARRE)) {
			this.panneauDessin.associerOutil(new OutilCarre());
		}
  }

}
