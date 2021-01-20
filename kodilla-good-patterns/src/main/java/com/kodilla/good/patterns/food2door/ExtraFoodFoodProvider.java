package com.kodilla.good.patterns.food2door;

public class ExtraFoodFoodProvider implements FoodProvider {

    String providersName;
    String providersEmail;
    String providersTelephoneNummber;

    public ExtraFoodFoodProvider(String providersName, String providersEmail, String providersTelephoneNummber) {
        this.providersName = providersName;
        this.providersEmail = providersEmail;
        this.providersTelephoneNummber = providersTelephoneNummber;
    }

    @Override
    public void process(Order order) {
        System.out.println("Extra Food Shop thank you for shopping!");
    }

}
