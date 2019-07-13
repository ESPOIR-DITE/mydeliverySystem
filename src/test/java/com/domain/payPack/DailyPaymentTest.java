package com.domain.payPack;

import com.Builder.driverPay.Payment;
import com.factory.domain.paymentfacto.PaymentFactory;
import org.junit.Assert;
import org.junit.Test;

public class DailyPaymentTest {
    /**
     * in this class i need to make a difference between those who are working daily and weekly*/

    Payment payment;

    @Test
    public void getDriverPaymentProduct() {
        PaymentFactory paymentFactory = new PaymentFactory();
        Payment b1=paymentFactory.getDriverPayInt("month");
        b1.distance(10);
        b1.numberOfOrder(10);
        b1.paymentRate(20);
        String valeu1=b1.toString();
        String value2=b1.getDriverPaymentProduct().toString();
        System.out.println(valeu1+"<<<<<value1#value2>>>>>"+value2);

        Assert.assertNotNull(b1);
    }
}