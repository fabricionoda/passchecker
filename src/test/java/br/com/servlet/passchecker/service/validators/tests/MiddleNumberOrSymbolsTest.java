package br.com.servlet.passchecker.service.validators.tests;

import org.junit.Assert;
import org.junit.Test;

import br.com.passchecker.servlet.service.validators.MiddleNumberOrSymbols;

public class MiddleNumberOrSymbolsTest {
	@Test
	public void dado0CaracteresDeveRetornar0() {
		Assert.assertEquals(new Integer(0), new MiddleNumberOrSymbols().bonus(""));
	}
	
	@Test
	public void dado2CaracteresEspeciaisOuNumerosDeveRetornar0() {
		Assert.assertEquals(new Integer(0), new MiddleNumberOrSymbols().bonus("#4"));
	}
	
	@Test
	public void dado9CaracteresCom3EspeciaisOuNumerosInicioEFimDeveRetornar6() {
		Assert.assertEquals(new Integer(6), new MiddleNumberOrSymbols().bonus("#d43Sdr%&"));
	}
	
	@Test
	public void dado7CaracteresCom2EspeciaisOuNumerosNoMeioDeveRetornar4() {
		Assert.assertEquals(new Integer(4), new MiddleNumberOrSymbols().bonus("3F#s4a%"));
	}
}
