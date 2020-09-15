package com.kodilla.good.patterns.challenges;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {

        User user = new User("John", "Lemon", "Lelon", "lelon@info.com", "ul. Cytrynowa 5, 43-300, B-B");
        LocalDateTime orderDate = LocalDateTime.of(2020, 05, 15, 15, 15, 10);
        HashMap<Product, Integer> orderList = new HashMap<>();
        orderList.put(new Product("Ipad mini", new BigDecimal("2500")), 7);
        orderList.put(new Product("Iphone 11Pro", new BigDecimal("5000")), 3);

        return new OrderRequest(user, orderDate, orderList);
    }

}
