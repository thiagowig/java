package dev.thiagofonseca.microservices.order.controller;

import dev.thiagofonseca.microservices.order.domain.Order;
import dev.thiagofonseca.microservices.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order/{orderId}")
    public Order getOrder(@PathVariable("orderId") long orderId) {
        LOGGER.info("Getting Order and Product Details with orderId: {}", orderId);
        return orderService.getOrder(orderId);
    }

}
