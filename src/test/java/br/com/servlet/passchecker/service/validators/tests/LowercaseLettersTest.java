package br.com.servlet.passchecker.service.validators.tests;

import org.junit.Assert;
import org.junit.Test;

import br.com.passchecker.servlet.service.validators.LowercaseLetters;

public class LowercaseLettersTest {

	@Test
	public void dado0CaracteresDeveRetornar0() {
		Assert.assertEquals(new Integer(0), new LowercaseLetters().bonus(""));
	}
	
	@Test
	public void dado11CaracteresCom5MinusculosDeveRetornar12() {
		Assert.assertEquals(new Integer(12), new LowercaseLetters().bonus("drRTGDSGder"));
	}
	
	@Test
	public void dado7CaracteresCom2MinusculosDeveRetornar10() {
		Assert.assertEquals(new Integer(10), new LowercaseLetters().bonus("3F#s4a%"));
	}
	
	@Test
	public void dadoSomenteCaracteresMinusculos() {
		Assert.assertEquals(new Integer(0), new LowercaseLetters().bonus("ahejks"));
	}
	
	@Test
	public void dadoSomenteCaracteresMaiusculos() {
		Assert.assertEquals(new Integer(0), new LowercaseLetters().bonus("DFSDF"));
	}
	

}
