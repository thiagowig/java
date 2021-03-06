package br.com.ithiago.pet.registerservice.controller;

import br.com.ithiago.pet.registerservice.domain.RegisterRequest;
import br.com.ithiago.pet.registerservice.domain.RegisterResponse;
import br.com.ithiago.pet.registerservice.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by thiago on 12/1/18.
 */
@RestController
@Slf4j
public class RegisterController {

    private RegisterService service;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    public RegisterController(RegisterService service) {
        this.service = service;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request) {
        log.info("THE SERVER PORT: " + serverPort);

        RegisterResponse response = service.registerUser(request);

        ResponseEntity<RegisterResponse> responseEntity = new ResponseEntity(response, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping(value = "/register/all")
    public List<RegisterResponse> getAllRegisters() {
        return service.getAllRegisters();
    }

}
