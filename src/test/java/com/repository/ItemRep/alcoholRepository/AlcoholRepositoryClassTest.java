package com.repository.ItemRep.alcoholRepository;

import com.Builder.itemBuilder.drink.alcoholProduct.Alcohol;
import com.configPack.ConfigAlcohol;
import com.factory.domain.productFactory.alcoholItemFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class AlcoholRepositoryClassTest {

    alcoholItemFactory alcoholItem;

    ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigAlcohol.class);
    AlcoholRepositoryClass alcoholRepositoryClass=AlcoholRepositoryClass.getAlcoholRepository();
    //alcohol = (Alcohol) ctx.getBean("getBeer");
    @Before
   public void setUp()
    {
       // ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigBeer.class);
        alcoholItem = (alcoholItemFactory) ctx.getBean("getBeer");

    }
    @Test
    public void create() {
        Alcohol a1=alcoholItem.getAlcohol("beer");
        Assert.assertNotNull(a1);
        a1.percentageOfAlcohol("12");
        a1.buildCategory("BEER");
        a1.buildItemDescription("none");
        a1.buildItemName("castel");
        a1.buildItemPrice(32);
        a1.buildItemSize('s');
        a1.buildItemNumber("23232");
        System.out.println(a1.getAlcoholProduct().toString());
        alcoholRepositoryClass.create(a1.getAlcoholProduct());

    }

    @Test
    public void update() {

    }

    @Test
    public void delete() {
    }

    @Test
    public void read() {
    }

    @Test
    public void readAll() {
    }
}