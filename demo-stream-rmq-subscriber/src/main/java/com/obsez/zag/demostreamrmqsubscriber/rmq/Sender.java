package com.obsez.zag.demostreamrmqsubscriber.rmq;

import com.obsez.zag.demostreamrmqsubscriber.config.RabbitConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Sender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String msg = "hello rabbitmq:" + new Date();
        System.out.println("Sender:" + msg);
        this.rabbitTemplate.convertAndSend(RabbitConfig.routingKey, msg);
    }

    public void send(String msg) {
        String text = msg + ":" + new Date();
        this.rabbitTemplate.convertAndSend(RabbitConfig.routingKey, text);
    }

    public void send2(String msg) {
        String text = msg + ":" + new Date();
        this.rabbitTemplate.convertAndSend(RabbitConfig.routingKey2, text);
    }

}
