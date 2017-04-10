package br.com.ithiago.crypt.challenger;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class APICall {
	
	private String url;
	
	public APICall(String url) {
		this.url = url;
	}

	
	public String call(String coder, Boolean test, String challenge) {
		Client client = Client.create();
		
		WebResource resource = client.resource(String.format(url + "?coder=%s&test=%s&challenge=%s", coder, test.toString(), challenge));
		ClientResponse response = resource.accept("application/json").get(ClientResponse.class);
		
		return response.getEntity(String.class);
	}
}
