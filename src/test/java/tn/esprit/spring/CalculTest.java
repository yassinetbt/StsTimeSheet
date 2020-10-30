package tn.esprit.spring;

import org.junit.Assert;
import org.junit.Test;

public class CalculTest {
	Calcul calcul = new Calcul();

	@Test
	public void testCalculerSom() {
	Assert.assertEquals(15, calcul.calculerSom(10, 15));
	}
	@Test
	public void testCalculerDiff() {
	Assert.assertEquals(30, calcul.calculerDiff(40, 10));
	}

}
