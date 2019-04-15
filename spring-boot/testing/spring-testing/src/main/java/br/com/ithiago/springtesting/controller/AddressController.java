package br.com.ithiago.springtesting.controller;

import br.com.ithiago.springtesting.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/address")
    public String doSomething() {
        return clientService.doSomething();
    }
}
