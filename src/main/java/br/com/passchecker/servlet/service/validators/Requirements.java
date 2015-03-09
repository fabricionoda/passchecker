package br.com.passchecker.servlet.service.validators;

import br.com.passchecker.servlet.service.PassCheckable;
import br.com.passchecker.servlet.service.StrengthStatus;

public class Requirements implements PassCheckable {

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
		int quantity = new Symbols().occurrences(pass) > 0 ? 1 : 0 ;
		quantity += new Numbers().occurrences(pass)  > 0 ? 1 : 0;
		quantity += new LowercaseLetters().occurrences(pass)  > 0 ? 1 : 0;
		quantity += new UppercaseLetters().occurrences(pass)  > 0 ? 1 : 0;
		quantity += ponto8Caracteres(pass);
		
		int nMinReqChars = 0;
		if (pass.length() >= 8)  nMinReqChars = 3;  else  nMinReqChars = 4; 
		if (quantity <= nMinReqChars) {  
			return 0;
		}
		return quantity;
	}

	private int ponto8Caracteres(String pass) {
		return pass.length() >= 8 ? 1 : 0;
	}

}
