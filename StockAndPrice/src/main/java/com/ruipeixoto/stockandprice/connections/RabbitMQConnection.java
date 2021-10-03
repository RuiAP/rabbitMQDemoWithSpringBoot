package com.ruipeixoto.stockandprice.connections;

import com.ruipeixoto.libraryrabbitmq.constants.RabbitMQConstants;
import org.springframework.amqp.core.*;
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


    private Queue createQueue(String queueName){
        return new Queue(queueName, true, false, false);
    }

    private DirectExchange createDirectExchange(){
        return new DirectExchange(NAME_EXCHANGE);
    }


    private Binding createBinding(Queue queue, DirectExchange directExchange){
        //through constructor
//        return new Binding(queue.getName(), Binding.DestinationType.QUEUE,
//                directExchange.getName(), queue.getName(),null);

    //alternatively, through builder:
        return BindingBuilder
                .bind(queue)
                .to(directExchange)
                .with(queue.getName());
    }

    @PostConstruct
    private void configureAMQPAdmin(){
        Queue stockQueue = this.createQueue(RabbitMQConstants.STOCK_QUEUE);
        Queue priceQueue = this.createQueue(RabbitMQConstants.PRICE_QUEUE);

        DirectExchange directExchange = this.createDirectExchange();

        Binding stockBinding =  createBinding(stockQueue, directExchange);
        Binding priceBinding =  createBinding(priceQueue, directExchange);

        this.amqpAdmin.declareExchange(directExchange);

        this.amqpAdmin.declareQueue(stockQueue);
        this.amqpAdmin.declareQueue(priceQueue);

        this.amqpAdmin.declareBinding(stockBinding);
        this.amqpAdmin.declareBinding(priceBinding);
    }


}
