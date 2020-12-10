package com.kodilla.good.patterns.food2door;

public class OrderDeliveryDto {

    public ExtraFoodProvider provider;
    boolean isOrdered;

    public OrderDeliveryDto(ExtraFoodProvider provider, boolean isOrdered) {
        this.provider = provider;
        this.isOrdered = isOrdered;
    }

}
