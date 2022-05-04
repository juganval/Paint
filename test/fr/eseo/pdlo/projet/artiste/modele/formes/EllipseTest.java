package fr.eseo.pdlo.projet.artiste.modele.formes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;
import java.util.Locale;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

public class EllipseTest {

	@Test
	public void testConstructeur() {
		Ellipse ellipse = new Ellipse();
		assertEquals(100, ellipse.getLargeur());
		assertEquals(150, ellipse.getHauteur());
		Coordonnees coord = new Coordonnees();
		assertEquals(coord.getAbscisse(), ellipse.getPosition().getAbscisse());
		assertEquals(coord.getOrdonnee(), ellipse.getPosition().getOrdonnee());
	}

	@Test
	public void testConstructeur2() {
		Coordonnees coord = new Coordonnees(2.0, 5.9);
		Ellipse ellipse = new Ellipse(coord, 23.0, 48.2);
		assertEquals(23.0, ellipse.getLargeur());
		assertEquals(48.2, ellipse.getHauteur());
		assertEquals(coord.getAbscisse(), ellipse.getPosition().getAbscisse());
		assertEquals(coord.getOrdonnee(), ellipse.getPosition().getOrdonnee());
	}

	@Test
	public void testConstructeur3() {
		Coordonnees coord = new Coordonnees(-8, 3.8);
		Ellipse ellipse = new Ellipse(coord, 23.0, 53.8);
		assertEquals(23.0, ellipse.getLargeur());
		assertEquals(53.8, ellipse.getHauteur());
		assertEquals(-8, ellipse.getPosition().getAbscisse());
		assertEquals(3.8, ellipse.getPosition().getOrdonnee());
	}

	@Test
	public void testConstructeur4() {
		Coordonnees coord = new Coordonnees(2.0, 5.9);
		Ellipse ellipse = new Ellipse(coord);
		assertEquals(100, ellipse.getLargeur());
		assertEquals(150, ellipse.getHauteur());
		assertEquals(coord.getAbscisse(), ellipse.getPosition().getAbscisse());
		assertEquals(coord.getOrdonnee(), ellipse.getPosition().getOrdonnee());
	}

	@Test
	public void testConstructeur5() {
		Ellipse ellipse = new Ellipse(67.9, 5.2);
		assertEquals(67.9, ellipse.getLargeur());
		assertEquals(5.2, ellipse.getHauteur());
		assertEquals(0.0, ellipse.getPosition().getAbscisse());
		assertEquals(0.0, ellipse.getPosition().getOrdonnee());
	}

	@Test
	public void testSet() {
		Ellipse ellipse = new Ellipse(67.9, 5.2);
		Coordonnees coord = new Coordonnees(2.0, 5.9);
		ellipse.setPosition(coord);
		assertEquals(coord.getAbscisse(), ellipse.getPosition().getAbscisse());
		assertEquals(coord.getOrdonnee(), ellipse.getPosition().getOrdonnee());
		ellipse.setLargeur(2.9);
		ellipse.setHauteur(5.9);
		assertEquals(2.9, ellipse.getLargeur());
		assertEquals(5.9, ellipse.getHauteur());
	}

	@Test
	public void testAirePerimetre() {
		Ellipse ellipse = new Ellipse(10.0, 10.0);
		assertEquals(25 * Math.PI, ellipse.aire());
		assertEquals(31.41592653589793, ellipse.perimetre());
	}

	@Test
	public void testNegatif() {
		Ellipse ellipse = new Ellipse();
		assertThrows(IllegalArgumentException.class, () -> ellipse.setLargeur(-50));
		assertThrows(IllegalArgumentException.class, () -> ellipse.setHauteur(-50));
	}

	@Test
	public void testToString() {
		Ellipse ellipse = new Ellipse(10, 11);
		Coordonnees coord = new Coordonnees(2.0, 5.9);
		Ellipse ellipse1 = new Ellipse(coord, 20, 11);
		ellipse1.setCouleur(Color.green);
		Locale.setDefault(new Locale("fr"));
		ellipse.setRemplissage(Remplissage.AUCUNE);
		ellipse1.setRemplissage(Remplissage.UNIFORME);
		assertEquals("[Ellipse aucune] : pos (0,0 , 0,0) petit rayon 5,0 grand rayon 5,5 périmètre : 33,01"
				+ " aire : 86,39 couleur = R51,V51,B51", ellipse.toString(), "Test de la méthode toString");
		Locale.setDefault(new Locale("en"));
		assertEquals("[Ellipse uniforme] : pos (2.0 , 5.9) petit rayon 5.5 grand rayon 10.0 périmètre : 49.73"
				+ " aire : 172.79 couleur = R0,G255,B0", ellipse1.toString(), "Test de la méthode toString");
	}

	@Test
	public void testContient() {
		Ellipse ellipse = new Ellipse(10, 11);
		Coordonnees coord = new Coordonnees(2.0, 5.9);
		Coordonnees coord1 = new Coordonnees(40, -4);
		Ellipse ellipse1 = new Ellipse(20, 11);
		Coordonnees coord2 = new Coordonnees(10, 0);
		assertEquals(true, ellipse.contient(coord), "test de la méthode contient");
		assertEquals(false, ellipse1.contient(coord1), "test de la méthode contient");
		assertEquals(true, ellipse1.contient(coord), "test de la méthode contient");
		assertEquals(false, ellipse.contient(coord1), "test de la méthode contient");
		assertTrue(ellipse1.contient(coord2), "test de la méthode contient");
	}

	@Test
	public void testCouleur() {
		Ellipse ellipse = new Ellipse();
		ellipse.setCouleur(Color.red);
		assertEquals(Color.red, ellipse.getCouleur(), "test de la méthode contient");
		ellipse.setCouleur(Color.black);
		assertEquals(Color.black, ellipse.getCouleur(), "test de la méthode contient");
	}
}