package com.obsez.zag.demostreamrmqpublisher.rmq;

import java.util.concurrent.TimeUnit;

import com.obsez.zag.demostreamrmqpublisher.config.RabbitConfig;
import com.obsez.zag.demostreamrmqpublisher.rmq.hello.Receiver;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;

//@Component
public class Runner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    public Runner(Receiver receiver, RabbitTemplate rabbitTemplate) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("[Runner] Sending message...");
        rabbitTemplate.convertAndSend(RabbitConfig.topicExchangeName, "foo.bar.baz", "Hello from RabbitMQ!");
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
    }

}

