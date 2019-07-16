package com.service.Driver;

import com.Builder.driverBuilderPack.DriverProduct;
import com.configPack.repositoryController.DriverRepConfig;
import com.factory.repository.DriverRepFact;
import com.repository.drivers.DriverRep;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;

public class DriverService implements DriverServiceInt {
    //injecting driverRepFactory class.
    DriverRepFact driverRep;
    DriverRep driver;
    ApplicationContext ctx= new AnnotationConfigApplicationContext(DriverRepConfig.class);
    private static DriverService driverService=null;

    private DriverService() {
        driverRep=(DriverRepFact) ctx.getBean("getDriverRep");
        driver=driverRep.getDriverRep("driverRep");
    }

    public static DriverService getDriverService() {
        if(driverService==null)
        {
            driverService=new DriverService();
        }return driverService;
    }

    @Override
    public DriverProduct create(DriverProduct driverProduct) {
        return driver.create(driverProduct); // this creates and read what you have created from the database.
    }

    @Override
    public DriverProduct update(DriverProduct driverProduct) {
        return driver.update(driverProduct);
    }

    @Override
    public void delete(String id) {
        driver.delete(id);

    }

    @Override
    public DriverProduct read(String id) {
        return driver.read(id);
    }

    @Override
    public ArrayList readAlll() {
        return driver.getAll();
    }
}
