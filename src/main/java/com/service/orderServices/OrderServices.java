package com.service.orderServices;

import com.Builder.orderBuilder.OrderInt;
import com.Builder.orderBuilder.Orders;
import com.factory.domain.orderFactory.OrderFacto;
import com.repository.orderRepository.OrderRep;
import com.service.IOrder;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class OrderServices implements IOrder {
    @Autowired
    @Qualifier("orderService")
    private static OrderServices orderServices=null;
    private OrderRep orderRep=OrderRep.getOrders();
    OrderFacto orderFacto=new OrderFacto();
    OrderInt setterObject=orderFacto.getOrders("order");

    private OrderServices()
    {

    }
    public static OrderServices getInstance()
    {
        if(orderServices==null)
        {
            orderServices=new OrderServices();
        }
        return orderServices;
    }

    @Override
    public Object create(Object o) {
        return null;
    }

    @Override
    public Object update(Object o) {
        return null;
    }

    @Override
    public void delete(ID id) {

    }

    @Override
    public Object read(ID id) {
        return null;
    }

    @Override
    public Object readAlll()
    {
        //orderRep.readAll("nothing");
        return orderRep.readAll("nothing");
    }
    public void insertRow(Orders orders)
    {
        setterObject.buildOrderNumber(orders.getOrderNumeber());
        setterObject.buildCustomerNumber(orders.getCustomerNumber());
        setterObject.buildCashierId(orders.getCashierId());
        setterObject.buildDriverNumber(orders.getDriverNumber());
        setterObject.buildComment(orders.getComment());
        setterObject.buildTimeOfPlacing(orders.getTimeOfPlacing());
        setterObject.buildTimeOfCompletion(orders.getTimeOfComplition());
        setterObject.buildTimeOfPickUp(orders.getTimeOfPickUp());
        setterObject.buildOrderCompleted(orders.isOrderCompleted());
        System.out.println(orderRep.insertAll(setterObject.getOrders()));

    }
}
