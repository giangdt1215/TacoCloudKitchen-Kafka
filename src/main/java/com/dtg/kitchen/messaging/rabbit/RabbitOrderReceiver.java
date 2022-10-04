package com.dtg.kitchen.messaging.rabbit;

import com.dtg.kitchen.TacoOrder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

@Component
public class RabbitOrderReceiver {

    private RabbitTemplate rabbit;
    private MessageConverter converter;

    public RabbitOrderReceiver(RabbitTemplate rabbit){
        this.rabbit = rabbit;
        this.converter = this.rabbit.getMessageConverter();
    }

    public TacoOrder receiveOrder(){
//        Message message = rabbit.receive("tacocloud.order");
//        return message != null ? (TacoOrder) converter.fromMessage(message) : null;

//        return (TacoOrder) rabbit.receiveAndConvert("tacocloud.order.queue");

        return rabbit.receiveAndConvert("tacocloud.order.queue", new ParameterizedTypeReference<TacoOrder>(){});
    }
}
