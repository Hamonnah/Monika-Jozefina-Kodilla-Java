package com.kodilla.good.patterns.food2door;

import java.math.BigDecimal;

public class Product {

    private final String productName;
    private final BigDecimal price;
    private final Provider provider;

    public Product(String productName, BigDecimal price, Provider provider) {
        this.productName = productName;
        this.price = price;
        this.provider = provider;
    }

    public String getProductName() {
        return productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Provider getSupplier() {
        return provider;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!productName.equals(product.productName)) return false;
        if (!price.equals(product.price)) return false;
        return provider.equals(product.provider);
    }

    @Override
    public int hashCode() {
        int result = productName.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + provider.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", provider=" + provider +
                '}';
    }

}
