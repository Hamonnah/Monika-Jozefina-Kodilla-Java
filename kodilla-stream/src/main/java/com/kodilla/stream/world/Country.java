package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.Objects;

public final class Country {

    private final String countryName;
    private final BigDecimal peopleQuantity;

    /*BigDecimal getPeopleQuantity() {
        BigDecimal numberOfPeople = new BigDecimal("12333");
        return numberOfPeople;
    }*/

    public Country(String countryName, BigDecimal peopleQuantity) {
        this.countryName = countryName;
        this.peopleQuantity = peopleQuantity;
    }

    public String getCountryName() {
        return countryName;
    }

    public BigDecimal getPeopleQuantity() {
        return peopleQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;
        Country country = (Country) o;
        return getCountryName().equals(country.getCountryName()) &&
                getPeopleQuantity().equals(country.getPeopleQuantity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCountryName(), getPeopleQuantity());
    }

}
