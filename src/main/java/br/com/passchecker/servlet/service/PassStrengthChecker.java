package br.com.passchecker.servlet.service;

import br.com.passchecker.servlet.service.validators.CharactersNumber;
import br.com.passchecker.servlet.service.validators.ConsecutiveLowercaseLetters;
import br.com.passchecker.servlet.service.validators.ConsecutiveNumbers;
import br.com.passchecker.servlet.service.validators.ConsecutiveUppercaseLetters;
import br.com.passchecker.servlet.service.validators.LettersOnly;
import br.com.passchecker.servlet.service.validators.LowercaseLetters;
import br.com.passchecker.servlet.service.validators.MiddleNumberOrSymbols;
import br.com.passchecker.servlet.service.validators.Numbers;
import br.com.passchecker.servlet.service.validators.NumbersOnly;
import br.com.passchecker.servlet.service.validators.RepeatCharacters;
import br.com.passchecker.servlet.service.validators.Requirements;
import br.com.passchecker.servlet.service.validators.SequentialLetters;
import br.com.passchecker.servlet.service.validators.SequentialNumbers;
import br.com.passchecker.servlet.service.validators.SequentialSymbols;
import br.com.passchecker.servlet.service.validators.Symbols;
import br.com.passchecker.servlet.service.validators.UppercaseLetters;

public class PassStrengthChecker {

	private StrengthStatus strengthStatus;

	public PassStrengthChecker(String pass) {
		StrengthStatus status = new StrengthStatus();

		new CharactersNumber().bonus(status, pass);
		new UppercaseLetters().bonus(status, pass);
		new LowercaseLetters().bonus(status, pass);
		new Numbers().bonus(status, pass);
		new Symbols().bonus(status, pass);
		new MiddleNumberOrSymbols().bonus(status, pass);
		new Requirements().bonus(status, pass);
		
		new LettersOnly().bonus(status, pass);
		new NumbersOnly().bonus(status, pass);
		new RepeatCharacters().bonus(status,pass);
		new ConsecutiveUppercaseLetters().bonus(status,pass);
		new ConsecutiveLowercaseLetters().bonus(status,pass);
		new ConsecutiveNumbers().bonus(status,pass);
		new SequentialLetters().bonus(status,pass);
		new SequentialNumbers().bonus(status,pass);
		new SequentialSymbols().bonus(status,pass);
		
		strengthStatus = status;
	}

	public String getBonusTotal() {
		if (strengthStatus.getBonusTotal() > 100)
			return "100";
		if (strengthStatus.getBonusTotal() < 0)
			return "0";
		return strengthStatus.getBonusTotal().toString();
	}

	public String getComplexity() {
		return strengthStatus.getComplexity();
	}

}
