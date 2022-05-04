
package fr.eseo.pdlo.projet.artiste;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreEtat;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;
public class EtreUnArtiste {
  public EtreUnArtiste(String nom, double largeur, double hauteur) {
		application(nom, largeur, hauteur);
  }

  public static void main(String[] args)
  {
		SwingUtilities.invokeLater(new Runnable() {
			String nom;
			double largeur;
			double hauteur;

			@Override
			public void run() {
				try {
					nom = args[0];
				} catch (Exception test) {
					nom = "Etre un Artiste";
				}
				try {
					largeur = Integer.parseInt(args[1]);
				} catch (Exception test) {
					largeur = PanneauDessin.LARGEUR_PAR_DEFAUT;
				}
				try {
					hauteur = Integer.parseInt(args[2]);
				} catch (Exception tes) {
					hauteur = PanneauDessin.HAUTEUR_PAR_DEFAUT;
				}
				new EtreUnArtiste(nom, largeur, hauteur);
			}
		});
  }

  public void application(String nom, double largeur, double hauteur) {
		PanneauDessin panneau = new PanneauDessin((int) largeur, (int) hauteur, PanneauDessin.COULEUR_FOND_PAR_DEFAUT);
		JFrame frame = new JFrame(nom);
		PanneauBarreEtat panneauBarreEtat = new PanneauBarreEtat(panneau);
		frame.add(panneauBarreEtat, BorderLayout.SOUTH);
		PanneauBarreOutils panneauBarreOutil = new PanneauBarreOutils(panneau);
		frame.add(panneauBarreOutil, BorderLayout.EAST);
		frame.add(panneau, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
  }

}
