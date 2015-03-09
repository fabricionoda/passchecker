package br.com.servlet.passchecker.service.tests;

import org.junit.Assert;
import org.junit.Test;

import br.com.passchecker.servlet.service.PassStrengthChecker;

public class PassStrengthCheckerTest {

	@Test
	public void senhaCom8CaracteresPontosPositivosDeveValer94() {
		Assert.assertEquals("94",
				new PassStrengthChecker("f#4@A5tS").getBonusTotal());
	}

	@Test
	public void senhaComForca100s() {
		Assert.assertEquals("100",
				new PassStrengthChecker("3#f5T&3Rs").getBonusTotal());
	}

	@Test
	public void senhaComSomenteLetrasDeveValer8() {
		Assert.assertEquals("8",
				new PassStrengthChecker("ahejks").getBonusTotal());
	}

	@Test
	public void senhaComSomenteLetrasMaiusculasEMinusculasDeveValer8() {
		Assert.assertEquals("28",
				new PassStrengthChecker("aHejKs").getBonusTotal());
	}

	@Test
	public void caracteresRepetidos() {
		Assert.assertEquals("36",
				new PassStrengthChecker("aa3AA333").getBonusTotal());
	}

	@Test
	public void consecutiveUpperCase() {
		Assert.assertEquals("12",
				new PassStrengthChecker("JSUEODPFMV").getBonusTotal());
	}

	@Test
	public void consecutiveLowerCase() {
		Assert.assertEquals("13",
				new PassStrengthChecker("uepwpaldncml").getBonusTotal());
	}

	@Test
	public void sequentialLetters() {
		Assert.assertEquals("0",
				new PassStrengthChecker("abcijkl").getBonusTotal());
		Assert.assertEquals("2",
				new PassStrengthChecker("abcijk").getBonusTotal());
	}
	
	@Test
	public void sequentialNumbers() {
		Assert.assertEquals("0",
				new PassStrengthChecker("abcijkl").getBonusTotal());
		Assert.assertEquals("2",
				new PassStrengthChecker("abcijk").getBonusTotal());
	}
	
	@Test
	public void sequentialSymbols() {
		Assert.assertEquals("0",
				new PassStrengthChecker("abcijkl").getBonusTotal());
		Assert.assertEquals("2",
				new PassStrengthChecker("abcijk").getBonusTotal());
	}

}
