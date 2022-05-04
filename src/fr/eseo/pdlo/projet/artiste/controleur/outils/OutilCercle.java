
package fr.eseo.pdlo.projet.artiste.controleur.outils;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Cercle;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueCercle;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;
public class OutilCercle extends OutilForme {
  fr.eseo.pdlo.projet.artiste.modele.formes.Cercle cercle;

  protected fr.eseo.pdlo.projet.artiste.vue.formes.VueForme creerVueForme() {
		if (this.getDebut().getAbscisse() == this.getFin().getAbscisse()
				&& this.getDebut().getOrdonnee() == this.getFin().getOrdonnee()) {
			cercle = new Cercle(this.getDebut());
		} else {
			double diametreMax = Math.max(Math.abs(super.getFin().getAbscisse() - super.getDebut().getAbscisse()),
					Math.abs(super.getFin().getOrdonnee() - super.getDebut().getOrdonnee()));
			Coordonnees position = new Coordonnees(super.getDebut().getAbscisse(), super.getDebut().getOrdonnee());

			if (super.getDebut().getAbscisse() > super.getFin().getAbscisse()) {
				position.setAbscisse(super.getDebut().getAbscisse() - diametreMax);
			}

			if (super.getDebut().getOrdonnee() > super.getFin().getOrdonnee()) {
				position.setOrdonnee(super.getDebut().getOrdonnee() - diametreMax);
			}

			cercle = new Cercle(position, diametreMax);
			cercle.setCouleur(super.getPanneauDessin().getCouleurCourante());
			cercle.setRemplissage(super.getPanneauDessin().getModeRemplissageCourant());
			return new VueCercle(cercle);
		}
		cercle.setCouleur(this.getPanneauDessin().getCouleurCourante());
		cercle.setRemplissage(this.getPanneauDessin().getModeRemplissageCourant());
		VueCercle vueCercle = new VueCercle(cercle);
		return vueCercle;
  }

  public void mouseClicked(java.awt.event.MouseEvent event) {
		super.mouseClicked(event);
  }

}
