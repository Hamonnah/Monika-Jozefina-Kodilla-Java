package com.kodilla.good.patterns.food2door;

public class OrderRetriver {

    public Order retrieve() {

        Customer customer = new Customer("Helmut", "helmut@helmut");

        Supplier extraFoodShop = new SupplierExtraFoodShop("ExtraFoodShop", "extra@gmail.com");
        Supplier healthyShop = new SupplierHealthyShop("Healthy Shop", "healthy@gmail.com");
        Supplier glutenFreeShop = new SupplierGlutenFreeShop("GlutenFree Shop", "gluten@shop.pl");

        Product bread = new Product("bread", new BigDecimal("3.2"), extraFoodShop);
        Product sausage = new Product("sausage", new BigDecimal("25.50"), healthyShop);
        Product butter = new Product("butter", new BigDecimal("4.35"), glutenFreeShop);
        Product milk = new Product("milk", new BigDecimal("2.35"), glutenFreeShop);
        Product wholemealBread = new Product("wholemeal bread", new BigDecimal("4.35"), extraFoodShop);
        Product flour = new Product("flour", new BigDecimal("2.95"), healthyShop);

        Map<Product, Integer> orderedProducts = new HashMap<>();
        orderedProducts.put(bread, 3);
        orderedProducts.put(sausage, 4);
        orderedProducts.put(butter, 7);
        orderedProducts.put(milk, 4);
        orderedProducts.put(wholemealBread, 1);
        orderedProducts.put(flour, 1);

        return new Order(customer, orderedProducts);
    }
}
