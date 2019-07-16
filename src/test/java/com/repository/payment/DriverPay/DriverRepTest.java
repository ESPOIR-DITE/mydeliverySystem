package com.repository.payment.DriverPay;

import com.configPack.domainConf.DriverConfig;
import com.configPack.repositoryController.DriverRepConfig;
import com.domain.Driver;
import com.factory.domain.driverFactory.DriverFactory;
import com.factory.repository.DriverRepFact;
import com.repository.drivers.DriverRep;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;

public class DriverRepTest {

    DriverRepFact driverRep;
    DriverRep driver;


    DriverFactory driverFactory;

    ApplicationContext ctx2= new AnnotationConfigApplicationContext(DriverConfig.class);

    ApplicationContext ctx= new AnnotationConfigApplicationContext(DriverRepConfig.class);
    @Before
    public void setUp() throws Exception {
        driverRep=(DriverRepFact) ctx.getBean("getDriverRep");
        driverFactory=(DriverFactory) ctx2.getBean("getDriver");
    }

    @Test
    public void getInstance() {
        driver=driverRep.getDriverRep("driverRep");
        Assert.assertNotNull(driverRep);
        Driver driverP=driverFactory.getDriver("driver");
        driverP.buildName("JOSEPH");
        driverP.buildAddress("KANANGA");
        driverP.buildavaillable('N');
        driverP.buildSurName("BUDIS");
        driverP.buildEmailAddress("google.fr");
        driverP.buildPhone_number("34353523");


        System.out.println(driver.create(driverP.getDriver()).toString());
    }

    @Test
    public void create() {
        driver=driverRep.getDriverRep("driverRep");
        Assert.assertNotNull(driverRep);

        Driver driverP=driverFactory.getDriver("driver");
        Assert.assertNotNull(driver);
    }

    @Test
    public void update() {
        driver=driverRep.getDriverRep("driverRep");
        Assert.assertNotNull(driverRep);

        Driver driverP=driverFactory.getDriver("driver");
        Assert.assertNotNull(driver);

        driverP.buildDriverCode("1001");
        driverP.buildName("jacky");
        driverP.buildAddress("GoodWood");
        driverP.buildavaillable('y');
        driverP.buildSurName("kaping");
        driverP.buildEmailAddress("google.fr");
        driverP.buildPhone_number("34353523");

        driver.update(driverP.getDriver());                                             // calling the DriverRep class method
    }

    @Test
    public void delete() {
        driver=driverRep.getDriverRep("driverRep");
        driver.delete("1001");
    }

    @Test
    public void read() {
        driver=driverRep.getDriverRep("driverRep");
        System.out.println(driver.read("1002").toString());
    }

    @Test
    public void readAll() {
        ArrayList<String> myList=new ArrayList<>();
        driver=driverRep.getDriverRep("driverRep");
        myList=driver.getAll();
        for(int i=0;i<myList.size();i++)
        {
            System.out.println(i+". "+myList.get(i)+"\n");
        }

    }

    @Test
    public void getItemNumber() {
        driver=driverRep.getDriverRep("driverRep");
        System.out.println(driver.getItemNumber());
    }
}