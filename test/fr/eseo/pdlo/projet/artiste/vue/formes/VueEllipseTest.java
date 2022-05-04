package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class VueEllipseTest {
	private VueEllipseTest() {
		testTraceEllipse();
		testCouleurCercle();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VueEllipseTest();
			}
		});
	}

	private void testTraceEllipse() {
		Ellipse ellipse = new Ellipse(new Coordonnees(20, 20), 50, 80);
		VueEllipse vueligne = new VueEllipse(ellipse);

		PanneauDessin panneau = new PanneauDessin(1000, 600, Color.white);
		panneau.ajouterVueForme(vueligne);
		JFrame frame = new JFrame("Etre");
		frame.add(panneau, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private void testCouleurCercle() {
		Ellipse ellipse = new Ellipse(new Coordonnees(300, 300), 50, 80);
		ellipse.setCouleur(Color.green);
		VueEllipse vueEllipse = new VueEllipse(ellipse);
		ellipse.setRemplissage(Remplissage.UNIFORME);
		Ellipse ellipse1 = new Ellipse(new Coordonnees(500, 300), 50, 80);
		ellipse1.setCouleur(Color.red);
		VueEllipse vueEllipse1 = new VueEllipse(ellipse1);
		PanneauDessin panneau = new PanneauDessin(1000, 600, Color.white);
		panneau.ajouterVueForme(vueEllipse);
		panneau.ajouterVueForme(vueEllipse1);
		JFrame frame = new JFrame("Etre");
		frame.add(panneau, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}
}
