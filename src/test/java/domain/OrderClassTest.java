package domain;

import Builder.orderBuilder.OrderInt;
import factory.orderFactory.OrderFacto;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderClassTest {
    OrderFacto orderFacto=new OrderFacto();
    OrderInt a1=orderFacto.getOrders("order");

    @Test
    public void getOrders()
    {a1.buildCustomerNumber("1001");
    a1.buildOrderNumber("1");
    a1.buildDriverNumber("1200");
    a1.buildCashierId("2222");
    a1.buildTimeOfPlacing("10:20");
    a1.buildTimeOfPickUp("10:30");
    a1.buildTimeOfCompletion("NA");
    a1.buildComment("blague apart");

    String result=a1.getOrders().toString();
        Assert.assertNotNull(a1);
        System.out.println(result);
    }
}