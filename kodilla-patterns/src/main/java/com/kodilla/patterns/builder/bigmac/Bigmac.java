package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {

    private final int burgers;
    private final Sauce sauce;
    private final Bun bun;
    private final List<Ingredient> ingredients;

    public Bigmac(int burgers, Sauce sauce, Bun bun, List<Ingredient> ingredients) {
        this.burgers = burgers;
        this.sauce = sauce;
        this.bun = bun;
        this.ingredients = ingredients;
    }

    public Bun getBun() {
        return bun;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public int getBurgers() {
        return burgers;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Your Bigmac {" +
                "bun = '" + bun + '\'' +
                ", sauce = '" + sauce + '\'' +
                ", burgers = " + burgers +
                ", extra ingedients = " + ingredients +
                '}';
    }

    public static class BigmacBuilder {
        private Bun bun;
        private Sauce sauce;
        private int burgers;
        private List<Ingredient> ingredients = new ArrayList<>();

        public BigmacBuilder ingredient(Ingredient ingredient) {
            this.ingredients.add(ingredient);
            return this;
        }

        public BigmacBuilder bun(Bun bun) {
            this.bun = bun;
            return this;
        }

        public BigmacBuilder sauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder burgers(int burgersQuantity) {
            this.burgers = burgersQuantity;
            return this;
        }

        public Bigmac build() {
            return new Bigmac(burgers, sauce, bun, ingredients);
        }
    }

}
