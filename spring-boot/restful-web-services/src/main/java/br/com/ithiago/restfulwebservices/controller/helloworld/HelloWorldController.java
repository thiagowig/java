package br.com.ithiago.restfulwebservices.controller.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HelloWorldController {

    @GetMapping("/")
    private ResponseDTO home() {
        throw new RuntimeException("Some error has happened!");
    }

    @GetMapping("/path-variable/{name}")
    private ResponseDTO home(@PathVariable String name) {
        return new ResponseDTO(String.format("Hello World %s", name));
    }
}
