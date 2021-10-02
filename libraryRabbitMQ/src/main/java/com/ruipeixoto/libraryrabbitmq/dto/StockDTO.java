package com.ruipeixoto.libraryrabbitmq.dto;

import java.io.Serializable;

public class StockDTO implements Serializable {

    public String productSKU;
    public int productStock;

    public StockDTO(String productSKU, int productStock) {
        this.productSKU = productSKU;
        this.productStock = productStock;
    }

    @Override
    public String toString() {
        return "StockDTO{" +
                "procuctSKU='" + productSKU + '\'' +
                ", productStock=" + productStock +
                '}';
    }
}
