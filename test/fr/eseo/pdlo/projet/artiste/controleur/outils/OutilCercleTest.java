package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class OutilCercleTest {
	
	private OutilCercleTest() {
		testConstructeurParDefaut();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new OutilCercleTest();
			}
		});
	}

	private void testConstructeurParDefaut() {
		PanneauDessin panneau = new PanneauDessin();
		JFrame frame = new JFrame("Test outil ligne");
		OutilCercle cercle = new OutilCercle();
		panneau.associerOutil(cercle);
		frame.add(panneau, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
