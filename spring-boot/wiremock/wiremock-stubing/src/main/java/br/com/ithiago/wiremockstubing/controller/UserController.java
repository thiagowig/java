package br.com.ithiago.wiremockstubing.controller;

import br.com.ithiago.wiremockstubing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by thiago on 4/21/19.
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/info")
    public String getUserInfo() {
        return userService.getUserInformation();
    }
}
