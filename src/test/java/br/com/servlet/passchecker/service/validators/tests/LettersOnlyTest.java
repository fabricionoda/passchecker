package br.com.servlet.passchecker.service.validators.tests;

import org.junit.Assert;
import org.junit.Test;

import br.com.passchecker.servlet.service.validators.LettersOnly;

public class LettersOnlyTest {

	@Test
	public void dado0CaracteresDeveRetornar0() {
		Assert.assertEquals(new Integer(0), new LettersOnly().bonus(""));
	}
	
	@Test
	public void dado11CaracteresSomenteLetrasDeveRetornar11() {
		Assert.assertEquals(new Integer(-11), new LettersOnly().bonus("drRTGDSGder"));
	}
	
	@Test
	public void dado11CaracteresSomenteLetrasCom1NumeroDeveRetornar0() {
		Assert.assertEquals(new Integer(0), new LettersOnly().bonus("drRTGDS4Gder"));
	}

}
