package br.com.ithiago.springtesting.service;

import br.com.ithiago.springtesting.component.ClientComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientComponent clientComponent;

    public String doSomething() {
        return clientComponent.doSomething();
    }
}
