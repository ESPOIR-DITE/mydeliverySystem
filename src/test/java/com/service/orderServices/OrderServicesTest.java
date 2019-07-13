package com.service.orderServices;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderServicesTest {
    OrderServices orderServices=OrderServices.getInstance();

    @Test
    public void create()
    {
        orderServices.readAlll();
        Assert.assertNotNull(orderServices);
    }

    @Test
    public void update()
    {

    }

    @Test
    public void delete() {
    }

    @Test
    public void read() {
    }

    @Test
    public void readAlll() {
    }

    @Test
    public void insertRow() {
    }
}