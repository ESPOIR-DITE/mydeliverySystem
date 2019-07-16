package com.factory.repository;

import com.repository.payment.DriverPay.DriverPayRep;

public class DriverPayRepFac {
    private DriverPayRep driverPayRep;
    public DriverPayRep getDriverpayRep(String s)
    {
        if(s.equalsIgnoreCase("driverPayRep"))
        {
            return driverPayRep.getDriverPayRep();
        }
        else return null;
    }
}
