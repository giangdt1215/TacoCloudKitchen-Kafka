package com.dtg.kitchen.messaging.jms;

import com.dtg.kitchen.TacoOrder;

public interface OrderReceiver {

    TacoOrder receiveOrder();
}
