
package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.util.Locale;
import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
public class Carre extends Rectangle {
  public Carre() {
		super(Rectangle.POSITION_PAR_DEFAUT, Rectangle.LARGEUR_PAR_DEFAUT,Rectangle.LARGEUR_PAR_DEFAUT);
  }

  public Carre(double largeur) {
		super(Rectangle.POSITION_PAR_DEFAUT,largeur, largeur);
  }

  public Carre(fr.eseo.pdlo.projet.artiste.modele.Coordonnees position) {
		super(position, Rectangle.LARGEUR_PAR_DEFAUT, Rectangle.LARGEUR_PAR_DEFAUT);
  }

  public Carre(fr.eseo.pdlo.projet.artiste.modele.Coordonnees position, double largeur) {
		super(position, largeur, largeur);
  }

  public void setLargeur(double largeur) {
		if (largeur < 0) {
			throw new IllegalArgumentException("Largeur négative");
		} else {
			super.setLargeur(largeur);
			super.setHauteur(largeur);
		}
  }

  public void setHauteur(double hauteur) {
		if (hauteur < 0) {
			throw new IllegalArgumentException("Largeur négative");
		} else {
			super.setHauteur(hauteur);
			super.setLargeur(hauteur);
		}
  }

  public void setCouleur(java.awt.Color couleur) {
		super.setCouleur(couleur);
  }

  public fr.eseo.pdlo.projet.artiste.modele.Remplissage getRemplissage() {
		return super.getRemplissage();
  }

  public void setRemplissage(fr.eseo.pdlo.projet.artiste.modele.Remplissage modeRemplissage) {
		super.setRemplissage(modeRemplissage);
  }

  public java.awt.Color getCouleur() {
		return super.getCouleur();
  }

  public double aire() {
		return super.aire();
  }

  public double perimetre() {
		return super.perimetre();
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
		str = "[Carre " + this.getRemplissage().getMode() + "] : pos ("
				+ decimale.format(this.getPosition().getAbscisse()) + " , "
				+ decimale.format(this.getPosition().getOrdonnee()) + ") largeur " + decimale.format(this.getHauteur())
				+ " hauteur " + decimale.format(this.getLargeur()) + " périmètre : " + decimale.format(this.perimetre())
				+ " aire : " + decimale.format(this.aire()) + couleur;
		return str;
  }

  public boolean contient(fr.eseo.pdlo.projet.artiste.modele.Coordonnees coord) {
		double coordX = Math.pow(coord.getAbscisse() - (this.getPosition().getAbscisse() + (this.getLargeur() / 2)), 2)
				/ Math.pow(this.getLargeur() / 2, 2);
		double coordY = Math.pow(coord.getOrdonnee() - (this.getPosition().getOrdonnee() + (this.getHauteur() / 2)), 2)
				/ Math.pow(this.getHauteur() / 2, 2);
		return (coordX + coordY) <= 1;
  }

}
