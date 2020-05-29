package fr.natsystem.tests.Vegas_Joshua;

import javax.inject.Inject;
import javax.inject.Named;
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
