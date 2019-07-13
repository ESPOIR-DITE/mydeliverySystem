package com.domain;

import com.Builder.itemBuilder.drink.alcoholProduct.Alcohol;
import com.factory.domain.productFactory.alcoholItemFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GinTest {

    alcoholItemFactory factory = new alcoholItemFactory();
    Alcohol a1 = factory.getAlcohol("gin");

    @Before
    public void setUp()
    {

    }

    @Test
    public void testGin() {
        Assert.assertNotNull(a1);
    }
}