package br.com.passchecker.servlet.service.validators;

import br.com.passchecker.servlet.service.PassCheckable;
import br.com.passchecker.servlet.service.StrengthStatus;
import br.com.servlet.utils.RegexUtils;

public class UppercaseLetters implements PassCheckable {

	@Override
	public Integer bonus(String pass) {
		int occurrences = occurrences(pass);
		if (occurrences == 0)
			return 0;
        return (pass.length() - occurrences) * 2;
	}

	@Override
	public void bonus(StrengthStatus status, String pass) {
		status.addBonus(bonus(pass));		
	}

	@Override
	public int occurrences(String pass) {
		return  RegexUtils.occurrences(pass, "[A-Z]+");
	}
}
