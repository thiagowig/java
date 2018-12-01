package br.com.ithiago.pet.registerservice.controller;

import br.com.ithiago.pet.registerservice.domain.RegisterRequest;
import br.com.ithiago.pet.registerservice.domain.RegisterResponse;
import br.com.ithiago.pet.registerservice.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by thiago on 12/1/18.
 */
@RestController
public class RegisterController {

    private RegisterService service;

    @Autowired
    public RegisterController(RegisterService service) {
        this.service = service;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request) {
        RegisterResponse response = service.registerUser(request);

        ResponseEntity<RegisterResponse> responseEntity = new ResponseEntity(response, HttpStatus.OK);
        return responseEntity;
    }

}
