package com.domain.payPack;

import com.Builder.driverPay.DriverPayment;
import com.Builder.driverPay.DriverPaymentProduct;

public class WeeklyPayment implements DriverPayment {
    DriverPaymentProduct driverPaymentProduct;

    public WeeklyPayment() {
        driverPaymentProduct =new DriverPaymentProduct();
    }


    @Override
    public void distance(int distance) {
        driverPaymentProduct.setDistance(distance);
    }

    @Override
    public void paymentRate(int rate) {

        driverPaymentProduct.setRate(rate);
    }

    @Override
    public void numberOfOrder(int number) {
        driverPaymentProduct.setNumberOfOrder(number);
    }

    @Override
    public DriverPaymentProduct getDriverPaymentProduct() {
        return driverPaymentProduct;
    }
}
