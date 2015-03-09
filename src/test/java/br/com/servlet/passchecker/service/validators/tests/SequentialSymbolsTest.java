package br.com.servlet.passchecker.service.validators.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.passchecker.servlet.service.validators.SequentialSymbols;

public class SequentialSymbolsTest {

	SequentialSymbols sequentialSymbols;
	
	@Before
	public void setUp(){
		sequentialSymbols = new SequentialSymbols();
	}
	
	@Test
	public void sequenceMatches() {
		String pass = ")!@#$%^&*()";		
		assertEquals(8, sequentialSymbols.occurrences(pass));
		assertEquals(new Integer(-24), sequentialSymbols.bonus(pass));
	}
	
	@Test
	public void sequenceMatchesDontCountMiddle() {		
		String pass = "#$%^T2&*dw";		
		assertEquals(2, sequentialSymbols.occurrences(pass));
		assertEquals(new Integer(-6), sequentialSymbols.bonus(pass));
	}
	
	@Test
	public void sequenceMatchesDontCountMiddleButEnd() {
		String pass = "T2k@#4&*()";		
		assertEquals(1, sequentialSymbols.occurrences(pass));
		assertEquals(new Integer(-3), sequentialSymbols.bonus(pass));
	}
}
