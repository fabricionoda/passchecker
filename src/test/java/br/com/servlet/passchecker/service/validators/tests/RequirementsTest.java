package br.com.servlet.passchecker.service.validators.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import br.com.passchecker.servlet.service.validators.Requirements;

public class RequirementsTest {
	@Test
	public void dadoSenhaComCaracteresRequeridosDeveRetornar10() {
		assertEquals(new Integer(10), new Requirements().bonus("#d43Sdr%&"));
	}
	
	@Test
	public void somenteMicusculas() {
		Assert.assertEquals(new Integer(0), new Requirements().bonus("ahejks"));
	}
}
