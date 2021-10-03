package com.ruipeixoto.stockandprice.controller;

import com.ruipeixoto.libraryrabbitmq.dto.PriceDTO;
import com.ruipeixoto.libraryrabbitmq.dto.StockDTO;
import com.ruipeixoto.stockandprice.services.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class PriceAndStockController {

    private final RabbitMQService rabbitMQService;

    @Autowired
    public PriceAndStockController(RabbitMQService rabbitMQService) {
        this.rabbitMQService = rabbitMQService;
    }

    @PostMapping("price")
    public ResponseEntity registerPrice(@RequestBody @Validated PriceDTO priceDTO){
        boolean success = rabbitMQService.sendPriceMessage(priceDTO);

        return success?
                new ResponseEntity<>(HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("stock")
    public ResponseEntity registerStock(@RequestBody @Validated StockDTO stockDTO){
        boolean success = rabbitMQService.sendStockMessage(stockDTO);

        return success?
                new ResponseEntity<>(HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }


}
