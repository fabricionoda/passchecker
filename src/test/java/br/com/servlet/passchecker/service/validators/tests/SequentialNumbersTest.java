package br.com.servlet.passchecker.service.validators.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.passchecker.servlet.service.validators.SequentialNumbers;

public class SequentialNumbersTest {

	SequentialNumbers sequentialNumbers;
	
	@Before
	public void setUp(){
		sequentialNumbers = new SequentialNumbers();
	}
	
	@Test
	public void sequenceMatches() {
		String pass = "1234Tfsr";		
		assertEquals(2, sequentialNumbers.occurrences(pass));
		assertEquals(new Integer(-6), sequentialNumbers.bonus(pass));
	}
	
	@Test
	public void sequenceMatchesDontCountMiddle() {		
		String pass = "1234T278dw";		
		assertEquals(2, sequentialNumbers.occurrences(pass));
		assertEquals(new Integer(-6), sequentialNumbers.bonus(pass));
	}
	
	@Test
	public void sequenceMatchesDontCountMiddleButEnd() {
		String pass = "T2kl346789";		
		assertEquals(2, sequentialNumbers.occurrences(pass));
		assertEquals(new Integer(-6), sequentialNumbers.bonus(pass));
	}

}
