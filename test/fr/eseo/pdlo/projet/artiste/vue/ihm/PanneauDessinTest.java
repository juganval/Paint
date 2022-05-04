package fr.eseo.pdlo.projet.artiste.vue.ihm;


import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PanneauDessinTest {

	private PanneauDessinTest() {
		testConstructeurParDefaut();
		testConstructeur();

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new PanneauDessinTest();
			}
		});
	}

	private void testConstructeurParDefaut() {
		PanneauDessin panneau = new PanneauDessin();
		JFrame frame = new JFrame("Etre un Artiste");
		frame.add(panneau, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private void testConstructeur() {
		PanneauDessin panneau = new PanneauDessin(500, 400, Color.BLACK);
		JFrame frame = new JFrame("Blues du Businessman");
		frame.add(panneau, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
