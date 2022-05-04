package fr.eseo.pdlo.projet.artiste.vue.ihm;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PanneauBarreOutilsTest {

	private PanneauBarreOutilsTest() {
		testConstructeurParDefaut();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new PanneauBarreOutilsTest();
			}
		});
	}

	private void testConstructeurParDefaut() {
		PanneauDessin panneau = new PanneauDessin();
		PanneauBarreOutils panneauB = new PanneauBarreOutils(panneau);
		JFrame frame = new JFrame("Etre un Artiste");
		frame.add(panneau, BorderLayout.CENTER);
		frame.add(panneauB, BorderLayout.EAST);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
