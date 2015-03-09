package br.com.servlet.passchecker.service.validators.tests;

import org.junit.Assert;
import org.junit.Test;

import br.com.passchecker.servlet.service.validators.NumbersOnly;

public class NumbersOnlyTest {

	@Test
	public void dado0CaracteresDeveRetornar0() {
		Assert.assertEquals(new Integer(0), new NumbersOnly().bonus(""));
	}
	
	@Test
	public void dado6numeros() {
		Assert.assertEquals(new Integer(-6), new NumbersOnly().bonus("481647"));
	}
	
	@Test
	public void dadoNumerosCom1Letra() {
		Assert.assertEquals(new Integer(0), new NumbersOnly().bonus("481a647"));
	}
}
