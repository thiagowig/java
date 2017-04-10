package br.com.ithiago.crypt.challenger;

/**
 * Hello world!
 *
 */
public class App {
	
	public static void main(String[] args) {	
		APICall apiCall = new APICall("https://ac-challenge.herokuapp.com/api/challenge");
		Integer size = Integer.valueOf(apiCall.call("thiago@bol.com.br", true, ""));
		
		System.out.println(size);
		
		String regex = "[a-zA-Z0-9_=]";
		
		StringGenerator stringGenerator = new StringGenerator(regex);
		
		boolean founded = false;
		
		
		
		String[] decodedString = new String[size];
		
		do {
			String challenge = stringGenerator.get(0, size);
			
		} while (!founded);
		
		
		System.out.println(decodedString);
	}
}
