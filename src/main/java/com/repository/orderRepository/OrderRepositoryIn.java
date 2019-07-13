package com.repository.orderRepository;

import com.Builder.orderBuilder.Orders;
import com.domain.OrderClass;
import com.repository.Irepository;

import java.util.ArrayList;

public interface OrderRepositoryIn extends Irepository<Orders,String>
{
   String insertAll(Orders orders);
    //ArrayList<OrderClass>orderList();
}
