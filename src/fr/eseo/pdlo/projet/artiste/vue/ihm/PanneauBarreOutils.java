
package fr.eseo.pdlo.projet.artiste.vue.ihm;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChangerCouleur;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirCouleur;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirCrenelage;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirForme;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirModeRemplissage;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionEffacer;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
public class PanneauBarreOutils extends javax.swing.JPanel {
  private static final long serialVersionUID =  1L;

  private PanneauDessin panneauDessin;

  public PanneauBarreOutils(PanneauDessin panneauDessin) {
		this.panneauDessin = panneauDessin;
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		initComponents();
		initComponents2();
  }

  private void initComponents() {
		ButtonGroup buttonGroupRemplissage = new ButtonGroup();
		JToggleButton boutonCrenelage = new JToggleButton(new ActionChoisirCrenelage(this.panneauDessin));
		JToggleButton boutonAucune = new JToggleButton(
				new ActionChoisirModeRemplissage(this.panneauDessin, Remplissage.AUCUNE));
		JToggleButton boutonUniforme = new JToggleButton(
				new ActionChoisirModeRemplissage(this.panneauDessin, Remplissage.UNIFORME));
		JButton bouttonEffacer = new JButton(new ActionEffacer(panneauDessin));
		JButton bouttonChoisirCouleur = new JButton(new ActionChoisirCouleur(panneauDessin));
		JButton bouttonModifierCouleur = new JButton(new ActionChangerCouleur(panneauDessin)); 
		buttonGroupRemplissage.add(boutonUniforme);
		buttonGroupRemplissage.add(boutonAucune);
		this.add(bouttonEffacer);
		this.add(boutonAucune);
		this.add(boutonUniforme);
		this.add(boutonCrenelage);
		this.add(bouttonChoisirCouleur);
		this.add(bouttonModifierCouleur);
		boutonCrenelage.setName(ActionChoisirCrenelage.NOM_ACTION);
		boutonUniforme.setName(Remplissage.UNIFORME.getMode());
		boutonAucune.setName(Remplissage.AUCUNE.getMode());
		bouttonChoisirCouleur.setName(ActionChoisirCouleur.NOM_ACTION);
		bouttonEffacer.setText(ActionEffacer.NOM_ACTION);
		bouttonModifierCouleur.setName(ActionChangerCouleur.NOM_ACTION);
		boutonAucune.setSelected(true);
		boutonUniforme.setMaximumSize(new Dimension(Integer.MAX_VALUE, boutonUniforme.getMinimumSize().height));
		boutonAucune.setMaximumSize(new Dimension(Integer.MAX_VALUE, boutonAucune.getMinimumSize().height));
		bouttonChoisirCouleur
				.setMaximumSize(new Dimension(Integer.MAX_VALUE, bouttonChoisirCouleur.getMinimumSize().height));
		bouttonEffacer.setMaximumSize(new Dimension(Integer.MAX_VALUE, bouttonEffacer.getMinimumSize().height));
		boutonCrenelage.setMaximumSize(new Dimension(Integer.MAX_VALUE, boutonCrenelage.getMinimumSize().height));
		bouttonModifierCouleur.setMaximumSize(new Dimension(Integer.MAX_VALUE, boutonUniforme.getMinimumSize().height));

  }

  public void initComponents2() {
		ButtonGroup buttonGroup = new ButtonGroup();
		JToggleButton boutonSelection = new JToggleButton(new ActionSelectionner(panneauDessin));
		JToggleButton boutonCercle = new JToggleButton(new ActionChoisirForme(panneauDessin, this, "Cercle"));
		JToggleButton boutonRectangle = new JToggleButton(new ActionChoisirForme(panneauDessin, this, "Rectangle"));
		JToggleButton boutonCarre = new JToggleButton(new ActionChoisirForme(panneauDessin, this, "Carre"));
		JToggleButton boutonEllipse = new JToggleButton(new ActionChoisirForme(panneauDessin, this, "Ellipse"));
		JToggleButton boutonLigne = new JToggleButton(new ActionChoisirForme(panneauDessin, this, "Ligne"));
		buttonGroup.add(boutonSelection);
		buttonGroup.add(boutonLigne);
		buttonGroup.add(boutonCercle);
		buttonGroup.add(boutonRectangle);
		buttonGroup.add(boutonCarre);
		buttonGroup.add(boutonEllipse);
		this.add(boutonRectangle);
		this.add(boutonCarre);
		this.add(boutonLigne);
		this.add(boutonEllipse);
		this.add(boutonCercle);
		this.add(boutonSelection);
		boutonSelection.setName(ActionSelectionner.NOM_ACTION);
		boutonLigne.setName(ActionChoisirForme.NOM_ACTION_LIGNE);
		boutonEllipse.setName(ActionChoisirForme.NOM_ACTION_ELLIPSE);
		boutonCercle.setName(ActionChoisirForme.NOM_ACTION_CERCLE);
		boutonCarre.setName(ActionChoisirForme.NOM_ACTION_CARRE);
		boutonRectangle.setName(ActionChoisirForme.NOM_ACTION_RECTANGLE);
		boutonCarre.setMaximumSize(new Dimension(Integer.MAX_VALUE, boutonCarre.getMinimumSize().height));
		boutonRectangle.setMaximumSize(new Dimension(Integer.MAX_VALUE, boutonRectangle.getMinimumSize().height));
		boutonSelection.setMaximumSize(new Dimension(Integer.MAX_VALUE, boutonSelection.getMinimumSize().height));
		boutonLigne.setMaximumSize(new Dimension(Integer.MAX_VALUE, boutonLigne.getMinimumSize().height));
		boutonEllipse.setMaximumSize(new Dimension(Integer.MAX_VALUE, boutonEllipse.getMinimumSize().height));
		boutonCercle.setMaximumSize(new Dimension(Integer.MAX_VALUE, boutonCercle.getMinimumSize().height));
  }

}
