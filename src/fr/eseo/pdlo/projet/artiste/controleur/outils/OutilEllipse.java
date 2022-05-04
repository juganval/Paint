
package fr.eseo.pdlo.projet.artiste.controleur.outils;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueEllipse;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;
public class OutilEllipse extends OutilForme {
  fr.eseo.pdlo.projet.artiste.modele.formes.Ellipse ellipse;

  protected fr.eseo.pdlo.projet.artiste.vue.formes.VueForme creerVueForme() {
		if (this.getDebut().getAbscisse() == this.getFin().getAbscisse()
				&& this.getDebut().getOrdonnee() == this.getFin().getOrdonnee()) {
			ellipse = new Ellipse(this.getDebut());
		} else {
			double maxX = Math.abs(this.getDebut().getAbscisse() - this.getFin().getAbscisse());
			double maxY = Math.abs(this.getDebut().getOrdonnee() - this.getFin().getOrdonnee());
			if (this.getDebut().getAbscisse() > this.getFin().getAbscisse()
					&& this.getDebut().getOrdonnee() > this.getFin().getOrdonnee()) {
				ellipse = new Ellipse(this.getFin(), maxX, maxY);
			} else if (this.getDebut().getOrdonnee() > this.getFin().getOrdonnee()) {
				ellipse = new Ellipse(
						new Coordonnees(this.getDebut().getAbscisse(), this.getDebut().getOrdonnee() - maxY), maxX,
						maxY);
			} else if (this.getDebut().getAbscisse() > this.getFin().getAbscisse()) {
				ellipse = new Ellipse(
						new Coordonnees(this.getDebut().getAbscisse() - maxX, this.getDebut().getOrdonnee()),
						maxX, maxY);
			} else {
				ellipse = new Ellipse(this.getDebut(), maxX, maxY);
			}

		}
		ellipse.setCouleur(this.getPanneauDessin().getCouleurCourante());
		ellipse.setRemplissage(this.getPanneauDessin().getModeRemplissageCourant());
		VueEllipse vueEllipse = new VueEllipse(ellipse);
		return vueEllipse;
  }

}
