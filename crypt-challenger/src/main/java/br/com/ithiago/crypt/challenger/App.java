package br.com.ithiago.crypt.challenger;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * Hello world!
 *
 */
public class App {
	
	public static void main(String[] args) {	
		APICall apiCall = new APICall("https://ac-challenge.herokuapp.com/api/challenge");
		Integer size = Integer.valueOf(apiCall.call("dev.thiago@gmail.com", true, ""));
		
		System.out.println(size);
		
		String regex = "[a-zA-Z0-9_=]";
		
		StringGenerator stringGenerator = new StringGenerator(regex);
		
		boolean founded = false;
		
		
		List<String> exists = new ArrayList<String>(); 
		char[] decodedString = new char[size];
		int current = 0;
		
		String challenge = null;
		do {
			challenge = stringGenerator.get(current, size);
			
			if (!challenge.equals("")) {
				challenge = StringUtils.rightPad(challenge, size, '*');
				System.out.println("Challenge\n" + challenge);
				
				
				String result = apiCall.call("dev.thiago@gmail.com", true, challenge);
				
				System.out.println("Result\n" + result);
				
				for (int i = 0; i < result.length(); i++) {
					char character = result.charAt(i);
					if (character == 'R' || character == 'U') {
						exists.add(String.valueOf(challenge.charAt(i)));
					}
				}
				
				current += size;
			}			
			
		} while (!challenge.equals(""));
		
		for (String string : exists) {
			challenge = StringUtils.rightPad("", size, string);
			
			String result = apiCall.call("dev.thiago@gmail.com", true, challenge);
			for (int i = 0; i < result.length(); i++) {
				char character = result.charAt(i);
				if (character == 'R') {
					decodedString[i] = challenge.charAt(i);
				}
			}
		}
		
		
		System.out.println("Decoded\n" + decodedString);
		
		System.out.println("Exists\n" + exists);
	}
}
