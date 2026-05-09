package kafka.service.demo.kafka;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import kafka.service.demo.model.OrderEvent;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducerService {
	private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    private static final String TOPIC = "order-topic";

    public void publishOrderEvent(OrderEvent event) {
        log.info("Publishing order event: {}", event);

        kafkaTemplate.send(TOPIC, event.getOrderId(), event)
                .whenComplete((result, ex) -> {
                    if (ex == null) {
                        log.info("Event sent successfully to topic {}", TOPIC);
                    } else {
                        log.error("Failed to send event", ex);
                    }
                });
    }
	

}
