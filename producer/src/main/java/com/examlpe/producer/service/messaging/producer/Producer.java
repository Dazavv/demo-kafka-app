package com.examlpe.producer.service.messaging.producer;

import com.examlpe.producer.service.messaging.event.OrderSendEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.examlpe.producer.model.Order;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.examlpe.producer.service.messaging.service.KafkaMessagingService;

@Slf4j
@Component
@RequiredArgsConstructor
public class Producer {
    private final KafkaMessagingService kafkaMessagingService;
    private final ModelMapper modelMapper;

    public Order sendOrderEvent(Order order) {
        kafkaMessagingService.sendOrder(modelMapper.map(order, OrderSendEvent.class));
        log.info("Send order from producer {}", order);
        return order;
    }
}
