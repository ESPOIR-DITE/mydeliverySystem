package factory;

import Builder.paymentbuilders.DailyPayment;
import Builder.paymentbuilders.MounthlyPayments;
import Builder.paymentbuilders.WeeklyPayment;
import Builder.paymentbuilders.DriverPayInt;

public class PaymentFactory {

    public static DriverPayInt getDriverPayInt(String valeu)
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
