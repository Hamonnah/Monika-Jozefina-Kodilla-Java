package com.kodilla.good.patterns.food2door;

public class OrderDeliveryDto {

    public ExtraFoodShop provider;
    boolean isOrdered;

    public OrderDeliveryDto(ExtraFoodShop provider, boolean isOrdered) {
        this.provider = provider;
        this.isOrdered = isOrdered;
    }

}
