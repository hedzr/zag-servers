package com.obsez.zag.demostreamrmqpublisher.rmq.hello;

import com.obsez.zag.demostreamrmqpublisher.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
@RabbitListener(queues = RabbitConfig.QUEUE_HELLO)
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @RabbitHandler
    public void process(String message) {
        System.out.println("hello Received <" + message + ">");
        latch.countDown();
    }

}
