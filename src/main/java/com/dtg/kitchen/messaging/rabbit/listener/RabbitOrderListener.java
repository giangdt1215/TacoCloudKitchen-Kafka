package com.dtg.kitchen.messaging.rabbit.listener;

import com.dtg.kitchen.KitchenUI;
import com.dtg.kitchen.TacoOrder;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitOrderListener {

    private KitchenUI ui;

    public RabbitOrderListener(KitchenUI ui){
        this.ui = ui;
    }

    @RabbitListener(queues = "tacocloud.order.queue")
    public void receiveOrder(TacoOrder order){
        ui.displayOrder(order);
    }
}
