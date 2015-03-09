package br.com.servlet.passchecker.service.validators.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.passchecker.servlet.service.validators.NumbersOnly;
import br.com.passchecker.servlet.service.validators.RepeatCharacters;

public class RepeatCharactersTest {

	@Test
	public void dado0CaracteresDeveRetornar0() {
		assertEquals(new Integer(0), new NumbersOnly().bonus(""));
	}
	
	@Test
	public void repeticaoDoisCaracteres() {
		assertEquals(4, new RepeatCharacters().occurrences("abab"));
	}

	@Test
	public void repeticaoDoisCaracteresMaisUmDiferente() {
		assertEquals(4, new RepeatCharacters().occurrences("ababc"));
	}
	
	@Test
	public void ocorrenciasRepeticao7CaracateresMaisUmDiferente() {
		assertEquals(7, new RepeatCharacters().occurrences("ababcccd"));
	}
	
	@Test
	public void bonusRepetitcao7CaracateresMaisUmDiferente() {
		assertEquals(new Integer(-5), new RepeatCharacters().bonus("aab"));
	}
	
	@Test
	public void bonusRepetitcao4CaracateresComUmaRepeticao() {
		String pass = "sdfd";
		assertEquals(2, new RepeatCharacters().occurrences(pass));
		assertEquals(new Integer(-2), new RepeatCharacters().bonus(pass));
	}
	
	@Test
	public void bonusRepetitcao9CaracateresComSomenteUmDiferente() {
		String pass = "sdfdddddf";
		assertEquals(8, new RepeatCharacters().occurrences(pass));
		assertEquals(new Integer(-19), new RepeatCharacters().bonus(pass));
	}

}
