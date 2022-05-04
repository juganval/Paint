
package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Rectangle;
public class VueRectangle extends VueForme {
  private Color couleurCourante;

  public VueRectangle(fr.eseo.pdlo.projet.artiste.modele.formes.Rectangle rectangle) {
		super(rectangle);
  }

  public void affiche(Graphics2D g2d) {
		this.couleurCourante = g2d.getColor();
		g2d.setColor(this.getForme().getCouleur());
		g2d.setStroke(new BasicStroke());
		g2d.drawRect((int) Math.round(super.getForme().getPosition().getAbscisse()),
				(int) Math.round(super.getForme().getPosition().getOrdonnee()),
				(int) Math.round(super.getForme().getLargeur()), (int) Math.round(super.getForme().getHauteur()));
		if (((Rectangle) super.getForme()).getRemplissage().equals(Remplissage.UNIFORME)) {
			g2d.fillRect((int) Math.round(super.getForme().getPosition().getAbscisse()),
					(int) Math.round(super.getForme().getPosition().getOrdonnee()),
					(int) Math.round(super.getForme().getLargeur()), (int) Math.round(super.getForme().getHauteur()));
		}
		g2d.setColor(couleurCourante);
  }

}
