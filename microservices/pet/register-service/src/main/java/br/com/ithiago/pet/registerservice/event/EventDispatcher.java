package br.com.ithiago.pet.registerservice.event;

import br.com.ithiago.pet.registerservice.domain.RegisterRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by thiago on 12/1/18.
 */

@Component
public class EventDispatcher {

    private RabbitTemplate rabbitTemplate;

    private String registerExchange;

    private String routingKey;

    @Autowired
    public EventDispatcher(RabbitTemplate rabbitTemplate,
                           @Value("${register.exchange}") String registerExchange,
                           @Value("${register.routing.key}") String routingKey) {

        this.rabbitTemplate = rabbitTemplate;
        this.registerExchange = registerExchange;
        this.routingKey = routingKey;
    }

    public void send(RegisterRequest request) {
        rabbitTemplate.convertAndSend(registerExchange, routingKey, request);
    }
}
