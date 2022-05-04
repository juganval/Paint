package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Cercle;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class VueCercleTest {
	private VueCercleTest() {
		testTraceCercle();
		testCouleurCercle();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VueCercleTest();
			}
		});
	}
	
	
	private void testTraceCercle() {
		Cercle cercle = new Cercle(new Coordonnees(100,100),100);
		VueCercle vueligne = new VueCercle(cercle);
		
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
		Cercle cercle = new Cercle(new Coordonnees(300,300),100);
		cercle.setCouleur(Color.red);
		Cercle cercle1 = new Cercle(new Coordonnees(500,300),100);
		cercle1.setCouleur(Color.green);
		cercle.setRemplissage(Remplissage.UNIFORME);
		VueCercle vueCercle = new VueCercle(cercle);
		VueCercle vueCercle1 = new VueCercle(cercle1);
		PanneauDessin panneau = new PanneauDessin(1000, 600, Color.white);
		panneau.ajouterVueForme(vueCercle); 
		panneau.ajouterVueForme(vueCercle1);
		JFrame frame = new JFrame("Etre");
		frame.add(panneau, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
