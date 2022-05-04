
package fr.eseo.pdlo.projet.artiste.controleur.outils;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Rectangle;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueRectangle;
public class OutilRectangle extends OutilForme {
  fr.eseo.pdlo.projet.artiste.modele.formes.Rectangle rectangle;

  protected fr.eseo.pdlo.projet.artiste.vue.formes.VueForme creerVueForme() {
		if (this.getDebut().getAbscisse() == this.getFin().getAbscisse()
				&& this.getDebut().getOrdonnee() == this.getFin().getOrdonnee()) {
			rectangle = new Rectangle(this.getDebut());
		} else {
			double maxX = Math.abs(this.getDebut().getAbscisse() - this.getFin().getAbscisse());
			double maxY = Math.abs(this.getDebut().getOrdonnee() - this.getFin().getOrdonnee());
			if (this.getDebut().getAbscisse() > this.getFin().getAbscisse()
					&& this.getDebut().getOrdonnee() > this.getFin().getOrdonnee()) {
				rectangle = new Rectangle(this.getFin(), maxX, maxY);
			} else if (this.getDebut().getOrdonnee() > this.getFin().getOrdonnee()) {
				rectangle = new Rectangle(
						new Coordonnees(this.getDebut().getAbscisse(), this.getDebut().getOrdonnee() - maxY), maxX,
						maxY);
			} else if (this.getDebut().getAbscisse() > this.getFin().getAbscisse()) {
				rectangle = new Rectangle(
						new Coordonnees(this.getDebut().getAbscisse() - maxX, this.getDebut().getOrdonnee()),
						maxX, maxY);
			} else {
				rectangle = new Rectangle(this.getDebut(), maxX, maxY);
			}

		}
		rectangle.setCouleur(this.getPanneauDessin().getCouleurCourante());
		rectangle.setRemplissage(this.getPanneauDessin().getModeRemplissageCourant());
		VueRectangle vueRectangle = new VueRectangle(rectangle);
		return vueRectangle;
  }

}
