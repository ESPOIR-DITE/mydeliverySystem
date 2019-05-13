package factory.paymentfacto;

import Builder.paymentbuilders.DriverPayment;
import domain.payPack.DailyPayment;
import domain.payPack.MounthlyPayments;
import domain.payPack.WeeklyPayment;


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
