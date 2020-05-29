package fr.natsystem.tests.Vegas_Joshua;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestSPR2 {
	
	@Inject
	@Named("monPremierBean")
	String beanPhrase;
	
	
	@Test
	public void testInjectedQuery() {

		System.out.println("injectedDependency:" + beanPhrase);
		Assert.assertNotNull(beanPhrase);
	}

}
