
package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.util.Locale;
import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
public class Ligne extends Forme {
  public static final double EPSILON =  0.2;

  public Ligne() {
		super();
  }

  public Ligne(double largeur, double hauteur) {
		super(largeur, hauteur);
  }

  public Ligne(fr.eseo.pdlo.projet.artiste.modele.Coordonnees position) {
		super(position);
  }

  public Ligne(fr.eseo.pdlo.projet.artiste.modele.Coordonnees position, double largeur, double hauteur) {
		super(position, largeur, hauteur);
  }

  public fr.eseo.pdlo.projet.artiste.modele.Coordonnees getC1() {
		return super.getPosition();
  }

  public fr.eseo.pdlo.projet.artiste.modele.Coordonnees getC2() {
		Coordonnees c2 = new Coordonnees(this.getPosition().getAbscisse(), this.getPosition().getOrdonnee());
		c2.deplacerDe(this.getLargeur(), this.getHauteur());
		return c2;
  }

  public java.awt.Color getCouleur() {
		return super.getCouleur();
  }

  public void setCouleur(java.awt.Color couleur) {
		super.setCouleur(couleur);
  }

  /**
   *  Vérifié avec la prof setC1 SetC2 et set position
   */
  public void setC1(fr.eseo.pdlo.projet.artiste.modele.Coordonnees position) {
		this.setLargeur(this.getLargeur() - (position.getAbscisse() - this.getPosition().getAbscisse()));
		this.setHauteur(this.getHauteur() - (position.getOrdonnee() - this.getPosition().getOrdonnee()));
		this.setPosition(position);
  }

  public void setC2(fr.eseo.pdlo.projet.artiste.modele.Coordonnees position) {
		this.setLargeur(position.getAbscisse() - this.getPosition().getAbscisse());
		this.setHauteur(position.getOrdonnee() - this.getPosition().getOrdonnee());
  }

  public double aire() {
		return 0.0;
  }

  public double perimetre() {
		return this.getC1().distanceVers(getC2());
  }

  public String toString() {
		String couleur;
		DecimalFormat decimale = new DecimalFormat("0.0#");
		double angle = this.getPosition().angleVers(this.getC2()) * (180 / Math.PI);
		if (angle < 0.0) {
			angle += 360;
		}
		if (Locale.getDefault().getLanguage().equals("fr")) {
			couleur = " couleur = R" + this.getCouleur().getRed() + ",V" + this.getCouleur().getGreen() + ",B"
					+ this.getCouleur().getBlue();
		} else {
			couleur = " couleur = R" + this.getCouleur().getRed() + ",G" + this.getCouleur().getGreen() + ",B"
					+ this.getCouleur().getBlue();
		}
		return "[Ligne] c1 : (" + decimale.format(this.getPosition().getAbscisse()) + " , "
				+ decimale.format(this.getPosition().getOrdonnee()) + ") c2 : ("
				+ decimale.format(this.getC2().getAbscisse()) + " , " + decimale.format(this.getC2().getOrdonnee())
				+ ") longueur : " + decimale.format(this.perimetre()) + " angle : " + decimale.format(angle) + "°"
				+ couleur;
  }

  public boolean contient(fr.eseo.pdlo.projet.artiste.modele.Coordonnees coord) {
		return this.getC1().distanceVers(coord) + this.getC2().distanceVers(coord)
				- this.getC1().distanceVers(this.getC2()) <= EPSILON;
  }

}
