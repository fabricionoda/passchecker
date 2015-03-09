package br.com.passchecker.servlet.service;

public class StrengthStatus {
	private Integer bonus = 0;
	public String getComplexity() {
		return Complexity.fromStrength(getBonusTotal()).toString();		
	}
	public Integer getBonusTotal() {
		return bonus;
	}
	public void addBonus(Integer bonus) {
		this.bonus = this.bonus + bonus;
	}	
}
