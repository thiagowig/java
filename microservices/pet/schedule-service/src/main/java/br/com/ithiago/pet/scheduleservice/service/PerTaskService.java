package br.com.ithiago.pet.scheduleservice.service;

import br.com.ithiago.pet.scheduleservice.PetTask;
import br.com.ithiago.pet.scheduleservice.domain.RegisterRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thiago on 12/2/18.
 */

@Service
public class PerTaskService {

    private List<RegisterRequest> list = new ArrayList<>();

    public void insertRegister(RegisterRequest request) {
        this.list.add(request);
    }

    public List<RegisterRequest> listAll() {
        return list;
    }
}
