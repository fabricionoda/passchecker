package br.com.passchecker.servlet.service.validators;

import br.com.passchecker.servlet.service.PassCheckable;
import br.com.passchecker.servlet.service.StrengthStatus;

public class CharactersNumber implements PassCheckable {
	
	@Override
	public Integer bonus(String pass) {		
		return occurrences(pass)*4;
	}

	@Override
	public void bonus(StrengthStatus status, String pass) {
		status.addBonus(bonus(pass));		
	}

	@Override
	public int occurrences(String pass) {
		return pass.length();
	}

}
