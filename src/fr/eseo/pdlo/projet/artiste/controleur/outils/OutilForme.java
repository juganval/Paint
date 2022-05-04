
package fr.eseo.pdlo.projet.artiste.controleur.outils;

import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;
public abstract class OutilForme extends Outil {
  private boolean bool = false;

  public void mousePressed(java.awt.event.MouseEvent event) {
		super.mousePressed(event);
  }

  public void mouseClicked(java.awt.event.MouseEvent event) {
		if (event.getClickCount() == 2) {
			this.getPanneauDessin().ajouterVueForme(this.creerVueForme());
			// this.getPanneauDessin().repaint();
		}
  }

  public void mouseReleased(java.awt.event.MouseEvent event) {
		super.mouseReleased(event);
		if (event.getX() != this.getDebut().getAbscisse() || event.getY() != this.getDebut().getOrdonnee()) {
			this.getPanneauDessin().retirerVueForme(
					this.getPanneauDessin().getVueFormes().get(this.getPanneauDessin().getVueFormes().size() - 1));
			this.getPanneauDessin().ajouterVueForme(this.creerVueForme());
			// this.getPanneauDessin().repaint();
			bool = false;
		}
  }

  public void mouseDragged(java.awt.event.MouseEvent event) {
		super.mouseDragged(event);
		if (event.getX() != this.getDebut().getAbscisse() || event.getY() != this.getDebut().getOrdonnee()) {
			if(bool) {
				this.getPanneauDessin().retirerVueForme(
						this.getPanneauDessin().getVueFormes().get(this.getPanneauDessin().getVueFormes().size() - 1));
			}
			this.getPanneauDessin().ajouterVueForme(this.creerVueForme());
			bool = true;
			// this.getPanneauDessin().repaint();
		}

  }

  protected abstract fr.eseo.pdlo.projet.artiste.vue.formes.VueForme creerVueForme() ;

}
