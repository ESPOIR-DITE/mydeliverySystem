package com.Builder.driverPay;

public interface Payment {
      void distance(int distance);
      void paymentRate(int rate);
      void numberOfOrder(int number);
      DriverPaymentProduct getDriverPaymentProduct();


}
