package br.com.ithiago.sprinbootjwt.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController()
public class UserController {

    @GetMapping("/users")
    public List<String> getUsers() {
        List<String> users = Arrays.asList("Thiago", "Simone", "Tania");
        return users;
    }
}
