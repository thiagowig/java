package br.com.ithiago.crypt.challenger;

import com.mifmif.common.regex.Generex;

public class StringGenerator {
	
	private Generex generex;

	public StringGenerator(String regex) {
		this.generex = new Generex(regex);
	}
	
	public String get(int beginIndex, int length) {
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < length; i++) {
			String caracter = this.generex.getMatchedString(i + beginIndex);
			result.append(caracter);
		}
		
		return result.toString();
	}
}
