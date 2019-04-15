package br.com.ithiago.springtesting.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

    private RestTemplate restTemplate;

    @Value("${api.github.path}")
    private String url;

    public ProductService(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public ResponseEntity<String> doSomething() {
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        return response;
    }
}
