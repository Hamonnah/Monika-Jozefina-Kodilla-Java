package com.kodilla.good.patterns.food2door;

import java.util.Map;

public class HealthyShop implements Shop {

    String providersName;
    String providersEmail;
    String providersTelephoneNumber;

    public HealthyShop(String providersName, String providersEmail, String providersTelephoneNumber) {
        this.providersName = providersName;
        this.providersEmail = providersEmail;
        this.providersTelephoneNumber = providersTelephoneNumber;
    }

    @Override
    public boolean order(Map<Product, Integer> products) {
        return true;
    }
}
