package br.com.ithiago.pet.scheduleservice.event;

import br.com.ithiago.pet.scheduleservice.domain.RegisterRequest;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by thiago on 12/2/18.
 */
@Component
public class EventHandler {

    @RabbitListener
    public void handleEvent(RegisterRequest event) {
        System.out.println(event);
    }
}
