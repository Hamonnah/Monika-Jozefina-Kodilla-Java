package com.kodilla.good.patterns.challenges;

import java.util.Map;

public interface OrderService {

    boolean order(User user, Map<Product, Integer> productQuantities);

}
