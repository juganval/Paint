
package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.util.Locale;
import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
public class Rectangle extends Forme {
  private fr.eseo.pdlo.projet.artiste.modele.Remplissage remplissage;

  public Rectangle() {
		super();
		this.remplissage = Remplissage.AUCUNE;
  }

  public Rectangle(double largeur, double hauteur) {
		super(largeur, hauteur);
		this.remplissage = Remplissage.AUCUNE;
  }

  public Rectangle(fr.eseo.pdlo.projet.artiste.modele.Coordonnees position) {
		super(position);
		this.remplissage = Remplissage.AUCUNE;
  }

  public Rectangle(fr.eseo.pdlo.projet.artiste.modele.Coordonnees position, double largeur, double hauteur) {
		super(position, largeur, hauteur);
		this.remplissage = Remplissage.AUCUNE;
  }

  public void setLargeur(double largeur) {
		if (largeur < 0) {
			throw new IllegalArgumentException("Largeur négative");
		} else {
			super.setLargeur(largeur);
		}
  }

  public void setHauteur(double hauteur) {
		if (hauteur < 0) {
			throw new IllegalArgumentException("Largeur négative");
		} else {
			super.setHauteur(hauteur);
		}
  }

  public void setCouleur(java.awt.Color couleur) {
		super.setCouleur(couleur);
  }

  public fr.eseo.pdlo.projet.artiste.modele.Remplissage getRemplissage() {
		return remplissage;
  }

  public void setRemplissage(fr.eseo.pdlo.projet.artiste.modele.Remplissage modeRemplissage) {
		this.remplissage = modeRemplissage;
  }

  public java.awt.Color getCouleur() {
		return super.getCouleur();
  }

  public double aire() {
		return Math.abs(this.getHauteur() * this.getLargeur());
  }

  public double perimetre() {
		return (this.getHauteur() * 2 + this.getLargeur() * 2);
  }

  public String toString() {
		String couleur;
		String str;
		DecimalFormat decimale = new DecimalFormat("0.0#");
		if (Locale.getDefault().getLanguage().equals("fr")) {
			couleur = " couleur = R" + this.getCouleur().getRed() + ",V" + this.getCouleur().getGreen() + ",B"
					+ this.getCouleur().getBlue();
		} else {
			couleur = " couleur = R" + this.getCouleur().getRed() + ",G" + this.getCouleur().getGreen() + ",B"
					+ this.getCouleur().getBlue();
		}
		str = "[Rectangle " + this.getRemplissage().getMode() + "] : pos ("
				+ decimale.format(this.getPosition().getAbscisse()) + " , "
				+ decimale.format(this.getPosition().getOrdonnee()) + ") largeur " + decimale.format(this.getHauteur())
				+ " hauteur " + decimale.format(this.getLargeur()) + " périmètre : " + decimale.format(this.perimetre())
				+ " aire : " + decimale.format(this.aire()) + couleur;
		return str;
  }

  /**
   *  (x-cx)²/a²+(y-cy)²/b² <= 1
   */
  public boolean contient(fr.eseo.pdlo.projet.artiste.modele.Coordonnees coord) {
		
		double coordX = Math.pow(coord.getAbscisse() - (this.getPosition().getAbscisse() + (this.getLargeur() / 2)), 2)
				/ Math.pow(this.getLargeur() / 2, 2);
		double coordY = Math.pow(coord.getOrdonnee() - (this.getPosition().getOrdonnee() + (this.getHauteur() / 2)), 2)
				/ Math.pow(this.getHauteur() / 2, 2);
		return (coordX + coordY) <= 1;
  }

}
