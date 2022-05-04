
package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.awt.Color;
import fr.eseo.pdlo.projet.artiste.modele.Coloriable;
import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
public abstract class Forme implements fr.eseo.pdlo.projet.artiste.modele.Coloriable {
  private double largeur;

  private double hauteur;

  private fr.eseo.pdlo.projet.artiste.modele.Coordonnees position;

  private Color couleur;

  public static final double LARGEUR_PAR_DEFAUT =  100;

  public static final double HAUTEUR_PAR_DEFAUT =  150;

  public static final fr.eseo.pdlo.projet.artiste.modele.Coordonnees POSITION_PAR_DEFAUT =  new Coordonnees(0, 0);

  public static final Color COULEUR_PAR_DEFAUT =  javax.swing.UIManager.getColor("Panel.foreground");

  public abstract double aire() ;

  public abstract double perimetre() ;

  public abstract boolean contient(fr.eseo.pdlo.projet.artiste.modele.Coordonnees coord) ;

  public Forme() {
		this(new Coordonnees(), LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
  }

  public Forme(double largeur, double hauteur) {
		this(new Coordonnees(), largeur, hauteur);
  }

  public Forme(fr.eseo.pdlo.projet.artiste.modele.Coordonnees position) {
		this(position, LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
  }

  public Forme(fr.eseo.pdlo.projet.artiste.modele.Coordonnees position, double largeur, double hauteur) {
		this.setPosition(position);
		this.setLargeur(largeur);
		this.setHauteur(hauteur);
		this.couleur = COULEUR_PAR_DEFAUT;
  }

  public fr.eseo.pdlo.projet.artiste.modele.Coordonnees getPosition() {
		return this.position;
  }

  public double getLargeur() {
		return this.largeur;
  }

  public double getHauteur() {
		return this.hauteur;
  }

  public java.awt.Color getCouleur() {
		return this.couleur;
  }

  public void setCouleur(java.awt.Color couleur) {
		this.couleur = couleur;
  }

  public void setPosition(fr.eseo.pdlo.projet.artiste.modele.Coordonnees position) {
		this.position = position;
  }

  public void setLargeur(double largeur) {
		this.largeur = largeur;
  }

  public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
  }

  public void deplacerDe(double deltaX, double deltaY) {
		this.position.setAbscisse(deltaX + this.position.getAbscisse());
		this.position.setOrdonnee(deltaY + this.position.getOrdonnee());
  }

  public void deplacerVers(double nouvelleAbscisse, double nouvelleOrdonnee) {
		this.position.setAbscisse(nouvelleAbscisse);
		this.position.setOrdonnee(nouvelleOrdonnee);
  }

  public double getCadreMinX() {
		return Math.min(this.position.getAbscisse(), this.position.getAbscisse() + this.getLargeur());
  }

  public double getCadreMinY() {
		return Math.min(this.position.getOrdonnee(), this.position.getOrdonnee() + this.getHauteur());
  }

  public double getCadreMaxX() {
		return Math.max(this.position.getAbscisse(), this.position.getAbscisse() + this.getLargeur());
  }

  public double getCadreMaxY() {
		return Math.max(this.position.getOrdonnee(), this.position.getOrdonnee() + this.getHauteur());
  }

}
