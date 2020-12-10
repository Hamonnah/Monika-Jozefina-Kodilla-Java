package com.kodilla.good.patterns.food2door;

import java.util.Map;

public interface Provider {

    boolean order(Map<Product, Integer> products);

}
