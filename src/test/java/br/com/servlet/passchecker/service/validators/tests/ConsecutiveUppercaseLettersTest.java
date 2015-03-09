package br.com.servlet.passchecker.service.validators.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.passchecker.servlet.service.validators.ConsecutiveUppercaseLetters;

public class ConsecutiveUppercaseLettersTest {

	@Test
	public void bonus2MaiusculasConsecutivas() {
		String pass = "AFp@DHr#";
		assertEquals(2, new ConsecutiveUppercaseLetters().occurrences(pass));
		assertEquals(new Integer(-4), new ConsecutiveUppercaseLetters().bonus(pass));
	}
	
	@Test
	public void bonus6MaiusculaInicioE2Final() {
		String pass = "DDFDFDa#$FF";
		assertEquals(6, new ConsecutiveUppercaseLetters().occurrences(pass));
		assertEquals(new Integer(-12), new ConsecutiveUppercaseLetters().bonus(pass));
	}
}
