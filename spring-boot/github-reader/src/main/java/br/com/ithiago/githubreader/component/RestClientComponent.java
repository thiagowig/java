package br.com.ithiago.githubreader.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClientComponent {

    final private RestTemplate restTemplate;

    @Autowired
    public RestClientComponent(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public Object executeGetCall(String url, Class responseClass) {
        return this.restTemplate.getForObject(url, responseClass);
    }

    public Object executePostCall(String url, Object body, Class responseClass) {
        return this.restTemplate.postForObject(url, body, responseClass);
    }

}
