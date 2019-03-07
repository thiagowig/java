package br.com.ithiago.controller;

import br.com.ithiago.model.Client;
import br.com.ithiago.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by thiago on 12/30/18.
 */

@RestController
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/client/create")
    public String createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @GetMapping("client/all")
    public List<Client> getAll() {
        return clientService.getAll();
    }
}
