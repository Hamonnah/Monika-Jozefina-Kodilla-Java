package com.kodilla.good.patterns.food2door;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {
        ExtraFoodShop extraFoodShop = new ExtraFoodShop("ExtraFoodShop", "extraFoodShop@info.com", "tlf 545 423 236");
        HealthyShop healthyShop = new HealthyShop("Healthy Shop", "extraFoodShop@info.com", "tlf 545 423 236");
        GlutenFreeShop glutenFreeShop = new GlutenFreeShop("GlutenFreeShop", "extraFoodShop@info.com", "tlf 545 423 236");
        LocalDateTime orderDate = LocalDateTime.of(2020,05,15,15,15,10);
        HashMap<Product, Integer> orderList = new HashMap<>();
        Product blackMAcaPowder = new Product("Black Maca Powder", new BigDecimal("100.00"), extraFoodShop);
        Product betrootPowder = new Product("BeetrootPowder", new BigDecimal("100.00"), healthyShop);
        Product organicGoi = new Product("BeetrootPowder", new BigDecimal("100.00"), glutenFreeShop);

        orderList.put(betrootPowder, 1);
        orderList.put(blackMAcaPowder, 2);
        orderList.put(organicGoi, 5);

        return new OrderRequest(orderList, orderDate);
    }

}
