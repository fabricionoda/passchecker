package br.com.servlet.passchecker.service.tests;

import org.junit.Assert;
import org.junit.Test;

import br.com.passchecker.servlet.service.Complexity;

public class StrengthStatusTest {

	@Test
	public void verificaStatus() {
		Assert.assertEquals("Too Short", Complexity.fromStrength(0).toString());
		Assert.assertEquals("Very Weak", Complexity.fromStrength(1).toString());
		Assert.assertEquals("Very Weak", Complexity.fromStrength(19).toString());
		Assert.assertEquals("Weak", Complexity.fromStrength(20).toString());
		Assert.assertEquals("Weak", Complexity.fromStrength(39).toString());
		Assert.assertEquals("Good", Complexity.fromStrength(40).toString());
		Assert.assertEquals("Good", Complexity.fromStrength(59).toString());
		Assert.assertEquals("Strong", Complexity.fromStrength(60).toString());
		Assert.assertEquals("Strong", Complexity.fromStrength(79).toString());
		Assert.assertEquals("Very Strong", Complexity.fromStrength(81).toString());
		Assert.assertEquals("Very Strong", Complexity.fromStrength(120).toString());
	}

}
