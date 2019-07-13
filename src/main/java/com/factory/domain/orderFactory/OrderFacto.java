package com.factory.domain.orderFactory;

import com.Builder.orderBuilder.OrderInt;
import com.domain.OrderClass;

/****THIS IS THE FACTORY OF THE ORDER*/
public class OrderFacto
{
    public OrderInt getOrders( String order)
    {
        if(order.equalsIgnoreCase("order"))
        return new OrderClass();
        else return null;
    }
}
