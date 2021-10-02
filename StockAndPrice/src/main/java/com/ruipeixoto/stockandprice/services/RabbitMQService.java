package com.ruipeixoto.stockandprice.services;
import com.ruipeixoto.libraryrabbitmq.constants.RabbitMQConstants;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendPriceMessage(Object message){
        this.sendMessage(RabbitMQConstants.PRICE_QUEUE, message);
    }

    public void sendStockMessage(Object message){
        this.sendMessage(RabbitMQConstants.STOCK_QUEUE, message);
    }

    private void sendMessage(String queueName, Object message){
        rabbitTemplate.convertAndSend(queueName, message);
    }
}
