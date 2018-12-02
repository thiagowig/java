package br.com.ithiago.pet.scheduleservice.controller;

import br.com.ithiago.pet.scheduleservice.PetTask;
import br.com.ithiago.pet.scheduleservice.service.PerTaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by thiago on 12/2/18.
 */

@RestController
public class ServicesController {

    private PerTaskService service;

    @GetMapping(value = "/services/list")
    public List<PetTask> listAllService() {
        return service.listAll();
    }

}
