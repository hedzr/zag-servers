package com.obsez.zag.demostreamrmqpublisher.rmq.many;

import com.obsez.zag.demostreamrmqpublisher.config.RabbitConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * hello: 1-to-many，多个消费者均分生产者的全部消息
 * neo: many-to-many，多个消费者均分所有生产者的全部消息
 */
@Component
public class NeoSender1 {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(int i) {
        String context = "spirng boot neo queue #1." + " ****** " + i;
        //System.out.println("Sender1 : " + context);
        this.rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NEO, "neo.main.aaa", context);
    }

}
