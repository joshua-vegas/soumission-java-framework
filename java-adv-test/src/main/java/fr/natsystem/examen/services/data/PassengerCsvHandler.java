package fr.natsystem.examen.services.data;

import java.util.ArrayList;
import java.util.List;
import fr.natsystem.examen.datamodel.Passenger;
import fr.natsystem.examen.datamodel.PassengerClass;
import fr.natsystem.examen.datamodel.PassengerSex;

public class PassengerCsvHandler {
	
	public static List<Passenger> readCSV(List<String> lines) {
		List<Passenger> resultat = new ArrayList<>();
		lines.remove(0);
		for (String line : lines) {
			String[] parts = line.split(";");
			if (parts.length != 5) {
				System.out.println("attention, le découpage de la ligne ne renvoie pas le résultat attendu");
				System.out.println("ligne en question : " + line);
				continue;
			}
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
					
			resultat.add(passenger);
		}
		// Appel de la méthode de tri
		sortByPClass(resultat);
		return resultat;
	}


	// Méthode de tri d'une liste de passagers basé sur la classe du passager.
	public static List<Passenger> sortByPClass(List<Passenger> passengers) {
		passengers.sort((i1,i2) -> i1.getPassengerClass().compareTo(i2.getPassengerClass()));
		return passengers;
	}

}
