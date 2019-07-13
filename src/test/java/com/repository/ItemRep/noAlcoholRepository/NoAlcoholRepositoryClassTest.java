package com.repository.ItemRep.noAlcoholRepository;

import com.Builder.itemBuilder.drink.noAlcoholProduct.NoAlcoholicItemInterface;
import com.Builder.itemBuilder.drink.noAlcoholProduct.NoAlcoholicProduct;
import com.configPack.ConfigAlcohol;
import com.configPack.ConfigNoAlcohol;
import com.configPack.repositoryController.NonAlcolRepConfig;
import com.domain.itemDomain.beverages.noAlcoholic.Juice;
import com.factory.domain.productFactory.nonAlcoholItemFactory;
import com.factory.repository.NonAlcoholRepFact;
import com.repository.ItemRep.alcoholRepository.AlcoholRepositoryClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;

public class NoAlcoholRepositoryClassTest {

    NonAlcoholRepFact nonAlcoholRepFact;
    NoAlcoholRepositoryClass noAlcoholRepositoryClass;
    ApplicationContext ctx = new AnnotationConfigApplicationContext(NonAlcolRepConfig.class);

    //for getting the nonAlcoholItemFactory class that will help to build an item
    nonAlcoholItemFactory nonAlco;
    ApplicationContext ctx2 = new AnnotationConfigApplicationContext(ConfigNoAlcohol.class);
    @Before
    public void setUp()
    {
        nonAlcoholRepFact = (NonAlcoholRepFact) ctx.getBean("nonRep");

        nonAlco = (nonAlcoholItemFactory) ctx2.getBean("getNonAlcohol");

    }

    @Test
    public void create()
    {

        noAlcoholRepositoryClass= nonAlcoholRepFact.getRepNonAlco("nonAlcohol");

       // Assert.assertNotNull(noAlcoholRepositoryClass);


        //testing if i can create a product
        /**
         * first creating an object with the interface so that it can allow me to create any type od nonalcohol product
         * second line start building a cooldrink
         */
        NoAlcoholicItemInterface product=nonAlco.getNonAlcohol("cooldrink");
        product.buildItemDescription("none");
        product.buildItemName("coke");
        product.buildCategory("cooldrink");
        product.buildItemNumber("12342");
        product.buildItemPrice(10);
        product.buildItemSize('m');
       // NoAlcoholicProduct myProduct= product.getNoAlcohol().toString();
        System.out.println(product.getNoAlcohol().toString());

        /**
         * sending the product created to the repository
         */
        noAlcoholRepositoryClass.create(product.getNoAlcohol());



    }

    @Test
    public void update() {
        noAlcoholRepositoryClass= nonAlcoholRepFact.getRepNonAlco("nonAlcohol");
        NoAlcoholicItemInterface product=nonAlco.getNonAlcohol("cooldrink");
        product.buildItemDescription("none");
        product.buildItemName("coke");
        product.buildCategory("cooldrink");
        product.buildItemNumber("23232");
        product.buildItemPrice(10);
        product.buildItemSize('m');
        System.out.println(noAlcoholRepositoryClass.update(product.getNoAlcohol()));
    }

    @Test
    public void delete() {
        noAlcoholRepositoryClass= nonAlcoholRepFact.getRepNonAlco("nonAlcohol");
        noAlcoholRepositoryClass.delete("0");
    }

    @Test
    public void read() {

        NoAlcoholicItemInterface product=nonAlco.getNonAlcohol("cooldrink");

        noAlcoholRepositoryClass= nonAlcoholRepFact.getRepNonAlco("nonAlcohol");
        NoAlcoholicProduct p = noAlcoholRepositoryClass.read("23236");
        System.out.println(p.toString());

    }

    @Test
    public void readAll() {
        ArrayList<NoAlcoholicProduct> myList ;
        noAlcoholRepositoryClass= nonAlcoholRepFact.getRepNonAlco("nonAlcohol");
        myList= noAlcoholRepositoryClass.getAll();
        for (int i=0; i<myList.size();i++)
        {
            System.out.println(myList.get(i));
        }
    }
}