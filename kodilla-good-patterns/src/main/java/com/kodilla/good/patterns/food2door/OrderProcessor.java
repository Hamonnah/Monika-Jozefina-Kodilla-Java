package com.kodilla.good.patterns.food2door;

public class OrderProcessor {

    void processOrder(FoodProvider provider, Order order) {
        provider.process(order);
    }

}
