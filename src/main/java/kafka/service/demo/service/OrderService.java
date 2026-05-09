package kafka.service.demo.service;

import kafka.service.demo.kafka.KafkaProducerService;
import kafka.service.demo.model.OrderEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final KafkaProducerService producerService;

    public void createOrder(OrderEvent event) {
        // Business logic placeholder
        producerService.publishOrderEvent(event);
    }
}