package br.com.ithiago.wiremockstubing.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by thiago on 4/21/19.
 */
@Service
public class UserService {

    private RestTemplate restTemplate;

    @Value("${api.github.path}")
    private String url;

    public UserService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public String getUserInformation() {
        return restTemplate.getForObject(url, String.class);
    }
}
