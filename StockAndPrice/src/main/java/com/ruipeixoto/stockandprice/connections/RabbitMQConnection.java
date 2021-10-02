package com.ruipeixoto.stockandprice.connections;

import com.ruipeixoto.libraryrabbitmq.constants.RabbitMQConstants;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RabbitMQConnection {

    private static final String NAME_EXCHANGE = "amq.direct";
    private final AmqpAdmin amqpAdmin;


    @Autowired
    public RabbitMQConnection(AmqpAdmin amqpAdmin){
        this.amqpAdmin = amqpAdmin;
    }


    private Queue queue(String queueName){
        return new Queue(queueName, true, false, false);
    }

    private DirectExchange directExchange(){
        return new DirectExchange(NAME_EXCHANGE);
    }


    private Binding relacionamento(Queue queue, DirectExchange directExchange){
        return new Binding(
                queue.getName(),
                Binding.DestinationType.QUEUE,
                directExchange.getName(),
                queue.getName(),
                null);
    }

    @PostConstruct
    private void  adiciona(){
        Queue stockQueue = this.queue(RabbitMQConstants.STOCK_QUEUE);
        Queue priceQueue = this.queue(RabbitMQConstants.PRICE_QUEUE);

        DirectExchange directExchange = this.directExchange();

        Binding stockBinding =  relacionamento(stockQueue, directExchange);
        Binding priceBinding =  relacionamento(priceQueue, directExchange);

        this.amqpAdmin.declareExchange(directExchange);

        this.amqpAdmin.declareQueue(stockQueue);
        this.amqpAdmin.declareQueue(priceQueue);

        this.amqpAdmin.declareBinding(stockBinding);
        this.amqpAdmin.declareBinding(priceBinding);

    }


}
