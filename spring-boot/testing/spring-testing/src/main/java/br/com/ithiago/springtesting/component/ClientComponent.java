package br.com.ithiago.springtesting.component;

import org.springframework.stereotype.Component;

@Component
public class ClientComponent {

    public String doSomething() {
        return "This is a client";
    }
}
