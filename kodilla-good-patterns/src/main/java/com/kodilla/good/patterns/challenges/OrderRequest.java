package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;
import java.util.HashMap;

public class OrderRequest {

    public User user;
    public LocalDateTime orderDate;
    HashMap<Product, Integer> productPrice;

    public OrderRequest(User user, LocalDateTime orderDate, HashMap<Product, Integer> productPrice) {
        this.user = user;
        this.orderDate = orderDate;
        this.productPrice = productPrice;
    }

    public User getUser() {
        return user;
    }
    public LocalDateTime getOrderDate() {
        return orderDate;
    }
    public HashMap<Product, Integer> getProductPrice() {
        return productPrice;
    }

}
