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

    @Autowired
    private RabbitMQService rabbitMQService;


    @PostMapping("price")
    public ResponseEntity registerPrice(@RequestBody @Validated PriceDTO priceDTO){
        rabbitMQService.sendPriceMessage(priceDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("stock")
    public ResponseEntity registerStock(@RequestBody @Validated StockDTO stockDTO){
        rabbitMQService.sendStockMessage(stockDTO);


        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
