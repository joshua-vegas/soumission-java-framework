package fr.natsystem.examen.tests;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

import fr.natsystem.examen.datamodel.Passenger;
import fr.natsystem.examen.datamodel.PassengerClass;
import fr.natsystem.examen.datamodel.PassengerSex;

public class TestJUN3 {
	@Test
	public void testReadFromCSV() throws IOException {
		
		//Given
		List<String> lines = Files.readAllLines(new File("data.csv").toPath(), StandardCharsets.ISO_8859_1);
		
	
		//When 
		List<Passenger> resultat = readCSV(lines);
		
		//then
		System.out.println(resultat);
		String expected = "Allen, Miss Elisabeth Walton";
		String actualName = resultat.get(0).getName();
		boolean success = expected.equals(actualName);
		if (!success) {
			System.out.println("problème : attendu " + expected + " obtenu : " + actualName);
			throw new AssertionError();
		}else {
			System.out.println("success!");
		}
		
		
	}
	
	private List<Passenger> readCSV(List<String> lines) {
		List<Passenger> resultat = new ArrayList<>();
		lines.remove(0);
		for (String line : lines) {
			String[] parts = line.split(";");
			if (parts.length != 2) {
				System.out.println("attention, le découpage de la ligne ne renvoie pas le résultat attendu");
				System.out.println("ligne en question : " + line);
				continue;
			}
			
			Passenger passenger = new Passenger();
			
			passenger.setName(parts[0].strip());
			PassengerClass pClass =  !"".equals(parts[1].strip()) ? PassengerClass.resolveFromCode(parts[1].strip()) : PassengerClass.NOCLASS;
			passenger.setPassengerClass(pClass);
			
			passenger.setAge(Double.valueOf(parts[2].strip()));
			
			passenger.setSex(PassengerSex.resolveFromCode(parts[3].strip()));
			
			String isNumberBoolean = parts[4].strip();
			Boolean isSurvived = "1".equals(isNumberBoolean);
			passenger.setSurvived(isSurvived);
		}
		resultat.sort((i1,i2) -> i1.getPassengerClass().compareTo(i2.getPassengerClass()));
		
		return resultat;
	}
}
