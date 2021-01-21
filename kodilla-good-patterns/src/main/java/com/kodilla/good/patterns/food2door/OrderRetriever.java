package com.kodilla.good.patterns.food2door;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class OrderRetriever {

    public Order retrieve() {

        Customer customer = new Customer("Monika", "monika@dentinor.no");

        Provider extraFoodShop = new ExtraFoodShopProvider("ExtraFoodShop", "extraFoodShop@info.com");
        Provider healthyShop = new HealthyShopProvider("Healthy Shop", "healthy@gmail.com");
        Provider glutenFreeShop = new GlutenFreeShopProvider("GlutenFree Shop", "glutenFree@shop.pl");

        Product blackMacaPowder = new Product("Black Maca Powder", new BigDecimal("100.00"), extraFoodShop);
        Product beetrootPowder = new Product("Beetroot Powder", new BigDecimal("180.00"), healthyShop);
        Product organicGoi = new Product("Organic Goi", new BigDecimal("45.00"), glutenFreeShop);

        Map<Product, Integer> orderedProducts = new HashMap<>();
        orderedProducts.put(blackMacaPowder, 3);
        orderedProducts.put(beetrootPowder, 4);
        orderedProducts.put(organicGoi, 7);

        return new Order(customer, orderedProducts);
    }

}
