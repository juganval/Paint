
package fr.eseo.pdlo.projet.artiste.controleur.outils;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Carre;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueCarre;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;
public class OutilCarre extends OutilForme {
  fr.eseo.pdlo.projet.artiste.modele.formes.Carre carre;

  protected fr.eseo.pdlo.projet.artiste.vue.formes.VueForme creerVueForme() {
		if (this.getDebut().getAbscisse() == this.getFin().getAbscisse()
				&& this.getDebut().getOrdonnee() == this.getFin().getOrdonnee()) {
			carre = new Carre(this.getDebut());
		} else {
			double diametreMax = Math.max(Math.abs(super.getFin().getAbscisse() - super.getDebut().getAbscisse()),
					Math.abs(super.getFin().getOrdonnee() - super.getDebut().getOrdonnee()));
			Coordonnees coordonneeCarre = new Coordonnees(super.getDebut().getAbscisse(),
					super.getDebut().getOrdonnee());

			if (super.getDebut().getAbscisse() > super.getFin().getAbscisse()) {
				coordonneeCarre.setAbscisse(super.getDebut().getAbscisse() - diametreMax);
			}

			if (super.getDebut().getOrdonnee() > super.getFin().getOrdonnee()) {
				coordonneeCarre.setOrdonnee(super.getDebut().getOrdonnee() - diametreMax);
			}
			carre = new Carre(coordonneeCarre, diametreMax);
		}
		carre.setCouleur(super.getPanneauDessin().getCouleurCourante());
		carre.setRemplissage(super.getPanneauDessin().getModeRemplissageCourant());
		return new VueCarre(carre);
  }

  public void mouseClicked(java.awt.event.MouseEvent event) {
		super.mouseClicked(event);
  }

}
