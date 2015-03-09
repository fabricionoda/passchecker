package br.com.passchecker.servlet.service.validators;

import br.com.passchecker.servlet.service.PassCheckable;
import br.com.passchecker.servlet.service.StrengthStatus;
import br.com.servlet.utils.RegexUtils;

public class Symbols implements PassCheckable {

	private static final String ONLY_ALPHANUMERIC = "[a-zA-Z0-9.]*";

	@Override
	public Integer bonus(String pass) {
        return occurrences(pass) * 6;
	}	

	@Override
	public void bonus(StrengthStatus status, String pass) {
		status.addBonus(bonus(pass));		
	}
	
	public int occurrences(String pass){
		return pass.length() - RegexUtils.occurrences(pass, ONLY_ALPHANUMERIC);
	}

}
