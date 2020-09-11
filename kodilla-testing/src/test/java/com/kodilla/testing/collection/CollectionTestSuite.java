package com.kodilla.testing.collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionTestSuite {

    private static int testCounter = 0;
    @Before
    public void before() {
        testCounter++;
        System.out.println("Test Case: test #" + testCounter + " begin");
    }

    @After
    public void after() {
        System.out.println("Test Case: OK");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //given
        ArrayList<Integer> list = new ArrayList<>();
        OddNumbersExterminator oddNumberExterminator = new OddNumbersExterminator();
        //when
        boolean result = oddNumberExterminator.exterminate(list).isEmpty();
        //then
        System.out.println("testing result: " + result);
        Assert.assertTrue(result);
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        //given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 4, 56, 64, 99));
        ArrayList<Integer> listExpected = new ArrayList<>(Arrays.asList(2, 4, 56, 64));
        //when //then
        System.out.println("testing result: " + listExpected);
        Assert.assertEquals(listExpected, oddNumbersExterminator.exterminate(list));
    }

}
