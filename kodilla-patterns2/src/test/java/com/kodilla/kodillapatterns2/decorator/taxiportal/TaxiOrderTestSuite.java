package com.kodilla.kodillapatterns2.decorator.taxiportal;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class TaxiOrderTestSuite {

    TaxiOrder theOrder = new BasicTaxiOrder();

    @Test
    public void testBasicTaxiOrderGetCost() {

        //When
        BigDecimal calculatedCost = theOrder.getCost();

        //Then
        Assert.assertEquals(new BigDecimal(5), calculatedCost);
    }

    @Test
    public void testBasicTaxiOrderGetDescription() {

        //When
        String description = theOrder.getDescription();

        //Then
        Assert.assertEquals("Drive a course", description);
    }

    @Test
    public void testTaxiNetworkGetCost () {

        //Given
        theOrder = new TaxiNetworkOrderDecorator(theOrder);

        //When
        BigDecimal theCost = theOrder.getCost();

        //Then
        Assert.assertEquals(new BigDecimal(40), theCost);
    }

    @Test
    public void testTaxiNetworkGetDescription() {

        //Given
        theOrder = new TaxiNetworkOrderDecorator(theOrder);

        //When
        String description = theOrder.getDescription();

        //Then
        Assert.assertEquals("Drive a course by Taxi Network", description);
    }

    @Test
    public void testMyTaxiWithChildGetCost() {

        //Given
        theOrder = new MyTaxiNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);

        //When
        BigDecimal theCost = theOrder.getCost();

        //Then
        Assert.assertEquals(new BigDecimal(37), theCost);
    }

    @Test
    public void testMyTaxiWithChildSeatGetDescription() {

        //Given
        theOrder = new MyTaxiNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);

        //When
        String description = theOrder.getDescription();

        //Then
        Assert.assertEquals("Drive a course by My Taxi Network + child seat", description);
    }

    @Test
    public void testUberWithTwoChildSeatsGetCost() {

        //Given
        theOrder = new UberNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);

        //When
        BigDecimal theCost = theOrder.getCost();

        //Then
        Assert.assertEquals(new BigDecimal(29), theCost);
    }

    @Test
    public void testUberWithTwoChildSeatsGetDescription() {

        //Given
        theOrder = new UberNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);

        //When
        String description = theOrder.getDescription();

        //Then
        Assert.assertEquals("Drive a course by Uber Network + child seat + child seat", description);
    }

    @Test
    public void testVipTaxiWithChildSeatExpressGetCost() {

        //Given
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        theOrder = new VipDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        System.out.println(theOrder.getCost());

        //When
        BigDecimal theCost = theOrder.getCost();

        //Then
        Assert.assertEquals(new BigDecimal(52), theCost);
    }

    @Test
    public void testVipTaxiWithChildSeatExpressGetDescription() {

        //Given
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        theOrder = new VipDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        System.out.println(theOrder.getDescription());

        //When
        String description = theOrder.getDescription();

        //Then
        Assert.assertEquals("Drive a course by Taxi Network variant VIP + child seat", description);
    }

}
