package com.obsez.zag.demostreamrmqsubscriber.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableRabbit
public class RabbitConfig {


    public static final String topicExchangeName = "spring-cloud-test-exchange";

    public static final String QUEUE_HELLO = "spring-cloud-test-hello";

    public final static String routingKey = "foo.bar.aaa";
    public final static String routingKeyFilter = "foo.bar.#";

    public final static String routingKey2 = "sw.orders.test.1";

    //@Primary
    @Bean
    @Qualifier("hello")
    public Queue helloQueue() {
        return new Queue(QUEUE_HELLO, false, false, false);
    }

    @Bean
    @Qualifier("hello")
    TopicExchange helloExchange() {
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    Binding helloBinding(@Qualifier("hello") Queue queue, @Qualifier("hello") TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingKeyFilter);
    }

    public static final String QUEUE_NEO = "spring-cloud-test-neo";
    public static final String EXCHANGE_NEO = "spring-cloud-test-exchange-neo";
    public static final String routingKeyFilterNeo = "neo.#";

    @Bean
    @Qualifier("neo")
    public Queue neoQueue() {
        return new Queue(QUEUE_NEO, true, false, false);
    }

    @Bean
    @Qualifier("neo")
    TopicExchange neoExchange() {
        return new TopicExchange(EXCHANGE_NEO, true, false);
    }

    @Bean
    Binding neoBinding(@Qualifier("neo") Queue queue, @Qualifier("neo") TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingKeyFilterNeo);
    }

    @Bean
    public Queue objectQueue() {
        return new Queue("spring-cloud-test-object");
    }

    /**
     * 在创建了多个ConnectionFactory时，必须定义RabbitAdmin，否则无法自动创建exchange,queue
     *
     * @param connectionFactory
     * @return
     */
    @Bean
    public RabbitAdmin rabbitAdmin(/*@Qualifier("connectionFactory") */ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    ////@Bean(name="myListenContainer")
    //public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
    //    SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
    //    //factory.setMessageConverter(integrationEventMessageConverter());
    //    //factory.setConnectionFactory(connectionFactory());
    //    //factory.setMaxConcurrentConsumers(5);
    //    factory.setPrefetchCount(0);
    //    return factory;
    //}

    //               A
    //
    //@Bean
    //public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactoryPlus(
    //        SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory,
    //        Jackson2JsonMessageConverter jackson2JsonMessageConverter) {
    //    rabbitListenerContainerFactory.setMessageConverter(jackson2JsonMessageConverter);
    //    return rabbitListenerContainerFactory;
    //}
    //
    //@Bean
    //public Jackson2JsonMessageConverter jackson2JsonMessageConverter(ObjectMapper xssObjectMapper) {
    //    return new Jackson2JsonMessageConverter(xssObjectMapper);
    //}


    //@Bean
    //SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
    //                                         MessageListenerAdapter listenerAdapter) {
    //    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
    //    container.setConnectionFactory(connectionFactory);
    //    container.setQueueNames(QUEUE_HELLO);
    //    container.setMessageListener(listenerAdapter);
    //    return container;
    //}

    //@Bean
    //MessageListenerAdapter listenerAdapter(Receiver receiver) {
    //    return new MessageListenerAdapter(receiver, "receiveMessage");
    //}

    //@Bean
    //public ConnectionFactory connectionFactory() {
    //    CachingConnectionFactory cachingConnectionFactory =  new CachingConnectionFactory("127.0.0.1", 5672);
    //    cachingConnectionFactory.setUsername("guest");
    //    cachingConnectionFactory.setPassword("guest");
    //    return cachingConnectionFactory;
    //}


    //@Bean
    //public ConnectionFactory connectionFactory() {
    //    CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
    //    connectionFactory.setHost(HOST);
    //    connectionFactory.setPort(PORT);
    //    connectionFactory.setUsername(USERNAME);
    //    connectionFactory.setPassword(PASSWORD);
    //    connectionFactory.setVirtualHost("/");
    //    //必须要设置,消息的回掉
    //    connectionFactory.setPublisherConfirms(true);
    //    return connectionFactory;
    //}
}
