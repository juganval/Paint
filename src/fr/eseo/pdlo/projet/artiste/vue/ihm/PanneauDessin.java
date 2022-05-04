
package fr.eseo.pdlo.projet.artiste.vue.ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import fr.eseo.pdlo.projet.artiste.controleur.outils.Outil;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Forme;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;
public class PanneauDessin extends javax.swing.JPanel {
  private static final long serialVersionUID =  1L;

  public static final int LARGEUR_PAR_DEFAUT =  640;

  public static final int HAUTEUR_PAR_DEFAUT =  480;

  public static final java.awt.Color COULEUR_FOND_PAR_DEFAUT =  Color.WHITE;

  private final List<fr.eseo.pdlo.projet.artiste.vue.formes.VueForme> vueFormes;

  private fr.eseo.pdlo.projet.artiste.controleur.outils.Outil outilCourant;

  private Color couleurCourante;

  private String modeRemplissage;

  private Object modeCrenelage;

  private int indice;

  public PanneauDessin() {
		super();
		Dimension dimension = new Dimension(LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
		setPreferredSize(dimension);
		setBackground(COULEUR_FOND_PAR_DEFAUT);
		this.vueFormes = new ArrayList<VueForme>();
		this.setCouleurCourante(Forme.COULEUR_PAR_DEFAUT);
		this.modeRemplissage = Remplissage.AUCUNE.getMode();
		this.modeCrenelage = RenderingHints.VALUE_ANTIALIAS_OFF;
  }

  public PanneauDessin(int largeur, int hauteur, java.awt.Color fond) {
		super();
		Dimension dimension = new Dimension(largeur, hauteur);
		super.setPreferredSize(dimension);
		super.setBackground(fond);
		this.vueFormes = new ArrayList<VueForme>();
		this.setCouleurCourante(Forme.COULEUR_PAR_DEFAUT);
		this.modeRemplissage = Remplissage.AUCUNE.getMode();
		this.modeCrenelage = RenderingHints.VALUE_ANTIALIAS_OFF;
  }

  public java.util.List<fr.eseo.pdlo.projet.artiste.vue.formes.VueForme> getVueFormes() {
		return this.vueFormes;
  }

  public fr.eseo.pdlo.projet.artiste.controleur.outils.Outil getOutilCourant() {
		return outilCourant;
  }

  public Color getCouleurCourante() {
		return this.couleurCourante;
  }

  public fr.eseo.pdlo.projet.artiste.modele.Remplissage getModeRemplissageCourant() {
		if (this.modeRemplissage.equals("aucune")) {
			return Remplissage.AUCUNE;
		} else {
			return Remplissage.UNIFORME;
		}
  }

  public int getIndice() {
		return this.indice;
  }

  public void setIndice(int ind) {
		this.indice = ind;
  }

  public Object getModeCrenelageCourant() {
		return this.modeCrenelage;
  }

  public void setModeCrenelageCourant(Object mode) {
		this.modeCrenelage = mode;
  }

  public void setModeRemplissageCourant(fr.eseo.pdlo.projet.artiste.modele.Remplissage mode) {
		this.modeRemplissage = mode.getMode();
  }

  public void setCouleurCourante(Color couleur) {
		this.couleurCourante = couleur;
  }

  public void setOutilCourant(fr.eseo.pdlo.projet.artiste.controleur.outils.Outil outil) {
		this.outilCourant = outil;
  }

  public void ajouterVueForme(fr.eseo.pdlo.projet.artiste.vue.formes.VueForme forme) {
		this.vueFormes.add(forme);
		this.repaint();
  }

  public void retirerVueForme(fr.eseo.pdlo.projet.artiste.vue.formes.VueForme forme) {
		this.vueFormes.remove(forme);
		this.repaint();
  }

  protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g.create();
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, this.getModeCrenelageCourant());
		if (!this.vueFormes.isEmpty()) {
			for (int i = 0; i < vueFormes.size(); i++) {
				this.getVueFormes().get(i).affiche(g2D);
			}
		}
		g2D.dispose();
  }

  public void associerOutil(fr.eseo.pdlo.projet.artiste.controleur.outils.Outil outil) {
		if (outil != null) {
			if (outilCourant != null) {
				dissocierOutil(outil);
			}
			this.setOutilCourant(outil);
			this.outilCourant.setPanneauDessin(this);
			this.addMouseListener(outilCourant);
			this.addMouseMotionListener(outilCourant);
		}
  }

  public void dissocierOutil(fr.eseo.pdlo.projet.artiste.controleur.outils.Outil outil) {
		this.outilCourant.setPanneauDessin(null);
		this.removeMouseListener(outilCourant);
		this.removeMouseMotionListener(outilCourant);
		this.setOutilCourant(null);
  }

}
