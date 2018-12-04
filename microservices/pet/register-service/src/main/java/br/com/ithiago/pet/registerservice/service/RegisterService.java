package br.com.ithiago.pet.registerservice.service;

import br.com.ithiago.pet.registerservice.domain.RegisterRequest;
import br.com.ithiago.pet.registerservice.domain.RegisterResponse;
import br.com.ithiago.pet.registerservice.event.EventDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thiago on 12/1/18.
 */
@Service
public class RegisterService {

    private EventDispatcher eventDispatcher;

    private RestTemplate restTemplate;

    private String scheduleHost;

    private List<RegisterRequest> registerList = new ArrayList<>();

    @Autowired
    public RegisterService(EventDispatcher eventDispatcher, RestTemplate restTemplate,
                           @Value("${scheduleHost}") String scheduleHost) {
        this.eventDispatcher = eventDispatcher;
        this.restTemplate = restTemplate;
        this.scheduleHost = scheduleHost;
    }

    public RegisterResponse registerUser(RegisterRequest request) {
        registerList.add(request);

        eventDispatcher.send(request);

        return new RegisterResponse("Great Success");
    }

    public List<RegisterResponse> getAllRegisters() {
        return restTemplate.getForObject(scheduleHost + "/services/list", List.class);
    }
}
