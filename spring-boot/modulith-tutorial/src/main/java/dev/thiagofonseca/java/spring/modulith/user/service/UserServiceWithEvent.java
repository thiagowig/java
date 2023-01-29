package dev.thiagofonseca.java.spring.modulith.user.service;

import org.springframework.modulith.ApplicationModuleListener;
import org.springframework.stereotype.Service;

@Service
public class UserServiceWithEvent {

    @ApplicationModuleListener
    public void on(String uuid) {
        
    }
}
