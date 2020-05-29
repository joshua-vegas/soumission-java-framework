package fr.natsystem.examen.tests;

import java.io.File;
import java.util.List;

import fr.natsystem.examen.datamodel.Passenger;
import fr.natsystem.examen.services.data.PassengerCsvHandler;

// Class de test de lecture du fichier data.
public class TestSER {
	
	public static void main(String[] args) {
	
		//given : Un fichier contenant des lignes au format csv qui se trouve � la racine du projet
		// String fileName = "data.csv";
		// ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		// File file = new File(classLoader.getResource(fileName).getFile());
		
		String resourceName = "data.csv";
		 
		ClassLoader classLoader = TestSER.class.getClassLoader();
		File file = new File(classLoader.getResource(resourceName).getFile());
		// String absolutePath = file.getAbsolutePath();
		
		
		//when : Lecture du fichier CSV data avec tout les passagers.
		
		List<Passenger> passengers;
		try {
			passengers = PassengerCsvHandler.readPassengersFromCSVFile(file);
		} catch (Exception e) {
			System.out.println("une erreur est survenue");
			System.out.println(e.getMessage());
			return;
		}
		
		// Test compl�mentaire permettant de v�rifier si le fichier � bien �t� charg�.
		// 1313 �tant le nombre de lignes compris dans le fichier Titanic.csv moins l'ent�te.
		boolean success = passengers.size() == 1313;
		
		if (!success) {
			System.out.println("une erreur est survenue pendant le chargement");
		}
			
		//then : Affichage des cinq premiers passagers
		for (int i = 0; i < 5; i++) {
			System.out.println(passengers.get(i));
		}

	}

}
