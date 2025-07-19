package com.examlpe.producer.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.examlpe.producer.model.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.examlpe.producer.service.messaging.producer.Producer;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final Producer producer;
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Order sendOrder(@RequestBody Order order) {
        log.info("Send order to kafka");
        producer.sendOrderEvent(order);
        return order;
    }

}