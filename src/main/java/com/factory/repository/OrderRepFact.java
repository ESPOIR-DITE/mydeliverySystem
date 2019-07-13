package com.factory.repository;

import com.repository.orderRepository.OrderRep;

public class OrderRepFact {
    OrderRep orderRep;
    public OrderRep getOrders(String s)
    {
        if(s.equalsIgnoreCase("orderRep"))
        {
            return orderRep.getOrders();
        }
        return null;

    }
}
