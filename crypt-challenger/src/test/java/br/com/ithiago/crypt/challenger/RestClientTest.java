package br.com.ithiago.crypt.challenger;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.ithiago.crypt.challenger.model.Response;

public class RestClientTest {

	private RestClient restClient;
	
	@Before
	public void setup() {
		restClient = new RestClient("https://ac-challenge.herokuapp.com/api/challenge");
	}
	
	@Test
	public void shouldGetTheChallengeSize() {
		Map<String, String> queryParams = new HashMap<String, String>();
		queryParams.put("coder", "dev.thiago@gmail.com");
		queryParams.put("test", "true");
		queryParams.put("challenge", StringUtils.EMPTY);
		
		Response response = restClient.call(queryParams);
		
		Assert.assertEquals(response.getStatus(), 409);
		Assert.assertEquals(response.getContent(), "34");
	}
}
