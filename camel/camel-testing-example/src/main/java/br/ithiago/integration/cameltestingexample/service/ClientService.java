package br.ithiago.integration.cameltestingexample.service;

import br.ithiago.integration.cameltestingexample.model.Client;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thiago on 11/10/18.
 */
@Service
public class ClientService {

    public List<Client> findAllClients() {
        List<Client> clients = new ArrayList<Client>();

        clients.add(createClient(1, "Thiago Fonseca"));
        clients.add(createClient(1, "Simone Borges"));
        clients.add(createClient(1, "Tania Ramos"));

        return clients;
    }

    private Client createClient(Integer id, String name) {
        Client client = new Client();

        client.setId(id);
        client.setName(name);

        return client;
    }
}
