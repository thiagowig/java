package br.com.ithiago.crypt.challenger;

import com.mifmif.common.regex.Generex;

public class RegexGenerator {
	
	private Generex generex;

	public RegexGenerator(String regex) {
		this.generex = new Generex(regex);
	}
	
	public String generate(int beginIndex, int length) {
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < length; i++) {
			String caracter = this.generex.getMatchedString(i + beginIndex);
			result.append(caracter);
		}
		
		return result.toString();
	}
}
