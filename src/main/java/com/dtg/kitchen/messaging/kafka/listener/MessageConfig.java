package com.dtg.kitchen.messaging.kafka.listener;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;

@Configuration
public class MessageConfig {

    @Bean
    public StringJsonMessageConverter jsonConverter(){
        return new StringJsonMessageConverter();
    }
}
