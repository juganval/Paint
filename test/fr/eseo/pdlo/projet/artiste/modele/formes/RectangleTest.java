package fr.eseo.pdlo.projet.artiste.modele.formes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;
import java.util.Locale;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

public class RectangleTest {

	@Test
	public void testConstructeur() {
		Rectangle rectangle = new Rectangle();
		assertEquals(100, rectangle.getLargeur());
		assertEquals(150, rectangle.getHauteur());
		Coordonnees coord = new Coordonnees();
		assertEquals(coord.getAbscisse(), rectangle.getPosition().getAbscisse());
		assertEquals(coord.getOrdonnee(), rectangle.getPosition().getOrdonnee());
	}

	@Test
	public void testConstructeur2() {
		Coordonnees coord = new Coordonnees(2.0, 5.9);
		Rectangle rectangle = new Rectangle(coord, 23.0, 48.2);
		assertEquals(23.0, rectangle.getLargeur());
		assertEquals(48.2, rectangle.getHauteur());
		assertEquals(coord.getAbscisse(), rectangle.getPosition().getAbscisse());
		assertEquals(coord.getOrdonnee(), rectangle.getPosition().getOrdonnee());
	}

	@Test
	public void testConstructeur3() {
		Coordonnees coord = new Coordonnees(-8, 3.8);
		Rectangle rectangle = new Rectangle(coord, 23.0, 53.8);
		assertEquals(23.0, rectangle.getLargeur());
		assertEquals(53.8, rectangle.getHauteur());
		assertEquals(-8, rectangle.getPosition().getAbscisse());
		assertEquals(3.8, rectangle.getPosition().getOrdonnee());
	}

	@Test
	public void testConstructeur4() {
		Coordonnees coord = new Coordonnees(2.0, 5.9);
		Rectangle rectangle = new Rectangle(coord);
		assertEquals(100, rectangle.getLargeur());
		assertEquals(150, rectangle.getHauteur());
		assertEquals(coord.getAbscisse(), rectangle.getPosition().getAbscisse());
		assertEquals(coord.getOrdonnee(), rectangle.getPosition().getOrdonnee());
	}

	@Test
	public void testConstructeur5() {
		Rectangle rectangle = new Rectangle(67.9, 5.2);
		assertEquals(67.9, rectangle.getLargeur());
		assertEquals(5.2, rectangle.getHauteur());
		assertEquals(0.0, rectangle.getPosition().getAbscisse());
		assertEquals(0.0, rectangle.getPosition().getOrdonnee());
	}

	@Test
	public void testSet() {
		Rectangle rectangle = new Rectangle(67.9, 5.2);
		Coordonnees coord = new Coordonnees(2.0, 5.9);
		rectangle.setPosition(coord);
		assertEquals(coord.getAbscisse(), rectangle.getPosition().getAbscisse());
		assertEquals(coord.getOrdonnee(), rectangle.getPosition().getOrdonnee());
		rectangle.setLargeur(2.9);
		rectangle.setHauteur(5.9);
		assertEquals(2.9, rectangle.getLargeur());
		assertEquals(5.9, rectangle.getHauteur());
	}

	@Test
	public void testAirePerimetre() {
		Rectangle rectangle = new Rectangle(10.0, 10.0);
		assertEquals(25 * Math.PI, rectangle.aire());
		assertEquals(31.41592653589793, rectangle.perimetre());
	}

	@Test
	public void testNegatif() {
		Rectangle rectangle = new Rectangle();
		assertThrows(IllegalArgumentException.class, () -> rectangle.setLargeur(-50));
		assertThrows(IllegalArgumentException.class, () -> rectangle.setHauteur(-50));
	}

	@Test
	public void testToString() {
		Rectangle rectangle = new Rectangle(10, 11);
		Coordonnees coord = new Coordonnees(2.0, 5.9);
		Rectangle rectangle1 = new Rectangle(coord, 20, 11);
		rectangle.setCouleur(Color.green);
		Locale.setDefault(new Locale("fr"));
		rectangle.setRemplissage(Remplissage.AUCUNE);
		rectangle1.setRemplissage(Remplissage.UNIFORME);
		assertEquals(
				"[Rectangle aucune] : pos (0,0 , 0,0) largeur 11,0 hauteur 10,0 périmètre : 42,0 aire : 110,0 couleur = R0,V255,B0",
				rectangle.toString(), "Test de la méthode toString");
		Locale.setDefault(new Locale("en"));
		assertEquals(
				"[Rectangle aucune] : pos (0.0 , 0.0) largeur 11.0 hauteur 10.0 périmètre : 42.0 aire : 110.0 couleur = R0,G255,B0",
				rectangle.toString(), "Test de la méthode toString");
	}

	@Test
	public void testContient() {
		Rectangle rectangle = new Rectangle(10, 11);
		Coordonnees coord = new Coordonnees(2.0, 5.9);
		Coordonnees coord1 = new Coordonnees(40, -4);
		Rectangle rectangle1 = new Rectangle(20, 11);
		Coordonnees coord2 = new Coordonnees(10, 0);
		assertEquals(true, rectangle.contient(coord), "test de la méthode contient");
		assertEquals(false, rectangle1.contient(coord1), "test de la méthode contient");
		assertEquals(true, rectangle.contient(coord), "test de la méthode contient");
		assertEquals(false, rectangle1.contient(coord1), "test de la méthode contient");
		assertTrue(rectangle.contient(coord2), "test de la méthode contient");
	}

	@Test
	public void testCouleur() {
		Rectangle rectangle = new Rectangle();
		rectangle.setCouleur(Color.red);
		assertEquals(Color.red, rectangle.getCouleur(), "test de la méthode contient");
		rectangle.setCouleur(Color.black);
		assertEquals(Color.black, rectangle.getCouleur(), "test de la méthode contient");
	}
}
