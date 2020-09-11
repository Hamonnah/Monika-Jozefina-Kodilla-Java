package com.kodilla.good.patterns.food2door;

import java.time.LocalDateTime;
import java.util.HashMap;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {
        Provider provider = new Provider("ExtraFoodShop", "extraFoodShop@info.com", "tlf 545 423 236");
        LocalDateTime orderDate = LocalDateTime.of(2020,05,15,15,15,10);
        HashMap<Product, Integer> orderList = new HashMap<>();
        orderList.put(Product.ORGANIC_BLACK_MACA_POWDER, 1);
        orderList.put(Product.BEETROOT_POWDER, 2);
        orderList.put(Product.ORGANIC_GOJI_BERRIES, 5);

        return new OrderRequest(provider, orderList, orderDate);
    }

}
