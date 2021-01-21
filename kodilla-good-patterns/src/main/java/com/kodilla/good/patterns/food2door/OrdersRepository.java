package com.kodilla.good.patterns.food2door;

public class OrderRepository implements Repository {

    @Override
    public void saveOrder(Order order) {
        System.out.println(order.getCustomer() + ": " + order.getOrderedProducts() + " ");
    }
}
