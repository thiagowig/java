package br.com.ithiago.crypt.challenger;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class StringGeneratorTest {
	
	private static final String regex = "[a-zA-Z0-9_=]";
	
	private static StringGenerator stringGenerator;
	
	@BeforeClass
	public static void setup() {
		stringGenerator = new StringGenerator(regex);
	}
	
	@Test
	public void shoudTest() {
		String expectedResult = "0123456789=ABCDEFGHIJKLMNOPQRSTUVWX";
		String result = stringGenerator.get(1, 35);
		
		Assert.assertEquals(expectedResult, result);
	}
	
	@Test
	public void shoudTest02() {
		String expectedResult = "YZ_abcdefghijklmnopqrstuvwxyz";
		String result = stringGenerator.get(36, 35);
		
		Assert.assertEquals(expectedResult, result);
	}

}
