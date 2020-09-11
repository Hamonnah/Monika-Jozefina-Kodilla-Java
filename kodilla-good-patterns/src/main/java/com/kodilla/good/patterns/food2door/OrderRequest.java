package com.kodilla.good.patterns.food2door;

import java.time.LocalDateTime;
import java.util.HashMap;

public class OrderRequest {

    Provider provider;
    LocalDateTime orderDate;
    HashMap<Product, Integer> quantityOfOrderedProducts;

    public OrderRequest(Provider provider, HashMap<Product, Integer> quantityOfOrderedProducts, LocalDateTime orderDate) {
        this.provider = provider;
        this.quantityOfOrderedProducts = quantityOfOrderedProducts;
        this.orderDate = orderDate;
    }

    public Provider getProvider() {
        return provider;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public HashMap<Product, Integer> getQuantityOfOrderedProducts() {
        return quantityOfOrderedProducts;
    }

}
