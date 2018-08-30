package com.obsez.zag.demostreamrmqsubscriber.service;

import com.obsez.zag.demostreamrmqsubscriber.config.RabbitConfig;
import com.obsez.zag.demostreamrmqsubscriber.rmq.many.NeoSender1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MqService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String msg = "mq service hello rabbitmq:" + new Date();
        System.out.println("MqService:" + msg);
        this.rabbitTemplate.convertAndSend(RabbitConfig.routingKey, msg);
    }

    public void send(String msg) {
        String text = msg + ":" + new Date();
        this.rabbitTemplate.convertAndSend(RabbitConfig.topicExchangeName, RabbitConfig.routingKey, text);
        logger.info("sending: {}", text);
    }

    @Autowired
    private NeoSender1 neoSender1;

    //@Autowired
    //private NeoSender2 neoSender2;


    public void sendMany(String msg) {
        //String text = msg + ":" + new Date();
        //this.rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_ORDERS, RabbitMQConfig.routingKey2, text);
        //logger.info("sending 2: {}", text);
        for (int i = 0; i < 100; i++) {
            neoSender1.send(i);
            //neoSender2.send(i);
        }
    }

    public void sendManyToMany(String msg) {
        //String text = msg + ":" + new Date();
        //this.rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_ORDERS, RabbitMQConfig.routingKey2, text);
        //logger.info("sending 2: {}", text);
        for (int i = 0; i < 100; i++) {
            neoSender1.send(i);
            //neoSender2.send(i);
        }
    }

}
