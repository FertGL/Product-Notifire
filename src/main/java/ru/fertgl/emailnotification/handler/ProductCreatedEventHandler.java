package ru.fertgl.emailnotification.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.fertgl.core.ProductCreatedEvent;


@Component
@KafkaListener(topics = "product_created_events_topic")
public class ProductCreatedEventHandler {

    private RestTemplate restTemplate;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());


    public ProductCreatedEventHandler(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @KafkaHandler
    public void handler(ProductCreatedEvent productCreatedEvent) {
        LOGGER.info("Received event: {}", productCreatedEvent.getTitle());

//        String url = "http://localhost:8090";
//        try {
//            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
//            if (response.getStatusCode().value() == HttpStatus.OK.value()) {
//                LOGGER.info("Received response: {}", response.getBody());
//            }
//        } catch (HttpServerErrorException e) {
//            LOGGER.error(e.getMessage());
//            throw new NonRetryableException(e);
//        } catch (RestClientException e) {
//            LOGGER.error(e.getMessage());
//            throw new RetryableException(e);
//        } catch (Exception e) {
//            throw new NonRetryableException(e);
//        }
    }
}
