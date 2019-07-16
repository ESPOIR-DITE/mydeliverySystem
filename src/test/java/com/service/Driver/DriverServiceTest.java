package com.service.Driver;

import com.configPack.domainConf.DriverConfig;
import com.domain.Driver;
import com.factory.domain.driverFactory.DriverFactory;
import com.factory.services.DriverServeiceFac;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DriverServiceTest {
    private DriverServeiceFac driverServeiceFac=new DriverServeiceFac();
    DriverService driverService;

    //trying to get Driver builder
    Driver driverP;
    DriverFactory driverFactory;
    ApplicationContext ctx2= new AnnotationConfigApplicationContext(DriverConfig.class);


    @Before
    public void setUp() throws Exception {
        driverService=driverServeiceFac.getDriverS("driverService");

        driverFactory=(DriverFactory) ctx2.getBean("getDriver");
        driverP=driverFactory.getDriver("driver");
    }

    @Test
    public void getDriverService() {
        Assert.assertNotNull(driverService);
    }

    @Test
    public void create() {
        driverP.buildName("PAOLO");
        driverP.buildAddress("KANANGA");
        driverP.buildavaillable('Y');
        driverP.buildSurName("BUDIS");
        driverP.buildEmailAddress("google.fr");
        driverP.buildPhone_number("34353523");
        System.out.println(driverService.create(driverP.getDriver()).toString());
        //System.out.println(driverP.getDriver().toString());
    }

    @Test
    public void update() {
        driverP.buildDriverCode("1002");
        driverP.buildName("ESPOIR");
        driverP.buildAddress("GoodWood");
        driverP.buildavaillable('y');
        driverP.buildSurName("kaping");
        driverP.buildEmailAddress("google.fr");
        driverP.buildPhone_number("34353523");
        System.out.println(driverService.update(driverP.getDriver()).toString());
    }

    @Test
    public void delete() {
        driverService.delete("1003");
    }

    @Test
    public void read() {
        System.out.println(driverService.read("1002").toString());
    }

    @Test
    public void readAlll() {
        ArrayList<String>myList=new ArrayList();
        myList=driverService.readAlll();
        for(int i=0;i<myList.size();i++)
        {
            System.out.println(myList.get(i));
        }
    }
}