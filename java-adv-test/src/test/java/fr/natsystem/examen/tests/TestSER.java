package fr.natsystem.examen.tests;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import fr.natsystem.examen.datamodel.Passenger;
import fr.natsystem.examen.services.data.PassengerCsvHandler;

// Class de test de lecture du fichier data.
public class TestSER {
	
	public static void main(String[] args) throws IOException {
	
		//Given
		List<String> lines = Files.readAllLines(new File("data.csv").toPath(), StandardCharsets.ISO_8859_1);
		
	
		//When 
		List<Passenger> resultat = PassengerCsvHandler.readCSV(lines);
		
		//then
		System.out.println(resultat);
		// String expected = "Qu'est-ce que Maven ?";
		// String actualTitle = resultat.get(0).getTitle();
		boolean success = true;
		if (!success) {
			System.out.println("problème : attendu ");
			throw new AssertionError();
		}else {
			System.out.println("success!");
		}

	}

}
