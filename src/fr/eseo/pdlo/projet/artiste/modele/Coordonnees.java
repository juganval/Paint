
package fr.eseo.pdlo.projet.artiste.modele;

import java.text.DecimalFormat;
public class Coordonnees {
  public static final double ABSCISSE_PAR_DEFAUT =  0.0;

  public static final double ORDONNEE_PAR_DEFAUT =  0.0;

  private double abscisse;

  private double ordonnee;

  public Coordonnees(double abscisse, double ordonnee) {
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
  }

  public Coordonnees() {
		this(ABSCISSE_PAR_DEFAUT, ORDONNEE_PAR_DEFAUT);
  }

  public double getAbscisse() {
		return this.abscisse;
  }

  public double getOrdonnee() {
		return this.ordonnee;
  }

  public void setAbscisse(double abscisse) {
		this.abscisse = abscisse;
  }

  public void setOrdonnee(double ordonnee) {
		this.ordonnee = ordonnee;
  }

  public void deplacerVers(double abs, double ord) {
		this.abscisse = abs;
		this.ordonnee = ord;
  }

  public void deplacerDe(double deltaX, double deltaOrdonnee) {
		this.abscisse += deltaX;
		this.ordonnee += deltaOrdonnee;
  }

  public double distanceVers(Coordonnees coord) {
		return Math.sqrt(Math.pow((this.getAbscisse() - coord.getAbscisse()), 2)
				+ Math.pow((this.getOrdonnee() - coord.getOrdonnee()), 2));
  }

  public double angleVers(Coordonnees coord) {
		return Math.atan2((coord.getOrdonnee() - this.getOrdonnee()), (coord.getAbscisse() - this.getAbscisse()));
  }

  public String toString() {
		DecimalFormat decimale = new DecimalFormat("0.0#");
		return "(" + decimale.format(this.getAbscisse()) + " , " + decimale.format(this.getOrdonnee()) + ")";
  }

}
