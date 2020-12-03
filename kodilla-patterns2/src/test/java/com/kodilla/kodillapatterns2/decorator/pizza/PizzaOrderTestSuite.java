package com.kodilla.kodillapatterns2.decorator.pizza;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class PizzaOrderTestSuite {

    PizzaOrder pizzaOrder = new BasicPizza();

    @Test
    public void testBasicPizzaOrderCoast() {

        //When
        BigDecimal basicCost = pizzaOrder.getCost();

        //Then
        Assert.assertEquals(new BigDecimal(15), basicCost);
    }

    @Test
    public void testBasicPizzaOrderDescription() {

        //When
        String basicDescription = pizzaOrder.getDescription();

        //Then
        Assert.assertEquals("Thin dought, tomato sauce, cheese", basicDescription);
    }

    @Test
    public void testPizzaWithThreeToppingsOrderCoast() {

        //Given
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);
        pizzaOrder = new OnionDecorator(pizzaOrder);
        pizzaOrder = new ChickenDecorator(pizzaOrder);

        //When
        BigDecimal basicCost = pizzaOrder.getCost();

        //Then
        Assert.assertEquals(new BigDecimal(30), basicCost);
    }

    @Test
    public void testPizzaWithThreeToppingsOrderDescription() {

        //Given
        pizzaOrder = new ChickenDecorator(pizzaOrder);
        pizzaOrder = new OnionDecorator(pizzaOrder);
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);

        //When
        String description = pizzaOrder.getDescription();

        //Then
        Assert.assertEquals("Thin dought, tomato sauce, cheese, chicken, onion, extra cheese", description);
    }

    @Test
    public void testPizzaWithAllToppingsOrderCoast() {

        //Given
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);
        pizzaOrder = new OnionDecorator(pizzaOrder);
        pizzaOrder = new ChickenDecorator(pizzaOrder);
        pizzaOrder = new PaprikaDecorator(pizzaOrder);

        //When
        BigDecimal coast = pizzaOrder.getCost();

        //Then
        Assert.assertEquals(new BigDecimal(35), coast);
    }

    @Test
    public void testPizzaWithAllToppingsOrderDescription() {

        //Given
        pizzaOrder = new ChickenDecorator(pizzaOrder);
        pizzaOrder = new OnionDecorator(pizzaOrder);
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);
        pizzaOrder = new PaprikaDecorator(pizzaOrder);

        //When
        String description = pizzaOrder.getDescription();

        //Then
        Assert.assertEquals("Thin dought, tomato sauce, cheese, chicken, onion, extra cheese, paprika", description);
    }

}
