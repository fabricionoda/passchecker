package br.com.passchecker.servlet.service.validators;

import br.com.passchecker.servlet.service.PassCheckable;
import br.com.passchecker.servlet.service.StrengthStatus;
import br.com.servlet.utils.RegexUtils;

public class Numbers implements PassCheckable {

	private static final String NUMBERS = "[0-9]+";

	@Override
	public Integer bonus(String pass) {
		return occurrences(pass) * 4;
	}

	@Override
	public void bonus(StrengthStatus status, String pass) {
		status.addBonus(bonus(pass));
	}

	public int occurrences(String pass) {
		return RegexUtils.occurrences(pass, NUMBERS);
	}

}
