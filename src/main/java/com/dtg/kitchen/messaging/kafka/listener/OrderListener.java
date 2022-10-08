package com.dtg.kitchen.messaging.kafka.listener;

import com.dtg.kitchen.KitchenUI;
import com.dtg.kitchen.TacoOrder;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderListener {

    private KitchenUI ui;

    public OrderListener(KitchenUI ui){
        this.ui = ui;
    }

    @KafkaListener(topics = "tacocloud.orders.topic")
    public void handle(TacoOrder order, Message<TacoOrder> message,
                       ConsumerRecord<String, TacoOrder> record){
        //Use ConsumerRecord to get additional information
        log.info("ConsumerRecord: Received from partition {} with timestamp {}",
                record.partition(), record.timestamp());
        //Use Message object to get additional information
        MessageHeaders headers = message.getHeaders();
        log.info("Received from partition {} with timestamp {}",
                headers.get(KafkaHeaders.RECEIVED_PARTITION_ID),
                headers.get(KafkaHeaders.RECEIVED_TIMESTAMP));
        ui.displayOrder(order);
    }
}
