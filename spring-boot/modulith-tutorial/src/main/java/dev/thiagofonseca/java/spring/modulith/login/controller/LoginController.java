package dev.thiagofonseca.java.spring.modulith.login.controller;

import dev.thiagofonseca.java.spring.modulith.login.service.LoginServiceWithEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private LoginServiceWithEvent service;

    public LoginController(LoginServiceWithEvent service) {
        this.service = service;
    }

    @GetMapping("/login")
    public String login() {
        service.login("1234-5678-9012-34567");
        return "success";
    }
}
