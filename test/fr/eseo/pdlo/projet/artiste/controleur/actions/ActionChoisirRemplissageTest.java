package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirRemplissageTest
{
	private ActionChoisirRemplissageTest() {
		testConstructeurParDefaut();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ActionChoisirRemplissageTest();
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
