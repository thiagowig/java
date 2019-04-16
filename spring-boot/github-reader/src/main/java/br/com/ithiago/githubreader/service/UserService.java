package br.com.ithiago.githubreader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Created by thiago on 4/15/19.
 */

@Service
public class UserService {

    final private RestClient restClient;

    final private String url;

    @Autowired
    public UserService(RestClient restClient, @Value("${url.github.user.details}") String url) {
        this.restClient = restClient;
        this.url = url;
    }

    public ResponseEntity<String> getUserInformation(String userName) {
        String formatedUrl = String.format(url, userName);

        return restClient.callGet(formatedUrl);
    }
}
