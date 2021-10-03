package com.ruipeixoto.libraryrabbitmq.dto;

import java.io.Serializable;

public class StockDTO implements Serializable {

    private String productSKU;
    private int productStock;

    public StockDTO() {
    }

    public StockDTO(String productSKU, int productStock) {
        this.productSKU = productSKU;
        this.productStock = productStock;
    }

    public String getProductSKU() {
        return productSKU;
    }

    public void setProductSKU(String productSKU) {
        this.productSKU = productSKU;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
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
