package com.domain;

import com.Builder.driverBuilderPack.DriverProduct;
import com.configPack.domainConf.DriverConfig;
import com.factory.domain.driverFactory.DriverFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DriverTest {
    DriverFactory driverFactory;

    ApplicationContext ctx= new AnnotationConfigApplicationContext(DriverConfig.class);

    // Driver driver= driverFactory.getDriver("espoir","dite","espoir@gmail","voortrekker","true");

    /**
     * .setAvaillable(availlable)
     *                     .setSetAddress(address)
     *                     .setSetEmailAddress(emailAddress)
     *                     .setSetName(name)
     *                     .setSetSurName(surName)
     *                     .getDriver();
     */
    @Before
    public void setUp()
    {
        driverFactory=(DriverFactory) ctx.getBean("getDriver");

    }
    @Test
    public void getSetName()
    {
        Assert.assertNotNull(driverFactory);
        Driver driverP=driverFactory.getDriver("driver");
        driverP.buildName("espoir");
        driverP.buildAddress("GoodWood");
        driverP.buildavaillable('y');
        driverP.buildSurName("ditos");
        driverP.buildEmailAddress("yahoo.fr");
        System.out.println(driverP.getDriver().toString());
    }

    @Test
    public void getSetSurName()
    {
       // Assert.assertNotNull();
    }

    @Test
    public void getSetEmailAddress()
    {
        //Assert.assertNotNull(driver.getSetEmailAddress());
    }

    @Test
    public void getSetAddress()
    {
        //Assert.assertNotNull(driver.getSetAddress());
    }

    @Test
    public void getAvaillable()
    {
       // Assert.assertNotNull(driver.getAvaillable());
    }

    @Test
    public void toString1()
    {
        //System.out.println(driver.toString());
    }
}