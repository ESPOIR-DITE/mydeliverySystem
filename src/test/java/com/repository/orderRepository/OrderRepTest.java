package com.repository.orderRepository;

import com.Builder.orderBuilder.OrderInt;
import com.configPack.repositoryController.OrderRepConfig;
import com.factory.domain.orderFactory.OrderFacto;
import com.factory.repository.OrderRepFact;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class OrderRepTest {
    OrderFacto orderFacto=new OrderFacto();
    OrderInt a1=orderFacto.getOrders("order");

    /**
     * trying to get the bean for the class OrderRep
     * @throws Exception
     */
    OrderRep orderRep;
    ApplicationContext ctx=new AnnotationConfigApplicationContext(OrderRepConfig.class);
    OrderRepFact orderRepFact=(OrderRepFact) ctx.getBean("getOrderRep");



    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create() {
        orderRep= orderRepFact.getOrders("orderRep");
        a1.buildCustomerNumber("1001");
        a1.buildOrderNumber("1");
        a1.buildDriverNumber("1200");
        a1.buildCashierId("2222");
        a1.buildTimeOfPlacing("10:20");
        a1.buildTimeOfPickUp("10:30");
        a1.buildTimeOfCompletion("NA");
        a1.buildComment("blague apart");
        a1.buildOrderCompleted(true);
        orderRep.create(a1.getOrders());
    }

    @Test
    public void update() {
        orderRep= orderRepFact.getOrders("orderRep");
        a1.buildCustomerNumber("1001");
        a1.buildOrderNumber("203202");
        a1.buildDriverNumber("1200");
        a1.buildCashierId("2222");
        a1.buildTimeOfPlacing("10:20");
        a1.buildTimeOfPickUp("10:30");
        a1.buildTimeOfCompletion("done");
        a1.buildComment("blague apart");
        a1.buildOrderCompleted(true);
        orderRep.update(a1.getOrders());
    }

    @Test
    public void delete() {
        orderRep= orderRepFact.getOrders("orderRep");
        orderRep.delete("203202");

    }

    @Test
    public void read() {
        orderRep= orderRepFact.getOrders("orderRep");
        System.out.println(orderRep.read("203202").toString());
    }

    @Test
    public void readAll() {
        ArrayList<String>myList=new ArrayList<>();
        orderRep= orderRepFact.getOrders("orderRep");
        myList=orderRep.getAll();
        for(int i=0;i<myList.size();i++)
        {
            System.out.println(myList.get(i));
        }
    }

    @Test
    public void getItemNumber() {
        orderRep= orderRepFact.getOrders("orderRep");
        System.out.println(orderRep.getItemNumber());
    }

    @Test
    public void insert() {
    }
}