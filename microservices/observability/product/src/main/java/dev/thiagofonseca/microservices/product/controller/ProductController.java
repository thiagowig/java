package dev.thiagofonseca.microservices.product.controller;

import dev.thiagofonseca.microservices.product.domain.Product;
import dev.thiagofonseca.microservices.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{productId}")
    public Product getProduct(@PathVariable("productId") long productId) {
        LOGGER.info("Getting Price details for Product Id {}", productId);

        return productService.getProduct(productId);
    }
}
