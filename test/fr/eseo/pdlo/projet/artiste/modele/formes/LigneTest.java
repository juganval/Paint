package fr.eseo.pdlo.projet.artiste.modele.formes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;
import java.util.Locale;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class LigneTest {

	@Test
	public void testConstructeur() {
		Ligne ligne1 = new Ligne();
		Ligne ligne2 = new Ligne(-10, -11);
		Coordonnees coord = new Coordonnees(1, 2);
		Ligne ligne3 = new Ligne(coord);
		Ligne ligne4 = new Ligne(coord, 15, 8);
		assertEquals(100, ligne1.getLargeur(), "Test de la méthode get Largeur");
		assertEquals(-11, ligne2.getHauteur(), "Test de la méthode get Hauteur");
		assertEquals(coord, ligne3.getPosition(), "Test de la méthode get Position");
		assertEquals(coord, ligne4.getPosition(), "Test de la méthode get Position");
		assertEquals(15, ligne4.getLargeur(), "Test de la méthode get Largeur");
		assertEquals(8, ligne4.getHauteur(), "Test de la méthode get Hauteur");
	}

	@Test
	public void testGetC1C2() {
		Ligne ligne1 = new Ligne();
		Coordonnees coord = new Coordonnees(10, 20);
		Ligne ligne2 = new Ligne(coord, 5, 9);
		assertEquals(0.0, ligne1.getC1().getAbscisse(), "Test de la méthode get C1");
		assertEquals(150, ligne1.getC2().getOrdonnee(), "Test de la méthode get C2");
		assertEquals(10, ligne2.getC1().getAbscisse(), "Test de la méthode get C1");
		assertEquals(29, ligne2.getC2().getOrdonnee(), "Test de la méthode get C2");
	}

	@Test
	public void testPerimetre() {
		Ligne ligne1 = new Ligne();
		Ligne ligne2 = new Ligne(1, 2);
		assertEquals(Math.sqrt((Math.pow(ligne1.getLargeur(), 2) + (Math.pow(ligne1.getHauteur(), 2)))),
				ligne1.perimetre(), "Test de la méthode périmètre");
		assertEquals(Math.sqrt((Math.pow(ligne2.getLargeur(), 2) + (Math.pow(ligne2.getHauteur(), 2)))),
				ligne2.perimetre(), "Test de la méthode périmètre");
	}

	@Test
	public void testLigneParDefautSetPostionC1C2() {
		Ligne ligne1 = new Ligne();
		Coordonnees coord = new Coordonnees(8, 2);
		ligne1.setPosition(coord);
		assertEquals(coord, ligne1.getPosition(), "Test de la méthode setPosition");
		assertEquals(100, ligne1.getLargeur(), "Test de la méthode setLargeur");
		assertEquals(150, ligne1.getHauteur(), "Test de la méthode setHauteur");
		ligne1.setC1(coord);
		ligne1.setC2(coord);
		assertEquals(coord, ligne1.getC1(), "Test de la méthode périmètre");
		assertEquals(8, ligne1.getC2().getAbscisse(), "Test de la méthode périmètre");
	}

	@Test
	public void testLigneCoordonneeSetPostionC1C2() {
		Ligne ligne2 = new Ligne(4, 5);
		Coordonnees coord = new Coordonnees(4, 2);
		ligne2.setLargeur(9);
		ligne2.setHauteur(3);
		assertEquals(9, ligne2.getLargeur(), "Test de la méthode setLargeur");
		assertEquals(3, ligne2.getHauteur(), "Test de la méthode setHauteur");
		ligne2.setC1(coord);
		ligne2.setC2(coord);
		assertEquals(coord, ligne2.getC1(), "Test de la méthode périmètre");
		assertEquals(4, ligne2.getC2().getAbscisse(), "Test de la méthode périmètre");
	}

	@Test
	public void testCadre() {
		Ligne ligne1 = new Ligne();
		Coordonnees coord = new Coordonnees(2, 2);
		Ligne ligne2 = new Ligne(coord, 2, 2);
		Coordonnees coord1 = new Coordonnees(1, 2);
		Ligne ligne3 = new Ligne(coord1, -2, 3);
		assertEquals(0, ligne1.getCadreMinX(), "Test de la méthode getCadreMinX");
		assertEquals(0, ligne1.getCadreMinY(), "Test de la méthode getCadreMinY");
		assertEquals(100, ligne1.getCadreMaxX(), "Test de la méthode getCadreMaxX");
		assertEquals(150, ligne1.getCadreMaxY(), "Test de la méthode getCadreMaxY");
		assertEquals(2, ligne2.getCadreMinX(), "Test de la méthode getCadreMinX");
		assertEquals(2, ligne2.getCadreMinY(), "Test de la méthode getCadreMinY");
		assertEquals(4, ligne2.getCadreMaxX(), "Test de la méthode getCadreMaxX");
		assertEquals(4, ligne2.getCadreMaxY(), "Test de la méthode getCadreMaxY");
		assertEquals(-1, ligne3.getCadreMinX(), "Test de la méthode getCadreMinX");
		assertEquals(2, ligne3.getCadreMinY(), "Test de la méthode getCadreMinY");
		assertEquals(1, ligne3.getCadreMaxX(), "Test de la méthode getCadreMaxX");
		assertEquals(5, ligne3.getCadreMaxY(), "Test de la méthode getCadreMaxY");
	}

	@Test
	public void testDeplacerDe() {
		Coordonnees coord = new Coordonnees(10, -10);
		Ligne ligne = new Ligne(coord, 3, 4);
		assertEquals(coord, ligne.getC1(), "Test de la métode DéplacerDe");
		assertEquals(13, ligne.getC2().getAbscisse(), "Test de la métode DéplacerDe");
		ligne.deplacerDe(1, -8);
		assertEquals(11, ligne.getC1().getAbscisse(), "Test de la métode DéplacerDe");
		assertEquals(-14, ligne.getC2().getOrdonnee(), "Test de la métode DéplacerDe");
	}

	@Test
	public void testDeplacerVers() {
		Coordonnees coord = new Coordonnees();
		Ligne ligne = new Ligne(coord, 3, 4);
		assertEquals(coord, ligne.getC1(), "Test de la métode DéplacerVers");
		assertEquals(4, ligne.getC2().getOrdonnee(), "Test de la métode DéplacerVers");
		ligne.deplacerVers(12, -1);
		assertEquals(12, ligne.getC1().getAbscisse(), "Test de la métode DéplacerVers");
		assertEquals(3, ligne.getC2().getOrdonnee(), "Test de la métode DéplacerVers");
	}

	@Test
	public void testAire() {
		Coordonnees coord = new Coordonnees(5, 9);
		Ligne ligne = new Ligne(coord, 3, 4);
		assertEquals(0, ligne.aire(), "Test de la métode Aire");
	}

	@Test
	public void testToString() {
		Coordonnees coord = new Coordonnees(10, 11);
		Ligne ligne = new Ligne(coord);
		Coordonnees coord1 = new Coordonnees(-5.0, -5.1558);
		Ligne ligne1 = new Ligne(coord1, -10, -50);
		ligne1.setCouleur(Color.green);
		Locale.setDefault(new Locale("fr"));
		assertEquals("[Ligne] c1 : (10,0 , 11,0) c2 : (110,0 , 161,0) longueur : 180,28 angle : 56,31° couleur = R51,V51,B51",
				ligne.toString(), "Test de la méthode toString");
		Locale.setDefault(new Locale("en"));
		assertEquals("[Ligne] c1 : (-5.0 , -5.16) c2 : (-15.0 , -55.16) longueur : 50.99 angle : 258.69° couleur = R0,G255,B0",
				ligne1.toString(), "Test de la méthode toString");
	}

	@Test
	public void testContient() {
		Ligne ligne = new Ligne(10, 11);
		Coordonnees coord = new Coordonnees();
		Coordonnees coord1 = new Coordonnees(40, -4);
		Ligne ligne1 = new Ligne(20, 11);
		assertEquals(true, ligne.contient(coord), "test de la méthode contient");
		assertEquals(false, ligne1.contient(coord1), "test de la méthode contient");
		assertEquals(true, ligne1.contient(coord), "test de la méthode contient");
		assertEquals(false, ligne.contient(coord1), "test de la méthode contient");
	}
	
	
	@Test
	public void testCouleur() {
		Ligne ligne = new Ligne(10, 11);
		ligne.setCouleur(Color.red);
		assertEquals(Color.red, ligne.getCouleur(), "test de la méthode contient");
		ligne.setCouleur(Color.black);
		assertEquals(Color.black, ligne.getCouleur(), "test de la méthode contient");
	}
}
