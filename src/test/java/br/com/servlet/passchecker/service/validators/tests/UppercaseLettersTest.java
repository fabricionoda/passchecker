package br.com.servlet.passchecker.service.validators.tests;

import org.junit.Assert;
import org.junit.Test;

import br.com.passchecker.servlet.service.validators.UppercaseLetters;

public class UppercaseLettersTest {

	@Test
	public void dado0CaracteresDeveRetornar0() {
		Assert.assertEquals(new Integer(0), new UppercaseLetters().bonus(""));
	}
	
	@Test
	public void dado11CaracteresCom6MaiusculosDeveRetornar10() {
		Assert.assertEquals(new Integer(10), new UppercaseLetters().bonus("drRTGDSGder"));
	}
	
	@Test
	public void dado7CaracteresCom1MaiusculoDeveRetornar12() {
		Assert.assertEquals(new Integer(12), new UppercaseLetters().bonus("3F#s4a%"));
	}
	
	@Test
	public void somenteMicusculas() {
		Assert.assertEquals(new Integer(0), new UppercaseLetters().bonus("ahejks"));
	}

}
