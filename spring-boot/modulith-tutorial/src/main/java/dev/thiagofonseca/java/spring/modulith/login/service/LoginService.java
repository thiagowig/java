package dev.thiagofonseca.java.spring.modulith.login.service;

import dev.thiagofonseca.java.spring.modulith.user.spi.UserSpi;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private UserSpi user;

    public LoginService(UserSpi user) {
        this.user = user;
    }

    public boolean authenticate() {
        return user.getUser("123") != null;
    }
}
