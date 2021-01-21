package com.kodilla.good.patterns.food2door;

public class SupplierGlutenFreeShop implements Supplier {

    private final String name;
    private final String email;

    public SupplierGlutenFreeShop(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean process(Order order) {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SupplierGlutenFreeShop that = (SupplierGlutenFreeShop) o;

        if (!name.equals(that.name)) return false;
        return email.equals(that.email);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "SupplierGlutenFreeShop{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
