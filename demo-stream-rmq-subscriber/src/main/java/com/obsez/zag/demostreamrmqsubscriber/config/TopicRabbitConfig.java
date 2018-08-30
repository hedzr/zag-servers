package com.obsez.zag.demostreamrmqsubscriber.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConfig {


    final static String message = "sw.orders.message";
    final static String messages = "sw.orders.messages";

    @Bean
    @Qualifier("sw.orders")
    public Queue queueMessage() {
        return new Queue(TopicRabbitConfig.message);
    }

    @Bean
    @Qualifier("sw.orders")
    public Queue queueMessages() {
        return new Queue(TopicRabbitConfig.messages);
    }

    @Bean
    @Qualifier("sw.orders")
    TopicExchange exchange() {
        return new TopicExchange("spring-cloud-test-topicExchange");
    }

    @Bean
    Binding bindingExchangeMessage(@Qualifier("sw.orders") Queue queueMessage, @Qualifier("sw.orders") TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("sw.orders.message");
    }

    @Bean
    Binding bindingExchangeMessages(@Qualifier("sw.orders") Queue queueMessages, @Qualifier("sw.orders") TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("sw.orders.#");
    }


    //public static final String QUEUE_ORDERS = "orders-queue";
    //public static final String QUEUE_DEAD_ORDERS = "orders-dead-queue";
    //public static final String EXCHANGE_ORDERS = "orders-exchange";
    //
    //public final static String ordersRoutingKeyFilter = "orders.#";
    //
    ////@Primary
    //@Bean
    //@Qualifier("orders")
    //Queue ordersQueue() {
    //    return QueueBuilder.durable(QUEUE_ORDERS).build();
    //}
    //
    //@Bean
    //@Qualifier("orders.dead")
    //Queue deadLetterQueue() {
    //    return QueueBuilder.durable(QUEUE_DEAD_ORDERS).build();
    //}
    //
    //@Bean
    //@Qualifier("orders")
    //Exchange ordersExchange() {
    //    return ExchangeBuilder.topicExchange(EXCHANGE_ORDERS).build();
    //}
    //
    //@Bean
    //Binding ordersBinding(@Qualifier("orders") Queue ordersQueue, @Qualifier("orders") TopicExchange ordersExchange) {
    //    return BindingBuilder.bind(ordersQueue).to(ordersExchange).with(QUEUE_ORDERS);
    //}


}
