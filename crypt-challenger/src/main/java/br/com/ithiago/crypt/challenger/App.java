package br.com.ithiago.crypt.challenger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import br.com.ithiago.crypt.challenger.model.Response;

/**
 * dev.thiago@gmail.com
 *
 */
public class App {

	private static final String URL = "https://ac-challenge.herokuapp.com/api/challenge";

	private static final String CODER = "dev.thiago@gmail.com";

	private static final String REGEX = "[a-zA-Z0-9_=]";

	private RestClient restClient;

	private Response response;

	public App() {
		restClient = new RestClient(URL);
	}

	private void executeChallenge() {
		Integer challengeSize = getChallengeSize();
		List<String> validChars = getValidChars(challengeSize);
		String decodedString = decodeString(challengeSize, validChars);

		response = restClient.call(createQueryParams(CODER, false, decodedString));

		System.out.println("Final Result: " + response.getContent());
	}

	private int getChallengeSize() {
		response = restClient.call(createQueryParams(CODER, true, StringUtils.EMPTY));
		return Integer.valueOf(response.getContent());
	}

	private List<String> getValidChars(int size) {
		RegexGenerator regexGenerator = new RegexGenerator(REGEX);
		List<String> validChars = new ArrayList<String>();
		int currentIndex = 0;
		String challenge;

		do {
			challenge = regexGenerator.generate(currentIndex, size);

			if (!challenge.equals(StringUtils.EMPTY)) {
				challenge = StringUtils.rightPad(challenge, size, '*');
				response = restClient.call(createQueryParams(CODER, true, challenge));

				for (int i = 0; i < response.getContent().length(); i++) {
					char character = response.getContent().charAt(i);
					if (isValidChar(character)) {
						validChars.add(String.valueOf(challenge.charAt(i)));
					}
				}

				currentIndex += size;
			}

		} while (!challenge.equals(StringUtils.EMPTY));

		return validChars;
	}

	private boolean isValidChar(char character) {
		return character == ResponseEnum.R.getCharName() || character == ResponseEnum.U.getCharName();
	}

	private String decodeString(Integer size, List<String> exists) {
		char[] decodedString = new char[size];
		
		for (String string : exists) {
			String challenge = StringUtils.rightPad(StringUtils.EMPTY, size, string);
			response = restClient.call(createQueryParams(CODER, true, challenge));
			
			for (int i = 0; i < response.getContent().length(); i++) {
				char character = response.getContent().charAt(i);
				if (character == ResponseEnum.R.getCharName()) {
					decodedString[i] = challenge.charAt(i);
				}
			}
		}

		StringBuilder decoded = new StringBuilder();

		for (char c : decodedString) {
			decoded.append(c);
		}
		
		return decoded.toString();
	}

	private Map<String, String> createQueryParams(String coder, Boolean test, String challenge) {
		Map<String, String> queryParams = new HashMap<String, String>();

		queryParams.put("coder", coder);
		queryParams.put("test", test.toString());
		queryParams.put("challenge", challenge);

		return queryParams;
	}

	public static void main(String[] args) {
		App app = new App();

		app.executeChallenge();
	}
}
