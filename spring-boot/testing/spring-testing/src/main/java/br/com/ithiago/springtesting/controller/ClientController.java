package br.com.ithiago.springtesting.controller;

import br.com.ithiago.springtesting.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/client")
    public String get() {
        clientService.doSomething();

        return "This is a client";
    }
}
