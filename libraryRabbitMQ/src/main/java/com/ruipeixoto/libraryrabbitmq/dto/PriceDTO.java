package com.ruipeixoto.libraryrabbitmq.dto;

import java.io.Serializable;

public class PriceDTO implements Serializable {

    public String productSKU;
    public double productPrice;

    public PriceDTO(String productSKU, double productPrice) {
        this.productSKU = productSKU;
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "PriceDTO{" +
                "productSKU='" + productSKU + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}
