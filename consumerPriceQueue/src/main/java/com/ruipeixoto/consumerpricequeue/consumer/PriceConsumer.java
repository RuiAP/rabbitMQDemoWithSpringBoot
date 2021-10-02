package com.ruipeixoto.consumerpricequeue.consumer;

import com.ruipeixoto.libraryrabbitmq.constants.RabbitMQConstants;
import com.ruipeixoto.libraryrabbitmq.dto.PriceDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PriceConsumer {

    private static final Logger logger = LoggerFactory.getLogger(PriceConsumer.class);

    @RabbitListener(queues = RabbitMQConstants.PRICE_QUEUE)
    private void consumer(PriceDTO priceDTO){
        logger.info(priceDTO.toString());
    }
}
