package br.com.ithiago.pet.registerservice.service;

import br.com.ithiago.pet.registerservice.domain.RegisterRequest;
import br.com.ithiago.pet.registerservice.domain.RegisterResponse;
import br.com.ithiago.pet.registerservice.event.EventDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thiago on 12/1/18.
 */
@Service
public class RegisterService {

    private EventDispatcher eventDispatcher;

    private List<RegisterRequest> registerList = new ArrayList<>();

    @Autowired
    public RegisterService(EventDispatcher eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
    }

    public RegisterResponse registerUser(RegisterRequest request) {
        registerList.add(request);

        eventDispatcher.send(request);

        return new RegisterResponse("Great Success");
    }

}
