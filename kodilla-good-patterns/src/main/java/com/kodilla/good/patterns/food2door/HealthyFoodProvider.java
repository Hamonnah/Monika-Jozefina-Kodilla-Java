package com.kodilla.good.patterns.food2door;

public class HealthyFoodProvider implements FoodProvider {

    String providersName;
    String providersEmail;
    String providersTelephoneNumber;

    public HealthyFoodProvider(String providersName, String providersEmail, String providersTelephoneNumber) {
        this.providersName = providersName;
        this.providersEmail = providersEmail;
        this.providersTelephoneNumber = providersTelephoneNumber;
    }

    @Override
    public void process(Order order) {
        System.out.println("Healthy Food Shop thank you for shopping!");
    }

}
