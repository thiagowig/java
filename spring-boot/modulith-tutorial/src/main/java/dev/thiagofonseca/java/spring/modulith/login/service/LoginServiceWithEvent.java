package dev.thiagofonseca.java.spring.modulith.login.service;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginServiceWithEvent {

    private final ApplicationEventPublisher events;

    public LoginServiceWithEvent(ApplicationEventPublisher events) {
        this.events = events;
    }

    @Transactional
    public void login(String uuid) {
        events.publishEvent(uuid);
        System.out.println("Sync or Async?");
    }
}
