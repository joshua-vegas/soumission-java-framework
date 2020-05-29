package fr.natsystem.examen.services.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import fr.natsystem.examen.datamodel.Passenger;
import fr.natsystem.examen.datamodel.PassengerClass;
import fr.natsystem.examen.datamodel.PassengerSex;
import fr.natsystem.examen.services.DataFileLoadingException;

public class PassengerCsvHandler {
	
	// Récupération de la liste des passagers à partir d'un fichier csv 
		public static List<Passenger> readPassengersFromCSVFile(File file) throws DataFileLoadingException {
			List<String> lines = null;
			try {
				lines = Files.readAllLines(file.toPath());
			}catch (IOException e) {
				String detail = "aucun détail supplementaire";
				if (e instanceof FileNotFoundException) {
					detail = "le fichier n'est pas accessible";
				}
				if (e instanceof NoSuchFileException) {
					detail = "le fichier n'a pas été trouvé";
				}
				throw new DataFileLoadingException("Le fichier contenant les passagers n'a pas pu être chargé correctement "
						+ "(fichier en cause :" + file.getAbsolutePath() + ")"
						+ "\ndétail de l'erreur :" + detail , e);
			}
			
			// supprimme la ligne entête
			lines.remove(0);
			List<Passenger> passengers = new ArrayList<>();
			for (String line : lines) {
				Passenger passenger = PassengerCsvHandler.fromCSVLine(line);
				passengers.add(passenger);
			}
			
			// Appel de la méthode de tri
			sortByPClass(passengers);
		
			return passengers;
		}
		

		// Méthode permettant de créer des objets passenger à partir des informations présentes dans les lignes d'un fichier. 
		public static Passenger fromCSVLine(String line) {
			String[] parts = line.split(";");
			Passenger passenger = new Passenger();
						
			passenger.setName(parts[0].strip());
			
			// Condition de vérifications si le champs PClass du fichier n'est pas vide.
			// Si c'est le cas mettre associer la valeur NOCLASS à la colonne.
			// Sinon récupérer la valeur de la colonne.
			PassengerClass pClass =  !"".equals(parts[1].strip()) ? PassengerClass.resolveFromCode(parts[1].strip()) : PassengerClass.NOCLASS;
			passenger.setPassengerClass(pClass);
			
			passenger.setAge(Double.valueOf(parts[2].strip()));
			
			passenger.setSex(PassengerSex.resolveFromCode(parts[3].strip()));
			
			String isNumberBoolean = parts[4].strip();
			Boolean isSurvived = "1".equals(isNumberBoolean);
			passenger.setSurvived(isSurvived);
			
			return passenger;
		}
		
		// Méthode de tri d'une liste de passagers basé sur la classe du passager.
		public static List<Passenger> sortByPClass(List<Passenger> passengers) {
			passengers.sort((i1,i2) -> i1.getPassengerClass().compareTo(i2.getPassengerClass()));
			return passengers;
		}

}
