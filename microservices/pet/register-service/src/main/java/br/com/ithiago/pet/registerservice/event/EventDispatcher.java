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

    // The exchange to use to send anything related to Multiplication
    private String multiplicationExchange;

    // The routing key to use to send this particular event
    private String multiplicationSolvedRoutingKey;

    @Autowired
    EventDispatcher(final RabbitTemplate rabbitTemplate,
                    @Value("${multiplication.exchange}") final String multiplicationExchange,
                    @Value("${multiplication.solved.key}") final String multiplicationSolvedRoutingKey) {
        this.rabbitTemplate = rabbitTemplate;
        this.multiplicationExchange = multiplicationExchange;
        this.multiplicationSolvedRoutingKey = multiplicationSolvedRoutingKey;
    }

    public void send(final RegisterRequest event) {
        rabbitTemplate.convertAndSend(
                multiplicationExchange,
                multiplicationSolvedRoutingKey,
                event);
    }

}
