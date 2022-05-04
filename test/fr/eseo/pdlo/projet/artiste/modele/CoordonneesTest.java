package fr.eseo.pdlo.projet.artiste.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CoordonneesTest {

	@Test
	public void testConstructeur() {
		Coordonnees coord1 = new Coordonnees(10, 11);
		Coordonnees coord2 = new Coordonnees(-10, -11);
		Coordonnees coord3 = new Coordonnees(-10.028, -11.58);
		assertEquals(10, coord1.getAbscisse(), "Test de la méthode get Abscisse");
		assertEquals(-11, coord2.getOrdonnee(), "Test de la méthode get Ordonnees");
		assertEquals(-10, coord2.getAbscisse(), "Test de la méthode get Abscisse");
		assertEquals(11, coord1.getOrdonnee(), "Test de la méthode get Ordonnees");
		assertEquals(-10.028, coord3.getAbscisse(), "Test de la méthode get Abscisse");
		assertEquals(-11.58, coord3.getOrdonnee(), "Test de la méthode get Ordonnees");
	}

	@Test
	public void testDeplacer() {
		Coordonnees coord1 = new Coordonnees(10, 11);
		Coordonnees coord3 = new Coordonnees(-10, -11);
		Coordonnees coord4 = new Coordonnees(6, -8);
		coord4.deplacerDe(2, 4);
		assertEquals(8, coord4.getAbscisse(), "Test de la méthode DeplacerDe");
		coord3.deplacerVers(9, 15);
		coord1.setOrdonnee(10);
		coord1.setAbscisse(8);
		assertEquals(10, coord1.getOrdonnee(), "Test de la méthode DeplacerVers");
		assertEquals(8, coord1.getAbscisse(), "Test de la méthode DeplacerVers");
	}

	@Test
	public void testDistanceAngle() {
		Coordonnees coord = new Coordonnees();
		Coordonnees coord1 = new Coordonnees(10, 11);
		Coordonnees coord2 = new Coordonnees(-5, -5);
		Coordonnees coord3 = new Coordonnees(6, 8);
		Coordonnees coord4 = new Coordonnees(10, 10);
		assertEquals(Math.sqrt(200), coord.distanceVers(coord4), "Test de la méthode Distance");
		assertEquals(-2.498091544796509, coord1.angleVers(coord3), "Test de la méthode AngleVers");
		assertEquals(Math.sqrt(450), coord4.distanceVers(coord2), "Test de la méthode Distance");
	}

	@Test
	public void testToString() {
		Coordonnees coord1 = new Coordonnees(10, 11);
		Coordonnees coord2 = new Coordonnees(-5.0, -5.1558);
		Coordonnees coord3 = new Coordonnees(1.7822, 7.1);
		assertEquals("(10,0 , 11,0)", coord1.toString(), "Test de la méthode toString");
		assertEquals("(-5,0 , -5,16)", coord2.toString(), "Test de la méthode toString");
		assertEquals("(1,78 , 7,1)", coord3.toString(), "Test de la méthode toString");
	}
}
