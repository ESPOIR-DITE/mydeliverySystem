package com.Builder.driverPay;

public class DrinverPayDirector {
    private DriverPayment driverPayInt=null;
    public DrinverPayDirector(DriverPayment driverPayInt){
        this.driverPayInt = driverPayInt;
    }
    public void constructpayment(int distace,int number,int rate)
    {
        driverPayInt.distance(distace);
        driverPayInt.numberOfOrder(number);
        driverPayInt.paymentRate(rate);

    }
    public DriverPaymentProduct getDriverPaymentProduct()
    {
        return driverPayInt.getDriverPaymentProduct();
    }
}
