package br.com.passchecker.servlet.service.validators;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ConsecutiveNumbersTest {

	ConsecutiveNumbers consecutiveNumber;
	
	@Before
	public void setUp(){
		consecutiveNumber = new ConsecutiveNumbers();
	}
	
	@Test
	public void grupoNumerosNoMeioENoFim() {
		String pass = "D47%T16";
		assertEquals(2, consecutiveNumber.occurrences(pass));
		assertEquals(new Integer(-4), consecutiveNumber.bonus(pass));
	}
	
	@Test
	public void bonusInicioEFimCom3NumerosConsecutivos() {
		String pass = "471F283";
		assertEquals(4, consecutiveNumber.occurrences(pass));
		assertEquals(new Integer(-8), consecutiveNumber.bonus(pass));
	}

}
