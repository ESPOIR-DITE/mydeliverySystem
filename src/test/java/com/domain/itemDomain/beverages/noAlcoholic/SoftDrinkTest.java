package com.domain.itemDomain.beverages.noAlcoholic;

import com.configPack.ConfigNoAlcohol;
import com.factory.domain.productFactory.nonAlcoholItemFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class SoftDrinkTest {
    nonAlcoholItemFactory nonAlco;
    ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigNoAlcohol.class);
    @Before
    public void setUp() throws Exception {
        nonAlco = (nonAlcoholItemFactory) ctx.getBean("getNonAlcohol");
    }

    @Test
    public void buildItemSize() {
    }

    @Test
    public void buildItemNumber() {
    }

    @Test
    public void buildItemName() {
    }

    @Test
    public void buildItemDescription() {
    }

    @Test
    public void buildItemPrice() {
    }

    @Test
    public void buildCategory() {
    }

    @Test
    public void getNoAlcohol() {
        Assert.assertNotNull(nonAlco);
    }
}