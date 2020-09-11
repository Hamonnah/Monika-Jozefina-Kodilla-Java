package com.kodilla.spring.introduction.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {

    //Given
    @Autowired
    Calculator calculator;

    @Test
    public void testAddCalculations() {
        //When
        double addResult = calculator.add(1, 2);
        //Then
        assertEquals(3, addResult, 1);
    }

    @Test
    public void testSubCalculations() {
        //When
        double subResult = calculator.sub(2, 1);
        //Then
        assertEquals(1, subResult, 1);
    }

    @Test
    public void testMulCalculations() {
        //When
        double mulResult = calculator.mul(1, 2);
        //Then
        assertEquals(2, mulResult, 1);
    }

    @Test
    public void testDivCalculations() {
        //When
        double divResult = calculator.div(2, 1);
        //Then
        assertEquals(2, divResult, 1);
    }

}
