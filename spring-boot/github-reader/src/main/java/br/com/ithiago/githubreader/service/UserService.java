package br.com.ithiago.githubreader.service;

import br.com.ithiago.githubreader.component.RestClientComponent;
import br.com.ithiago.githubreader.dto.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by thiago on 4/15/19.
 */

@Service
public class UserService {

    final private RestClientComponent restClient;

    @Value("${url.github.user.details}")
    private String url;

    @Autowired
    public UserService(RestClientComponent restClient) {
        this.restClient = restClient;
    }

    public UserInfoDTO getUserInformation(String userName) {
        String formatedUrl = String.format(url, userName);

        return (UserInfoDTO) restClient.executeGetCall(formatedUrl, UserInfoDTO.class);
    }
}
