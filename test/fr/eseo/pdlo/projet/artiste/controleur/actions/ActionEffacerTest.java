package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionEffacerTest {

	private ActionEffacerTest() {
		testConstructeurParDefaut();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ActionEffacerTest();
			}
		});
	}

	private void testConstructeurParDefaut() {
		PanneauDessin panneau = new PanneauDessin();
		PanneauBarreOutils panneauB = new PanneauBarreOutils(panneau);
		JFrame frame = new JFrame("Etre un Artiste");
		OutilLigne ligne = new OutilLigne();
		panneau.associerOutil(ligne); 
		frame.add(panneau, BorderLayout.CENTER);
		frame.add(panneauB, BorderLayout.EAST);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
