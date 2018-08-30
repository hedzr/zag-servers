package com.obsez.zag.demostreamrmqsubscriber.rmq.many;

import com.obsez.zag.demostreamrmqsubscriber.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NeoReceiver1 {

    @RabbitListener(queues = RabbitConfig.QUEUE_NEO)
    public void process(String neo) {
        System.out.println("Receiver 1: " + neo);
    }

}
