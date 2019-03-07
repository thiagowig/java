package br.com.ithiago.pet.scheduleservice.event;

import br.com.ithiago.pet.scheduleservice.domain.RegisterRequest;
import br.com.ithiago.pet.scheduleservice.service.PerTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by thiago on 12/2/18.
 */
@Component
@Slf4j
public class EventHandler {

    private PerTaskService service;

    @Autowired
    public EventHandler(PerTaskService service) {
        this.service = service;
    }

    @RabbitListener(queues = "${multiplication.queue}")
    void handleMultiplicationSolved(RegisterRequest event) {
        log.info("Multiplication Solved Event received: {}", event.toString());
        this.service.insertRegister(event);
    }
}
