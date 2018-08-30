package com.obsez.zag.demostreamrmqpublisher.rmq.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * fanoutSender 负责广播消息
 * 一条消息将被广播到所有子队列中，
 * 每条子队列如果有多个接受者，则接受者们均分消息。
 */
@Component
public class FanoutSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String msg) {
        //System.out.println("Sender : " + msg);
        this.rabbitTemplate.convertAndSend("fanoutExchange", "", msg);
    }

}

