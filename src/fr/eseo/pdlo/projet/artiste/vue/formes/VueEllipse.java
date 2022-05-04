
package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ellipse;
public class VueEllipse extends VueForme {
  private Color couleurCourante;

  public VueEllipse(fr.eseo.pdlo.projet.artiste.modele.formes.Ellipse ellipse) {
		super(ellipse);
  }

  public void affiche(Graphics2D g2d) {
		this.couleurCourante = g2d.getColor();
		g2d.setColor(this.getForme().getCouleur());
		g2d.setStroke(new BasicStroke());
		g2d.drawOval((int) Math.round(super.getForme().getPosition().getAbscisse()),
				(int) Math.round(super.getForme().getPosition().getOrdonnee()),
				(int) Math.round(super.getForme().getLargeur()), (int) Math.round(super.getForme().getHauteur()));
		if (((Ellipse) super.getForme()).getRemplissage().equals(Remplissage.UNIFORME)) {
			g2d.fillOval((int) Math.round(super.getForme().getPosition().getAbscisse()),
					(int) Math.round(super.getForme().getPosition().getOrdonnee()),
					(int) Math.round(super.getForme().getLargeur()), (int) Math.round(super.getForme().getHauteur()));
		}
		g2d.setColor(couleurCourante);

  }

}
