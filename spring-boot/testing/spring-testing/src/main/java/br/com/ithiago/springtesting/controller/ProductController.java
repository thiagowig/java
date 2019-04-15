package br.com.ithiago.springtesting.controller;

import br.com.ithiago.springtesting.service.ClientService;
import br.com.ithiago.springtesting.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<String> doSomething() {
        return productService.doSomething();
    }
}
