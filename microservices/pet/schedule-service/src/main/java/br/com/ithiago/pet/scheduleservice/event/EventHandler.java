package br.com.ithiago.pet.scheduleservice.event;

import br.com.ithiago.pet.scheduleservice.domain.RegisterRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by thiago on 12/2/18.
 */
@Component
@Slf4j
public class EventHandler {

    @RabbitListener(queues = "${multiplication.queue}")
    void handleMultiplicationSolved(RegisterRequest event) {
        log.info("Multiplication Solved Event received: {}", event.toString());

    }
}
