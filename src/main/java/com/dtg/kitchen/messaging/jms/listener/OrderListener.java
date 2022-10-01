package com.dtg.kitchen.messaging.jms.listener;

import com.dtg.kitchen.KitchenUI;
import com.dtg.kitchen.TacoOrder;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {

    private KitchenUI ui;

    public OrderListener(KitchenUI ui){
        this.ui = ui;
    }

    @JmsListener(destination = "tacocloud.order.queue")
    public void receiveOrder(TacoOrder order){
        ui.displayOrder(order);
    }
}
