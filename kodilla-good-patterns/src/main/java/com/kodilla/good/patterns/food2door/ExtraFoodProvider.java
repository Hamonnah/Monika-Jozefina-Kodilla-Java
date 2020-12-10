package com.kodilla.good.patterns.food2door;

import java.util.Map;

public class ExtraFoodProvider implements Provider {

    String providersName;
    String providersEmail;
    String providersTelephoneNummber;

    public ExtraFoodProvider(String providersName, String providersEmail, String providersTelephoneNummber) {
        this.providersName = providersName;
        this.providersEmail = providersEmail;
        this.providersTelephoneNummber = providersTelephoneNummber;
    }

    @Override
    public boolean order(Map<Product, Integer> products) {
        return true;
    }
}
