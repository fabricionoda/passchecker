package br.com.servlet.passchecker.service.validators.tests;

import org.junit.Assert;
import org.junit.Test;

import br.com.passchecker.servlet.service.validators.Symbols;

public class SymbosTest {
	@Test
	public void dado0CaracteresDeveRetornar0() {
		Assert.assertEquals(new Integer(0), new Symbols().bonus(""));
	}
	
	@Test
	public void dado11CaracteresSemEspeciaisDeveRetornar0() {
		Assert.assertEquals(new Integer(0), new Symbols().bonus("drRT4S3Gder"));
	}
	
	@Test
	public void dado7CaracteresCom2EspeciaisDeveRetornar12() {
		Assert.assertEquals(new Integer(12), new Symbols().bonus("3F#s4a%"));
	}
	
	@Test
	public void dadoSomenteLetrasMinuculas() {
		Assert.assertEquals(new Integer(0), new Symbols().bonus("ahejks"));
	}
}
