package com.factory.domain.paymentfacto;

import com.Builder.driverPay.DriverPayment;
import com.domain.payPack.DailyPayment;
import com.domain.payPack.MounthlyPayments;
import com.domain.payPack.WeeklyPayment;


public class PaymentFactory {

    public static DriverPayment getDriverPayInt(String valeu)
    {
        if(valeu.equalsIgnoreCase("week"))
        {
            return new WeeklyPayment();
        }if(valeu.equalsIgnoreCase("month"))
        {
            return new MounthlyPayments();
        }
        if(valeu.equalsIgnoreCase("day"))
        {return new DailyPayment();}
        else return null;

    }
}
