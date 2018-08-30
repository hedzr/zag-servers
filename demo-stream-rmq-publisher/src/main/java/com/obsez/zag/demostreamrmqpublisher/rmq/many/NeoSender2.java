package com.obsez.zag.demostreamrmqpublisher.rmq.many;

import com.obsez.zag.demostreamrmqpublisher.config.RabbitConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NeoSender2 {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(int i) {
        String context = "spirng boot neo queue #2."+" ****** "+i;
        //System.out.println("Sender2 : " + context);
        this.rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NEO, "neo.main.bbb", context);
    }

}
