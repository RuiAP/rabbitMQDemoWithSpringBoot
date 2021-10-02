package com.ruipeixoto.consumerstockqueue.consumer;

import com.ruipeixoto.libraryrabbitmq.constants.RabbitMQConstants;
import com.ruipeixoto.libraryrabbitmq.dto.StockDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class StockConsumer {
    private static final Logger logger = LoggerFactory.getLogger(StockConsumer.class);

    @RabbitListener(queues = RabbitMQConstants.STOCK_QUEUE)
    private void consume(StockDTO stockDTO){
        logger.info(stockDTO.toString());
    }
}
