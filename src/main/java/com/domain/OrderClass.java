package com.domain;

import com.Builder.orderBuilder.OrderInt;
import com.Builder.orderBuilder.Orders;

public class OrderClass implements OrderInt {
    private Orders orders;

    public OrderClass() {
        orders = new Orders();
    }


    @Override
    public void buildOrderNumber(String orderNumber) {
       orders.setOrderNumeber(orderNumber);
    }

    @Override
    public void buildCustomerNumber(String customerNumber) {
        orders.setCustomerNumber(customerNumber);
    }

    @Override
    public void buildDriverNumber(String driverNumber) {
        orders.setDriverNumber(driverNumber);
    }

    @Override
    public void buildTimeOfPlacing(String timeOfPlacing) {
        orders.setTimeOfPlacing(timeOfPlacing);
    }

    @Override
    public void buildTimeOfPickUp(String timeOfPickUp) {
        orders.setTimeOfPickUp(timeOfPickUp);
    }

    @Override
    public void buildCashierId(String cashierNumber) {
        orders.setCashierId(cashierNumber);
    }

    @Override
    public void buildOrderCompleted(boolean orderCompleted) {
        orders.setOrderCompleted(orderCompleted);
    }

    @Override
    public void buildTimeOfCompletion(String timeOfCompletion) {
        orders.setTimeOfComplition(timeOfCompletion);
    }

    @Override
    public void buildComment(String comment) {
        orders.setComment(comment);
    }

    @Override
    public Orders getOrders() {
        return orders;
    }
}