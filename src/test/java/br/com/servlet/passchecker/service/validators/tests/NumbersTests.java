package br.com.servlet.passchecker.service.validators.tests;

import org.junit.Assert;
import org.junit.Test;

import br.com.passchecker.servlet.service.validators.Numbers;

public class NumbersTests {

	@Test
	public void dado0CaracteresDeveRetornar0() {
		Assert.assertEquals(new Integer(0), new Numbers().bonus(""));
	}
	
	@Test
	public void dado8CaracteresCom2NumerosDeveRetornar8() {
		Assert.assertEquals(new Integer(8), new Numbers().bonus("3F#s4a%T"));
	}

}
