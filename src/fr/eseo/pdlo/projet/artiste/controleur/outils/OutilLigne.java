
package fr.eseo.pdlo.projet.artiste.controleur.outils;

import fr.eseo.pdlo.projet.artiste.modele.formes.Ligne;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueLigne;
public class OutilLigne extends OutilForme {
  protected fr.eseo.pdlo.projet.artiste.vue.formes.VueForme creerVueForme() {
		Ligne ligne;
		if (this.getDebut().getAbscisse() == this.getFin().getAbscisse()
				&& this.getDebut().getOrdonnee() == this.getFin().getOrdonnee()) {
			ligne = new Ligne(this.getDebut());	
		} else { 
			ligne = new Ligne(this.getDebut());
			ligne.setC2(this.getFin());
		}
		ligne.setCouleur(this.getPanneauDessin().getCouleurCourante());
		VueLigne vueLigne = new VueLigne(ligne);
		return vueLigne;
  }

}
