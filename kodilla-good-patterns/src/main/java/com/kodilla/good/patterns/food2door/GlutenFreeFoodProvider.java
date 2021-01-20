package com.kodilla.good.patterns.food2door;

public class GlutenFreeFoodProvider implements FoodProvider {

    String providersName;
    String providersEmail;
    String providersTelephoneNummber;

    public GlutenFreeFoodProvider(String providersName, String providersEmail, String providersTelephoneNummber) {
        this.providersName = providersName;
        this.providersEmail = providersEmail;
        this.providersTelephoneNummber = providersTelephoneNummber;
    }

    @Override
    public void process(Order order) {
        System.out.println("Gluten Free Food Shop thank you for shopping!");
    }
}
