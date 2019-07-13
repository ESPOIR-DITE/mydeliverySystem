package com.domain;

import com.Builder.itemBuilder.drink.alcoholProduct.Alcohol;
import com.configPack.domainConf.BeerConfig;
import com.factory.domain.productFactory.alcoholItemFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeerTest {
    private Alcohol alcohol;
    alcoholItemFactory factory=new alcoholItemFactory();
    Alcohol a1 =factory.getAlcohol("beer");
    @Before
    public void setUp()
    {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BeerConfig.class);
        alcohol=(Alcohol)ctx.getBean("myBeer");


    }
    /**
     * in this test class i have started by getting the class that i am testing over the
     * config class (BeerConfig) which is returning a beer object.
     * the factory object help us to build.
     *
     */
    @Test
    public void getId() {


        Assert.assertNotNull(a1);
    }
    @Test
    public void beerObjectTest()
    {

        Assert.assertNotNull(alcohol);
    }
}