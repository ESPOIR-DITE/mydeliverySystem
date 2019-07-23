package com.repository.ItemRep.classicProducat;

import com.Builder.itemBuilder.classicProduct.ClassiProductInterface;
import com.configPack.repositoryController.ClassicRepConfig;
import com.factory.domain.productFactory.ClassicItemFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class ClassicProductRepTest {
    ApplicationContext ctx=new AnnotationConfigApplicationContext(ClassicRepConfig.class);
    ClassicProductRep classRep=(ClassicProductRep) ctx.getBean("getClassicRep");

    //getting the clssicProduct
    ClassicItemFactory clasFac=new ClassicItemFactory();
    ClassiProductInterface getClassicP=clasFac.getClassicProduct("cigaratte");


    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getClassic() {
        Assert.assertNotNull(classRep);
        Assert.assertNotNull(getClassicP);
    }

    @Test
    public void create() {

        getClassicP.flavor("vanila");
        getClassicP.buildCategory("snake");
        getClassicP.buildItemDescription("none");
        getClassicP.buildItemName("suite");
        getClassicP.buildItemPrice(30);
        System.out.println(classRep.create(getClassicP.getClassic()).toString());
    }

    @Test
    public void update() {

    }

    @Test
    public void delete() {
        classRep.delete("1003");
    }

    @Test
    public void read() {
        System.out.println(classRep.read("1000").toString());
    }

    @Test
    public void readAll() {
    }

    @Test
    public void getAll() {
    }

    @Test
    public void getItemNumber() {
    }
}