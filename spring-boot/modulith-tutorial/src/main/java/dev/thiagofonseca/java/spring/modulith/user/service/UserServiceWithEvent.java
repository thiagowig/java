package dev.thiagofonseca.java.spring.modulith.user.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
public class UserServiceWithEvent {

    @Async
    @TransactionalEventListener
    public void on(String uuid) {
        System.out.println(this.getClass().getName() + " " + uuid);
    }
}
