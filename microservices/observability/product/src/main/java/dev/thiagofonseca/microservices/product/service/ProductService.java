package dev.thiagofonseca.microservices.product.service;

import dev.thiagofonseca.microservices.product.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    private Map<Long, Product> products;


    public ProductService() {
        products = new HashMap<>();
        products.put(1L, new Product(1L, "Samsung S20", 1000D));
    }

    public Product getProduct(long productId) {
        LOGGER.info("Getting Product Repo With Product Id {}", productId);

        if(!products.containsKey(productId)){
            LOGGER.error("Product Not Found for Product Id {}", productId);
            throw new IllegalStateException("Product Not Found");
        }

        return products.get(productId);
    }
}
