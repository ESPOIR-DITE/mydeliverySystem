package com.factory.domain.driverFactory;

import com.domain.Driver;

public class DriverFactory {
    Driver driver ;
    public Driver getDriver(String name)
    {
        if(name.equalsIgnoreCase("driver")) {
            return new Driver();

        }else return null;


    }
}
