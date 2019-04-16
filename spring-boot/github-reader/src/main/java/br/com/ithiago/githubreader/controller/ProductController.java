package br.com.ithiago.githubreader.controller;

import br.com.ithiago.githubreader.dto.UserInfoDTO;
import br.com.ithiago.githubreader.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by thiago on 4/15/19.
 */

@RestController
@RequestMapping("/api")
public class ProductController {

    final private UserService userService;

    @Autowired
    public ProductController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("products/{userName}")
    public UserInfoDTO getUserInformation(@PathVariable("userName") String userName) {
        UserInfoDTO response = userService.getUserInformation(userName);
        return response;
    }
}
