package factory.orderFactory;

import Builder.orderBuilder.OrderInt;
import domain.OrderClass;

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
