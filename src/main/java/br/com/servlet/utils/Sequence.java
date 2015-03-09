package br.com.servlet.utils;


public enum Sequence {
	
	ALPHABET("abcdefghijklmnopqrstuvwxyz"),
	NUMBER("01234567890"),
	SYMBOLS(")!@#$%^&*()");
	
    private final String sequence;
    
	private Sequence(String sequence) {
		this.sequence = sequence;
	}
	
    public String toString() {
		return sequence;
	}
}
