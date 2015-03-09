package br.com.servlet.passchecker.service.validators.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.passchecker.servlet.service.validators.SequentialLetters;

public class SequentialLettersTest {

	SequentialLetters sequentialLetters;
	
	@Before
	public void setUp(){
		sequentialLetters = new SequentialLetters();
	}
	
	@Test
	public void sequenceMatchesAlpha() {
		String pass = "abcdefghijklmnopqrstuvwxyz";		
		assertEquals(23, sequentialLetters.occurrences(pass));
		assertEquals(new Integer(-69), sequentialLetters.bonus(pass));
	}
	
	@Test
	public void sequenceMatches() {
		String pass = "abcdT234";		
		assertEquals(2, sequentialLetters.occurrences(pass));
		assertEquals(new Integer(-6), sequentialLetters.bonus(pass));
	}
	
	@Test
	public void sequenceMatchesDontCountMiddle() {		
		String pass = "abcdT2kl34";		
		assertEquals(2, sequentialLetters.occurrences(pass));
		assertEquals(new Integer(-6), sequentialLetters.bonus(pass));
	}
	
	@Test
	public void sequenceMatchesDontCountMiddleButEnd() {
		String pass = "T2kl34ABCD";		
		assertEquals(2, sequentialLetters.occurrences(pass));
		assertEquals(new Integer(-6), sequentialLetters.bonus(pass));
	}
}
