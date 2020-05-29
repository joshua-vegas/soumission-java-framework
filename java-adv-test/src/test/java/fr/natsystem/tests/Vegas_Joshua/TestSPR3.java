package fr.natsystem.tests.Vegas_Joshua;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.natsystem.examen.datamodel.Passenger;
import fr.natsystem.examen.datamodel.PassengerClass;
import fr.natsystem.examen.datamodel.PassengerSex;
import org.junit.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestSPR3 {
	
	@Inject
	Passenger passengerBean;
	
	@Test
	public void testInjectQuestion() {
		PassengerSex sex = PassengerSex.MALE;
		PassengerClass pClass = PassengerClass.FIRST; 
		Passenger passenger = new Passenger();
		passenger.setName("Vegas_Joshua");
		passenger.setPassengerClass(pClass);
		passenger.setAge(30.0);
		passenger.setSex(sex);
		passenger.setSurvived(true);

		String verif = passenger.toString();

		Assert.assertEquals(verif, passengerBean.toString());

	}


}
