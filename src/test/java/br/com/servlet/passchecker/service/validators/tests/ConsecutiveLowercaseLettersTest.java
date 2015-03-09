package br.com.servlet.passchecker.service.validators.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.passchecker.servlet.service.validators.ConsecutiveLowercaseLetters;

public class ConsecutiveLowercaseLettersTest {
	
	ConsecutiveLowercaseLetters consecutiveLowercaseLetters;
	
	@Before
	public void setUp(){
		consecutiveLowercaseLetters = new ConsecutiveLowercaseLetters();
	}
	
	@Test
	public void bonus2MinusculasConsecutivasNoFinal() {
		String pass = "Fsr";
		assertEquals(1, consecutiveLowercaseLetters.occurrences(pass));
		assertEquals(new Integer(-2), consecutiveLowercaseLetters.bonus(pass));
	}
	
	@Test
	public void bonus3MinusculasConsecutivasNoFinal() {
		String pass = "Fsrw";
		assertEquals(2, consecutiveLowercaseLetters.occurrences(pass));
		assertEquals(new Integer(-4), consecutiveLowercaseLetters.bonus(pass));
	}

	@Test
	public void bonus3MinusculasConsecutivasNoInicio() {
		String pass = "dasDF3Dsr#";
		assertEquals(3, consecutiveLowercaseLetters.occurrences(pass));
		assertEquals(new Integer(-6), consecutiveLowercaseLetters.bonus(pass));
	}
	
	@Test
	public void grupoMinusculosNoMeioENoFim() {
		String pass = "Dre%Tef";
		assertEquals(2, consecutiveLowercaseLetters.occurrences(pass));
		assertEquals(new Integer(-4), consecutiveLowercaseLetters.bonus(pass));
	}
	
	@Test
	public void bonusInicioEFimCom3MinusculasConsecutivas() {
		String pass = "fasFsrw";
		assertEquals(4, consecutiveLowercaseLetters.occurrences(pass));
		assertEquals(new Integer(-8), consecutiveLowercaseLetters.bonus(pass));
	}
	
	@Test
	public void bonusInicioE3MinusculasConsecutivasNoFinal() {
		String pass = "fasdfeFsrw";
		assertEquals(7, consecutiveLowercaseLetters.occurrences(pass));
		assertEquals(new Integer(-14), consecutiveLowercaseLetters.bonus(pass));
	}
}
