package br.com.ithiago.springboot.camel.controller;

import br.com.ithiago.springboot.camel.service.CurrentTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * Created by thiago on 5/2/18.
 */
@RestController
public class CurrentTimeController {

    @Autowired
    private CurrentTimeService service;

    @RequestMapping("/currentDateTime")
    public String getCurrentDateTime() {
        return service.getCurrentDateTime();
    }
}
