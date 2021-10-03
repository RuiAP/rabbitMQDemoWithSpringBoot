package com.ruipeixoto.consumerpricequeue.configs;

import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.messaging.handler.annotation.support.MessageHandlerMethodFactory;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;


@Configuration
public class RabbitConfig implements RabbitListenerConfigurer
{
    //Overriding the default configurations so that the message is consumed/mapped from JSON

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
        registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
    }

    @Bean
    public MessageHandlerMethodFactory messageHandlerMethodFactory() {
        DefaultMessageHandlerMethodFactory messageHandlerMethodFactory = new DefaultMessageHandlerMethodFactory();
        messageHandlerMethodFactory.setMessageConverter(Jackson2MessageConverter());
        return messageHandlerMethodFactory;
    }
    

    @Bean
    public MappingJackson2MessageConverter Jackson2MessageConverter() {
        return new MappingJackson2MessageConverter();
    }


}
