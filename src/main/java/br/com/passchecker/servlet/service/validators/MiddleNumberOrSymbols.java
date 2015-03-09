package br.com.passchecker.servlet.service.validators;

import br.com.passchecker.servlet.service.PassCheckable;
import br.com.passchecker.servlet.service.StrengthStatus;

public class MiddleNumberOrSymbols implements PassCheckable {

	@Override
	public Integer bonus(String pass) {
		return occurrences(pass) * 2;
	}

	@Override
	public void bonus(StrengthStatus status, String pass) {
		status.addBonus(bonus(pass));
	}

	@Override
	public int occurrences(String pass) {
		if (pass.length() < 3)
			return 0;
		String substring = pass.substring(1,pass.length() - 1);
		int quantity = new Symbols().occurrences(substring);
		quantity += new Numbers().occurrences(substring);
		return quantity;
	}

}
