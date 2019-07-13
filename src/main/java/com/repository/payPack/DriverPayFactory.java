package com.repository.payPack;

import com.Builder.driverPay.Payment;
import com.domain.payPack.DailyPayment;
import com.domain.payPack.MounthlyPayments;
import com.domain.payPack.WeeklyPayment;

public class DriverPayFactory {
    public Payment getDriverPay(String s)
    {
        if(s.equalsIgnoreCase("week"))
        {
            return new WeeklyPayment();
        }
        else if(s.equalsIgnoreCase("mounth"))
        {
            return new MounthlyPayments();
        }
        else if(s.equalsIgnoreCase("day"))
        {
            return new DailyPayment();
        }
        else return null;
    }

}
