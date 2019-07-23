package com.service.itemServicePack;

import com.Builder.itemBuilder.drink.noAlcoholProduct.NoAlcoholicItemInterface;
import com.configPack.ConfigNoAlcohol;
import com.factory.domain.productFactory.nonAlcoholItemFactory;
import com.factory.repository.NonAlcoholRepFact;
import com.factory.services.ItemServicesFact;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ItemClassServiceTest {
   // ItemClassService itemClassService= ItemClassService.getItemClass();
    ItemServicesFact itemServicesFact=new ItemServicesFact();
    ItemClassService itemClassService=itemServicesFact.getItemClassService("itemServices");

 nonAlcoholItemFactory nonAlco;
 ApplicationContext ctx2 = new AnnotationConfigApplicationContext(ConfigNoAlcohol.class);

 @Before
 public void setUp()
 {

  nonAlco = (nonAlcoholItemFactory) ctx2.getBean("getNonAlcohol");

 }


    @Test
    public void getItemClass() {
       // Assert.assertNotNull(itemClassService);
    }

    @Test
    public void myItemList() {

    }

    @Test
    public void create() {
     NoAlcoholicItemInterface product=nonAlco.getNonAlcohol("cooldrink");
     product.buildItemDescription("none");
     product.buildItemName("coke");
     product.buildCategory("cooldrink");
     product.buildItemNumber("12342");
     product.buildItemPrice(10);
     product.buildItemSize('m');

     itemClassService.create(product.getNoAlcohol()).toString();
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
     itemClassService.delete("23236");
    }

    @Test
    public void read() {
     System.out.println(itemClassService.read("23236").toString());
    }

    @Test
    public void readAll()
    {
       // Assert.assertNotNull(itemClassService.readAlll());
       // System.out.println(itemClassService.readAlll());
    }




}