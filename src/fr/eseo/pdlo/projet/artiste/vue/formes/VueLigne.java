
package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ligne;
public class VueLigne extends VueForme {
  private Color couleurCourante;

  public VueLigne(fr.eseo.pdlo.projet.artiste.modele.formes.Ligne ligne) {
		super(ligne);
  }

  public void affiche(Graphics2D g2d) {
		this.couleurCourante = g2d.getColor();
		g2d.setColor(this.getForme().getCouleur());
		super.getForme().setCouleur(this.getForme().getCouleur());
		g2d.setStroke(new BasicStroke((float) 1.0));
		g2d.drawLine((int) Math.round(super.getForme().getPosition().getAbscisse()),
				(int) Math.round(super.getForme().getPosition().getOrdonnee()),
				(int) Math.round(super.getForme().getPosition().getAbscisse() + super.getForme().getLargeur()),
				(int) Math.round(super.getForme().getPosition().getOrdonnee() + super.getForme().getHauteur()));
		g2d.setColor(couleurCourante);
  }

}
