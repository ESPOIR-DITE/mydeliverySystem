package com.Builder.driverPay;

public interface Payment {
      void payCode(String payCode);
      void distance(int distance);
      void paymentRate(int rate);
      void numberOfOrder(int number);
      void paymentType();
      void buildPayDate(String date);
      void buildDriverNumber(String driverNumber);
      DriverPaymentProduct getDriverPaymentProduct();


}
