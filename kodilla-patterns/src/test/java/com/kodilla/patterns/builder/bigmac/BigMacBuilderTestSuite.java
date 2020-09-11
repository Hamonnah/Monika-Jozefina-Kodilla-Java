package com.kodilla.patterns.builder.bigmac;

import org.junit.Test;

import static org.junit.Assert.*;

public class BigMacBuilderTestSuite {

    @Test
    public void testBigmacBuilder() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                        .bun(Bun.SESAME_SEED_BUN)
                        .sauce(Sauce.BARBECUE)
                        .burgers(2)
                        .ingredient(Ingredient.BECON)
                        .build();
        //When
        int howManyBurgers = bigmac.getBurgers();
        int howManyIngredients = bigmac.getIngredients().size();
        String sauceType = bigmac.getSauce().toString();
        String bunType = bigmac.getBun().toString();
        //Then
        assertEquals(1, howManyIngredients);
        assertEquals(2, howManyBurgers);
        assertEquals("BARBECUE", sauceType);
        assertEquals("SESAME_SEED_BUN", bunType);
    }

}
