
package fr.eseo.pdlo.projet.artiste.vue.formes;

import fr.eseo.pdlo.projet.artiste.modele.formes.Forme;
public abstract class VueForme {
  protected final fr.eseo.pdlo.projet.artiste.modele.formes.Forme forme;

  public VueForme(fr.eseo.pdlo.projet.artiste.modele.formes.Forme forme) {
		this.forme = forme;
  }

  public fr.eseo.pdlo.projet.artiste.modele.formes.Forme getForme() {
		return this.forme;
  }

  public abstract void affiche(java.awt.Graphics2D g2d) ;

}
