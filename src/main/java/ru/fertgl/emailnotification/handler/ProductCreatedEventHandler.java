package ru.fertgl.emailnotification.handler;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.fertgl.core.ProductCreatedEvent;


@Component
@KafkaListener(topics = "product_created_events_topic")
public class ProductCreatedEventHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @KafkaHandler
    public void handler(ProductCreatedEvent productCreatedEvent) {
        LOGGER.info("Received event: {}" + productCreatedEvent.getTitle());


    }
}
