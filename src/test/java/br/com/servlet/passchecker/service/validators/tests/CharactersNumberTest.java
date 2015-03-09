package br.com.servlet.passchecker.service.validators.tests;

import org.junit.Assert;
import org.junit.Test;

import br.com.passchecker.servlet.service.validators.CharactersNumber;

public class CharactersNumberTest {

	@Test
	public void dado0Caracteres() {
		Assert.assertEquals(new Integer(0), new CharactersNumber().bonus(""));
	}
	
	@Test
	public void dado3Caracteres() {
		Assert.assertEquals(new Integer(12), new CharactersNumber().bonus("d@3"));
	}

}
