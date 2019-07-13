package com.Builder.orderBuilder;

public interface OrderInt
{
     void buildOrderNumber(String orderNumber);
     void buildCustomerNumber(String customerNumber);
     void buildDriverNumber(String driverNumber);
     void buildTimeOfPlacing(String timeOfPlacing);
     void buildTimeOfPickUp(String timeOfPickUp);
     void buildCashierId(String cashierNumber);
     void buildOrderCompleted(boolean orderCompleted);
     void buildTimeOfCompletion(String timeOfCompletion);
     void buildComment(String comment);
     Orders getOrders();

}
