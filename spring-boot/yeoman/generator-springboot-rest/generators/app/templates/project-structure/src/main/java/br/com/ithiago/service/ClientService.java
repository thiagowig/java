package br.com.ithiago.service;

import br.com.ithiago.model.Client;
import br.com.ithiago.repository.ClientRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thiago on 12/30/18.
 */

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public String createClient(Client client) {
        clientRepository.save(client);

        return "Client saved with success!!!";
    }

    public List<Client> getAll() {
        return Lists.newArrayList(clientRepository.findAll());
    }
}
