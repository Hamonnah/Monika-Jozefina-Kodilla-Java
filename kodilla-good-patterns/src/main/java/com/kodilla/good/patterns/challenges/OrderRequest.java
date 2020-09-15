package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;
import java.util.HashMap;

public class OrderRequest {

    private final User user;
    private final LocalDateTime orderDate;
    HashMap<Product, Integer> productQuantities;

    public OrderRequest(User user, LocalDateTime orderDate, HashMap<Product, Integer> productQuantities) {
        this.user = user;
        this.orderDate = orderDate;
        this.productQuantities = productQuantities;
    }

    public User getUser() {
        return user;
    }
    public LocalDateTime getOrderDate() {
        return orderDate;
    }
    public HashMap<Product, Integer> getProductQuantities() {
        return productQuantities;
    }

}
