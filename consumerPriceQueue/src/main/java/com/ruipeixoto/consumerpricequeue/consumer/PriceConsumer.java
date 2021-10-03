package com.ruipeixoto.consumerpricequeue.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruipeixoto.libraryrabbitmq.constants.RabbitMQConstants;
import com.ruipeixoto.libraryrabbitmq.dto.PriceDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PriceConsumer {

    private static final Logger logger = LoggerFactory.getLogger(PriceConsumer.class);

    public PriceConsumer() {
    }


    //Mapping using the RabbitListener configurations (see RabbitConfig Class)
    @RabbitListener(queues = RabbitMQConstants.PRICE_QUEUE)
    private void consume(PriceDTO priceDTO){
        logger.info("Received message mapped to PriceDTO: {}",priceDTO);
    }


    //Mapping manually from JSON using the Jackson ObjectMapper:
/*
    @RabbitListener(queues = RabbitMQConstants.PRICE_QUEUE)
    private void consume(Message message){
        String messageJSON = new String(message.getBody());
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            PriceDTO priceDTO = objectMapper.readValue(messageJSON,PriceDTO.class);
            logger.info("Received JSON message : {}",new String(message.getBody()));
            logger.info("Mapped to PriceDTO : {}",priceDTO);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
*/


}
