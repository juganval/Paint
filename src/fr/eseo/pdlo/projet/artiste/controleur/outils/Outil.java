
package fr.eseo.pdlo.projet.artiste.controleur.outils;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;
public abstract class Outil extends javax.swing.event.MouseInputListener {
  private fr.eseo.pdlo.projet.artiste.modele.Coordonnees debut;

  private fr.eseo.pdlo.projet.artiste.modele.Coordonnees fin;

  private fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin panneauDessin;

  public fr.eseo.pdlo.projet.artiste.modele.Coordonnees getDebut() {
		return this.debut;
  }

  public fr.eseo.pdlo.projet.artiste.modele.Coordonnees getFin() {
		return this.fin;
  }

  public fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin getPanneauDessin() {
		return this.panneauDessin;
  }

  public void setPanneauDessin(fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin panneauDessin) {
		this.panneauDessin = panneauDessin;
  }

  public void setDebut(fr.eseo.pdlo.projet.artiste.modele.Coordonnees coord) {
		this.debut = coord;
  }

  public void setFin(fr.eseo.pdlo.projet.artiste.modele.Coordonnees coord) {
		this.fin = coord;
  }

  public void mouseClicked(java.awt.event.MouseEvent event) {

  }

  public void mouseDragged(java.awt.event.MouseEvent event) {
		this.setFin(new Coordonnees(event.getX(), event.getY()));
  }

  public void mouseEntered(java.awt.event.MouseEvent event) {

  }

  public void mouseExited(java.awt.event.MouseEvent event) {

  }

  public void mouseMoved(java.awt.event.MouseEvent event) {

  }

  public void mousePressed(java.awt.event.MouseEvent event) {
		this.setDebut(new Coordonnees(event.getX(), event.getY()));
  }

  public void mouseReleased(java.awt.event.MouseEvent event) {
		this.setFin(new Coordonnees(event.getX(), event.getY()));
  }

}
