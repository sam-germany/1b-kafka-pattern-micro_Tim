package com.course.kafka.broker.consumer;

import com.course.kafka.broker.message.OrderMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderListener {
    private static final Logger log = LoggerFactory.getLogger(OrderListener.class);

    @KafkaListener(topics = "t.commodity.order")
    public void listen(OrderMessage message) {
        var totalItemAmount = message.getPrice() * message.getQuantity();

log.info("Processing order {} , item {}, credit card number {}. Total amount {}",
               message.getOrderNumber(), message.getItemName(), message.getCreditCardNumber());
    }

}
