package fr.natsystem.examen.tests;

import org.junit.After;
import org.junit.AfterClass; 
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestJUN2 {
	@BeforeClass
	public static void beforeAll() {
		System.out.println("Chargement du fichier csv.");
	}
	
	@Before
	public void beforeEach() {
		System.out.println("Attribution des valeurs du fichier à l'instance de passager");
	}
		
	
	@Test
	public void test1() {
		System.out.println("Boucle permettant d'afficher des 20 premiers passagers avec comparaison des valeurs 	");
	}

	@After
	public void afterEach() {
		System.out.println("afterEach()");
	}
	
	
	@AfterClass
	public static void afterAll() {
		System.out.println("afterAll()");
	}
	

}
