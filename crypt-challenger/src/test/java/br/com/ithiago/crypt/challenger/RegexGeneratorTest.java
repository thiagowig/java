package br.com.ithiago.crypt.challenger;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class RegexGeneratorTest {
	
	private static final String regex = "[a-zA-Z0-9_=]";
	
	private static RegexGenerator stringGenerator;
	
	@BeforeClass
	public static void setup() {
		stringGenerator = new RegexGenerator(regex);
	}
	
	@Test
	public void shoudGenerateInitialRegex() {
		String expectedResult = "0123456789=ABCDEFGHIJKLMNOPQRSTUVWX";
		assertRegex(expectedResult, 1, 35);
	}
	
	@Test
	public void shoudGenerateFinalRegex() {
		String expectedResult = "YZ_abcdefghijklmnopqrstuvwxyz";
		assertRegex(expectedResult, 36, 35);
	}
	
	private void assertRegex(String expectedResult, int beginIndex, int length) {
		String result = stringGenerator.generate(beginIndex, length);
		
		Assert.assertEquals(expectedResult, result);
	}

}
