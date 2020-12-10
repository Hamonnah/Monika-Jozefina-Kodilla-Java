package com.kodilla.good.patterns.food2door;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private final String name;
    private final BigDecimal price;
    private final Provider provider;

    public Product(String name, BigDecimal price, Provider provider) {
        this.name = name;
        this.price = price;
        this.provider = provider;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Provider getShop() {
        return provider;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
                Objects.equals(price, product.price) &&
                Objects.equals(provider, product.provider);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, provider);
    }

}
