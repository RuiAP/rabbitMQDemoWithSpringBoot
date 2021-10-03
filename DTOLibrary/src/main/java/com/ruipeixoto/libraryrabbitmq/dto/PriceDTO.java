package com.ruipeixoto.libraryrabbitmq.dto;

import java.io.Serializable;

public class PriceDTO implements Serializable {

    private String productSKU;
    private double productPrice;

    public PriceDTO() {
    }

    public PriceDTO(String productSKU, double productPrice) {
        this.productSKU = productSKU;
        this.productPrice = productPrice;
    }

    public String getProductSKU() {
        return productSKU;
    }

    public void setProductSKU(String productSKU) {
        this.productSKU = productSKU;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
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
