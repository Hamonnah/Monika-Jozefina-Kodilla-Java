package com.kodilla.good.patterns.food2door;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderProcessor {

    private List<Provider> getSupplierList(Order order) {
        return order.getOrderedProducts().keySet().stream()
                .map(Product::getSupplier)
                .distinct()
                .collect(Collectors.toList());
    }

    private boolean orderFromOneSupplier(Order order, Provider provider) {
        Map<Product, Integer> productList = order.getOrderedProducts().entrySet().stream()
                .filter(entry -> entry.getKey().getSupplier().equals(provider))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        Order singleOrder = new Order(order.getCustomer(), productList);
        return provider.process(singleOrder);
    }

    public boolean process(Order order) {
        return getSupplierList(order).stream()
                .map(supplier -> orderFromOneSupplier(order, supplier))
                .reduce(true, (result1, result2) -> result1 && result2);
    }

}
