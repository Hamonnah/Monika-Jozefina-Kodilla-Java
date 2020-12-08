package com.kodilla.good.patterns.food2door;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class OrderRequest {

    LocalDateTime orderDate;
    Map<Product, Integer> quantityOfOrderedProducts;
    Boolean status;

    public OrderRequest(Boolean status) {
        this.status = status;
    }

    public OrderRequest(Map<Product, Integer> quantityOfOrderedProducts, LocalDateTime orderDate) {
        this.quantityOfOrderedProducts = quantityOfOrderedProducts;
        this.orderDate = orderDate;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public Map<Product, Integer> getQuantityOfOrderedProducts() {
        return quantityOfOrderedProducts;
    }

    public Boolean getStatus() {
        return status;
    }
}
