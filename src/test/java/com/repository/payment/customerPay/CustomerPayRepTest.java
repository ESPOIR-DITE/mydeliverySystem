package com.repository.payment.customerPay;

import com.Builder.customerPaymentBuilder.CustomerpaymentInterface;
import com.factory.domain.customerPaymentFactory.customerPayFactory;
import com.factory.repository.CustomerPayFact;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CustomerPayRepTest {
    /**
     * getting the customerRep object through its factory.
     * @throws Exception
     */
    CustomerPayFact customerPayFact=new CustomerPayFact();
    CustomerPayRep customerPayRep= customerPayFact.getCustPayRep("customerRep");

    /**
     * now we are going to get customerProduct to build.
     * @throws Exception
     */
    customerPayFactory custF=new customerPayFactory();
    CustomerpaymentInterface custI;

    @Before
    public void setUp() throws Exception {
        custI=custF.getCustPayment("cash");
    }

    @Test
    public void create() {
        Assert.assertNotNull(customerPayRep);
        Assert.assertNotNull(custI);

        custI.buildVat(0);
        custI.buildTip(0);
        custI.buildArangement(0);
        custI.buildSale(0);
        custI.buildCustomer("102");
        custI.buildOrderNumber("80");
        custI.buildAmount(3590);
        custI.builPayment_type("cash");
        customerPayRep.create(custI.getCustPayment());
    }

    @Test
    public void update() {
        Assert.assertNotNull(customerPayRep);
        Assert.assertNotNull(custI);

        custI.buildVat(0.15);
        custI.buildTip(10);
        custI.buildArangement(0);
        custI.buildSale(0);
        custI.buildCustomer("10293");
        custI.buildOrderNumber("080");
        custI.buildAmount(3590);
        customerPayRep.update(custI.getCustPayment());

    }

    @Test
    public void delete() {
        customerPayRep.delete("80#102");
    }

    @Test
    public void read() {
        System.out.println(customerPayRep.read("80#102").toString());
    }

    @Test
    public void readAll() {
        ArrayList<String>myList=new ArrayList<>();
        myList=customerPayRep.getAll();
        for(int i=0;i<myList.size();i++)
        {
            System.out.println(i+" "+myList.get(i)+"\n");
        }
    }

    @Test
    public void getItemNumber() {
    }
}