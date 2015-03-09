package br.com.passchecker.servlet.service.validators;

import br.com.passchecker.servlet.service.PassCheckable;
import br.com.passchecker.servlet.service.StrengthStatus;
import br.com.servlet.utils.RegexUtils;

public class LettersOnly implements PassCheckable {

	@Override
	public Integer bonus(String pass) {
		return occurrences(pass) * -1;
	}

	@Override
	public void bonus(StrengthStatus status, String pass) {
		status.addBonus(bonus(pass));
	}

	@Override
	public int occurrences(String pass) {
		if (RegexUtils.match(pass, "[a-zA-Z]+\\.?"))
			return pass.length();
		return 0;
	}

}
