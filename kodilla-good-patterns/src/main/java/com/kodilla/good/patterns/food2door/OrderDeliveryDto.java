package com.kodilla.good.patterns.food2door;

public class OrderDeliveryDto {

    public Provider provider;
    boolean isOrdered;

    public OrderDeliveryDto(Provider provider, boolean isOrdered) {
        this.provider = provider;
        this.isOrdered = isOrdered;
    }

}
