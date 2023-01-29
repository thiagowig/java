package dev.thiagofonseca.java.spring.modulith.user.service;

import dev.thiagofonseca.java.spring.modulith.user.spi.UserSpi;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserSpi {

    public String getUser(String uuid) {
        return "My user";
    }
}
