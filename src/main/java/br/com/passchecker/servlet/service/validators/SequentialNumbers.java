package br.com.passchecker.servlet.service.validators;

import br.com.passchecker.servlet.service.PassCheckable;
import br.com.passchecker.servlet.service.StrengthStatus;
import br.com.servlet.utils.RegexUtils;
import br.com.servlet.utils.Sequence;

public class SequentialNumbers implements PassCheckable {

	@Override
	public Integer bonus(String pass) {
		return -(occurrences(pass) * 3);
	}

	@Override
	public void bonus(StrengthStatus status, String pass) {
		status.addBonus(bonus(pass));		
	}

	@Override
	public int occurrences(String pass) {
		return RegexUtils.sequenceMatches(pass, Sequence.NUMBER);
	}
}
