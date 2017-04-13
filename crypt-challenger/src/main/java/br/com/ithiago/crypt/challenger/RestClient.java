package br.com.ithiago.crypt.challenger;

import java.util.Map;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.ithiago.crypt.challenger.model.Response;

public class RestClient {
	
	private String url;
	
	private Client client;
	
	public RestClient(String url) {
		this.url = url;
		client = Client.create();
	}
	
	public Response call(Map<String, String> queryParamsMap) {
		String paramPattern = "%s=%s&";
		StringBuilder queryParams = new StringBuilder();
		
		for (Map.Entry<String, String> param : queryParamsMap.entrySet()) {
			queryParams.append(String.format(paramPattern, param.getKey(), param.getValue()));
		}
		
		queryParams = new StringBuilder(queryParams.substring(0, queryParams.length() - 1));
		
		WebResource resource = client.resource(String.format(url + "?" +  queryParams));
		ClientResponse response = resource.accept("application/json").get(ClientResponse.class);
		
		int responseStatus = response.getStatus();
		String responseBody = response.getEntity(String.class);
		
		return new Response(responseStatus, responseBody);
	}
}
