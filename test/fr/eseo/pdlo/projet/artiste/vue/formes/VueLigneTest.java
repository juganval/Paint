package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ligne;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class VueLigneTest {

	private VueLigneTest() {
		testTraceLigne();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VueLigneTest();
			}
		});
	} 
	
	
	private void testTraceLigne() {
		Ligne ligne = new Ligne(new Coordonnees(200,200),500,200);
		ligne.setCouleur(Color.green);
		VueLigne vueLigne = new VueLigne(ligne);
		Ligne ligne1 = new Ligne(new Coordonnees(500,100),50,300);
		ligne1.setCouleur(Color.red);
		VueLigne vueLigne1 = new VueLigne(ligne1);
		PanneauDessin panneau = new PanneauDessin(1000, 600, Color.white);
		panneau.ajouterVueForme(vueLigne); 
		panneau.ajouterVueForme(vueLigne1); 
		JFrame frame = new JFrame("Etre");
		frame.add(panneau, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
