package dev.thiagofonseca.microservices.order.service;

import dev.thiagofonseca.microservices.order.domain.Order;
import dev.thiagofonseca.microservices.order.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

    private Map<Long, Order> orders;

    private RestTemplate restTemplate;

    @Value("${api.product.url}")
    private String productUrl;

    public OrderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

        this.orders = new HashMap<>();
        var order = new Order();
        order.setId(1);
        order.setProductId(1);
        orders.put(1L, order);

        order = new Order();
        order.setId(2);
        order.setProductId(2);
        orders.put(2L, order);
    }

    public Order getOrder(long orderId) {
        LOGGER.info("Getting Order with orderId: {}", orderId);

        if(!orders.containsKey(orderId)){
            LOGGER.error("Order Not Found for orderId {}", orderId);
            throw new IllegalStateException("Order Not Found");
        }

        var order = orders.get(orderId);
        order.setProduct(getProduct(order.getProductId()));

        return order;
    }

    private Product getProduct(long productId) {
        LOGGER.info("Getting Product with productId: {}", productId);

        var url = String.format("%s/product/%d", productUrl, productId);
        var product = restTemplate.getForEntity(url, Product.class);

        return product.getBody();
    }
}
