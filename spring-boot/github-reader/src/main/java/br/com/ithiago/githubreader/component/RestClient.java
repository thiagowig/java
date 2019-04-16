package br.com.ithiago.githubreader.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClient {

    final private RestTemplate restTemplate;

    @Autowired
    public RestClient(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public Object executeGetCall(String url, Class responseClass) {
        return this.restTemplate.getForObject(url, responseClass);
    }

}
