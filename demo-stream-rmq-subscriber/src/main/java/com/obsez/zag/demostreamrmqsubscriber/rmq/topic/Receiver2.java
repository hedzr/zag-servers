package com.obsez.zag.demostreamrmqsubscriber.rmq.topic;

import com.obsez.zag.demostreamrmqsubscriber.config.RabbitConfig;
import com.obsez.zag.demostreamrmqsubscriber.config.TopicRabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
@RabbitListener(queues = RabbitConfig.QUEUE_HELLO)
public class Receiver2 {


    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @RabbitHandler
    public void process(String message) {
        System.out.println("orders Received <" + message + ">");
        latch.countDown();
    }

}
