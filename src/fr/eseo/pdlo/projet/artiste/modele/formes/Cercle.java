
package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.util.Locale;
import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
public class Cercle extends Ellipse {
  public Cercle() {
		super(Ellipse.POSITION_PAR_DEFAUT, Ellipse.LARGEUR_PAR_DEFAUT, Ellipse.LARGEUR_PAR_DEFAUT);
  }

  public Cercle(double largeur) {
		super(Ellipse.POSITION_PAR_DEFAUT, largeur, largeur);
  }

  public Cercle(fr.eseo.pdlo.projet.artiste.modele.Coordonnees position) {
		super(position, Ellipse.LARGEUR_PAR_DEFAUT, Ellipse.LARGEUR_PAR_DEFAUT);
  }

  public Cercle(fr.eseo.pdlo.projet.artiste.modele.Coordonnees position, double largeur) {
		super(position, largeur, largeur);
  }

  public void setLargeur(double largeur) {
		super.setLargeur(largeur);
		super.setHauteur(largeur);
  }

  public void setHauteur(double hauteur) {
		super.setHauteur(hauteur);
		super.setLargeur(hauteur);
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

  public double getLargeur() {
		return super.getLargeur();
  }

  public double getHauteur() {
		return super.getHauteur();
  }

  public double perimetre() {
		return Math.PI * this.getLargeur();
  }

  public double aire() {
		return super.aire();
  }

  public String toString() {
		String couleur;
		DecimalFormat decimale = new DecimalFormat("0.0#");
		if (Locale.getDefault().getLanguage().equals("fr")) {
			couleur = " couleur = R" + this.getCouleur().getRed() + ",V" + this.getCouleur().getGreen() + ",B"
					+ this.getCouleur().getBlue();
		} else {
			couleur = " couleur = R" + this.getCouleur().getRed() + ",G" + this.getCouleur().getGreen() + ",B"
					+ this.getCouleur().getBlue();
		}
		return "[Cercle " + this.getRemplissage().getMode() + "] : pos (" + decimale.format(this.getPosition().getAbscisse())
				+ " , " + decimale.format(this.getPosition().getOrdonnee()) + ") rayon "
				+ decimale.format(this.getHauteur() / 2) + " périmètre : " + decimale.format(this.perimetre())
				+ " aire : " + decimale.format(this.aire()) + couleur;
  }

  public boolean contient(fr.eseo.pdlo.projet.artiste.modele.Coordonnees coord) {
		return super.contient(coord);
  }

}
