package com.dtg.kitchen.messaging.jms;

import com.dtg.kitchen.TacoOrder;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
public class JmsOrderReceiver implements OrderReceiver{

    private JmsTemplate jms;
    //private MessageConverter converter;

//    public JmsOrderReceiver(JmsTemplate jms, MessageConverter converter){
//        this.jms = jms;
//        this.converter = converter;
//    }

    public JmsOrderReceiver(JmsTemplate jms){
        this.jms = jms;
    }

    @Override
    public TacoOrder receiveOrder() {
//        Message message = jms.receive("tacocloud.order.queue");
//        return converter.fromMessage(message);
        return (TacoOrder) jms.receiveAndConvert("tacocloud.order.queue");
    }
}
