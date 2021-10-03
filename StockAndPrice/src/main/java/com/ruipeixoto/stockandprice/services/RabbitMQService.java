package com.ruipeixoto.stockandprice.services;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruipeixoto.libraryrabbitmq.constants.RabbitMQConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQService.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

//    @Autowired
//    private ObjectMapper objectMapper;

    public boolean sendPriceMessage(Object message){
        return this.sendMessage(RabbitMQConstants.PRICE_QUEUE, message);
    }

    public boolean sendStockMessage(Object message){
        return this.sendMessage(RabbitMQConstants.STOCK_QUEUE, message);
    }


    private boolean sendMessage(String queueName, Object message){
        //if the rabbitTemplate is configured to use the Jackson2JsonMessageConverter
        //then this is enough
        rabbitTemplate.convertAndSend(queueName, message);
        return true;

        //if the default config is being used rabbitTemplate will try to serialize the java class
        //to map it to JSON use:
    /*
        String messageJSON="";
        try {
            messageJSON = this.objectMapper.writeValueAsString(message);
        } catch (JsonProcessingException e) {
            logger.warn(e.getMessage());
            return false;
        }
        rabbitTemplate.convertAndSend(queueName, messageJSON);
    */
    }
}
