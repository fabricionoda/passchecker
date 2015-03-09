package br.com.passchecker.servlet.service;

public interface PassCheckable {
	Integer bonus(String pass);
	void bonus(StrengthStatus status, String pass);
	int occurrences(String pass);
}
