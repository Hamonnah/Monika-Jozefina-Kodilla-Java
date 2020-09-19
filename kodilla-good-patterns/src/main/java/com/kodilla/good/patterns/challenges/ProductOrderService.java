package com.kodilla.good.patterns.challenges;

import java.util.Map;

public class ProductOrderService implements OrderService {

    @Override
    public boolean order(User user, Map<Product, Integer> productQuantities) {
        return true;
    }

}
