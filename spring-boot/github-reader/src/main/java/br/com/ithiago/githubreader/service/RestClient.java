package br.com.ithiago.githubreader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by thiago on 4/15/19.
 */
@Component
public class RestClient {

    final private RestTemplate restTemplate;

    @Autowired
    public RestClient(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public ResponseEntity<String> callGet(String url) {
        return this.restTemplate.getForEntity(url, String.class);
    }

}
