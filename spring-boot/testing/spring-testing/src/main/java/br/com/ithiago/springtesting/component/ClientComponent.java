package br.com.ithiago.springtesting.component;

import br.com.ithiago.springtesting.exception.ClientNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class ClientComponent {

    public void doSomething() {
        throw new ClientNotFoundException("Client not founded");
    }
}
