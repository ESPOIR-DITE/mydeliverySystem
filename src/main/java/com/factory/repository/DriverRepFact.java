package com.factory.repository;

import com.repository.drivers.DriverRep;

public class DriverRepFact {
    DriverRep driverRep;
    public DriverRep getDriverRep(String s)
    {
        if(s.equalsIgnoreCase("driverRep"))
        {
            return driverRep.getInstance();
        }else return null;
    }
}
