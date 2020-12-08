package com.kodilla.good.patterns.food2door;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private final String name;
    private final BigDecimal price;
    private final Shop shop;

    public Product(String name, BigDecimal price, Shop shop) {
        this.name = name;
        this.price = price;
        this.shop = shop;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Shop getShop() {
        return shop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
                Objects.equals(price, product.price) &&
                Objects.equals(shop, product.shop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, shop);
    }

}
