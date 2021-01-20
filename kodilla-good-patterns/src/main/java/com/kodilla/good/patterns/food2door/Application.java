package com.kodilla.good.patterns.food2door;

public class Application {

    private static User user;
    private static Provider provider;
    private static HealthyFoodProvider healthyFoodProvider;
    private static ExtraFoodFoodProvider extraFoodFoodProvider;

    private static Product product1, product2, healthyProduct1;

    public static void main(String[] args) {
        createUsers();
        createSuppliers();
        OrderProcessor foodOrderManager = new OrderProcessor();
        foodOrderManager.processOrder(provider, new Order(product1, 20, user));
        foodOrderManager.processOrder(extraFoodFoodProvider, new Order(product2, 1000, user));
        foodOrderManager.processOrder(healthyFoodProvider, new Order(healthyProduct1, 1, user));
    }

    private static void createUsers() {
        user = new User("Jan Kowalski", "jkowal@ski.pl",
                "ul. Potokowa 23, 23-324 Puck", 984364578);
    }

    private static void createSuppliers() {
        provider = new Provider("ExtraFoodShop");
        product1 = new Product("Ciastka", 2);
        product1.addQuantity(100);
        provider.addProduct(product1);

        product2 = new Product("Baton", 4);
        product2.addQuantity(200);
        provider.addProduct(product2);

        healthyFoodProvider = new HealthyFoodProvider("HealthyShop", "helthy@helthy.com", "123 456 789");
        healthyProduct1 = new Product("Ciastka sojowe", 5);
        healthyProduct1.addQuantity(12);

        extraFoodFoodProvider = new ExtraFoodFoodProvider("Extra Food Shop", "extra@extra.com", "987 654 321");
    }

}
