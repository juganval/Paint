package fr.eseo.pdlo.projet.artiste.modele.formes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;
import java.util.Locale;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

public class CercleTest {

	@Test
	public void testConstructeur() {
		Coordonnees coord = new Coordonnees();
		Cercle cercle = new Cercle();
		assertEquals(100, cercle.getLargeur());
		assertEquals(100, cercle.getHauteur());
		assertEquals(coord.getAbscisse(), cercle.getPosition().getAbscisse());
		assertEquals(coord.getOrdonnee(), cercle.getPosition().getOrdonnee());
	}

	@Test
	public void testConstructeur2() {
		Coordonnees coord = new Coordonnees(7, 3.8);
		Cercle cercle = new Cercle(coord, 20.0);
		assertEquals(20.0, cercle.getLargeur());
		assertEquals(20.0, cercle.getHauteur());
		assertEquals(coord.getAbscisse(), cercle.getPosition().getAbscisse());
		assertEquals(coord.getOrdonnee(), cercle.getPosition().getOrdonnee());
	}

	@Test
	public void testConstructeur3() {
		Coordonnees coord = new Coordonnees(7, -3.8);
		Cercle cercle = new Cercle(coord, 170.0);
		assertEquals(170.0, cercle.getLargeur());
		assertEquals(170.0, cercle.getHauteur());
		assertEquals(7, cercle.getPosition().getAbscisse());
		assertEquals(-3.8, cercle.getPosition().getOrdonnee());
	}

	@Test
	public void testConstructeur4() {
		Coordonnees coord = new Coordonnees(7, -3.8);
		Cercle cercle = new Cercle(coord);
		assertEquals(100, cercle.getLargeur());
		assertEquals(100, cercle.getHauteur());
		assertEquals(coord.getAbscisse(), cercle.getPosition().getAbscisse());
		assertEquals(coord.getOrdonnee(), cercle.getPosition().getOrdonnee());
	}

	@Test
	public void testConstructeur5() {
		Cercle cercle = new Cercle(50);
		assertEquals(50, cercle.getLargeur());
		assertEquals(50, cercle.getHauteur());
		assertEquals(0, cercle.getPosition().getAbscisse());
		assertEquals(0, cercle.getPosition().getOrdonnee());
		cercle.setLargeur(20);
		cercle.setHauteur(20);
		assertEquals(20, cercle.getLargeur());
		assertEquals(20, cercle.getHauteur());
	}

	@Test
	public void testPerimetre() {
		Coordonnees coord = new Coordonnees(2, 5);
		Cercle cercle = new Cercle(4);
		assertEquals(12.566370614359172, cercle.perimetre(), "test de la méthode périmetre");
		Cercle cercle1 = new Cercle(coord, 7);
		assertEquals(21.991148575128552, cercle1.perimetre(), "test de la méthode périmetre");
	}

	@Test
	public void testaire() {
		Coordonnees coord = new Coordonnees(2, 5);
		Cercle cercle = new Cercle(4);
		assertEquals(12.566370614359172, cercle.aire(), "test de la méthode aire");
		Cercle cercle1 = new Cercle(coord, 7);
		assertEquals(38.48451000647496, cercle1.aire(), "test de la méthode aire");
	}

	@Test
	public void testNegatif() {
		Cercle cercle = new Cercle(50);
		assertThrows(IllegalArgumentException.class, () -> cercle.setLargeur(-50));
		assertThrows(IllegalArgumentException.class, () -> cercle.setHauteur(-50));
	}

	@Test
	public void testToString() {
		Cercle cercle = new Cercle(10);
		Coordonnees coord = new Coordonnees(2.0, 5.9);
		Cercle cercle1 = new Cercle(coord, 20);
		cercle1.setCouleur(Color.green);
		cercle.setRemplissage(Remplissage.AUCUNE);
		cercle1.setRemplissage(Remplissage.UNIFORME);
		Locale.setDefault(new Locale("fr"));
		assertEquals("[Cercle aucune] : pos (0,0 , 0,0) rayon 5,0 périmètre : 31,42 aire : 78,54 couleur = R51,V51,B51",
				cercle.toString(), "Test de la méthode toString");
		Locale.setDefault(new Locale("en"));
		assertEquals("[Cercle uniforme] : pos (2.0 , 5.9) rayon 10.0 périmètre : 62.83 aire : 314.16 couleur = R0,G255,B0",
				cercle1.toString(), "Test de la méthode toString");
	}

	@Test
	public void testContient() {
		Cercle cercle = new Cercle(11);
		Coordonnees coord = new Coordonnees(2.0, 5.9);
		Coordonnees coord1 = new Coordonnees(40, -4);
		Cercle cercle1 = new Cercle(20);
		Coordonnees coord2 = new Coordonnees(10, 0);
		assertEquals(true, cercle.contient(coord), "test de la méthode contient");
		assertEquals(false, cercle1.contient(coord1), "test de la méthode contient");
		assertEquals(true, cercle1.contient(coord), "test de la méthode contient");
		assertEquals(false, cercle.contient(coord1), "test de la méthode contient");
		assertTrue(cercle1.contient(coord2), "test de la méthode contient");
	}

	@Test
	public void testCouleur() {
		Cercle cercle = new Cercle();
		cercle.setCouleur(Color.red);
		assertEquals(Color.red, cercle.getCouleur(), "test de la méthode contient");
		cercle.setCouleur(Color.black);
		assertEquals(Color.black, cercle.getCouleur(), "test de la méthode contient");
	}
}
