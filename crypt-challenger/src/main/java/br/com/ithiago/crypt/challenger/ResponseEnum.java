package br.com.ithiago.crypt.challenger;

public enum ResponseEnum {

	R('R'), 
	U('U'), 
	W('W');
	
	private char character;
	
	private ResponseEnum(char character) {
		this.character = character;
	}
	
	public char getCharName() {
		return this.character;
	}
}
