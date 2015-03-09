package br.com.passchecker.servlet;

import br.com.passchecker.servlet.service.PassStrengthChecker;

public class PassStrengthResponse {
	@SuppressWarnings("unused")
	private String percentage = "[]";
	@SuppressWarnings("unused")
	private String description = "[]";
	
	PassStrengthResponse(String pass){
		PassStrengthChecker checker = new PassStrengthChecker(pass);
		percentage = checker.getBonusTotal();
		description = checker.getComplexity();
	}
}
