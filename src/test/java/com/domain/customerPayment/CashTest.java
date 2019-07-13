package com.domain.customerPayment;

import com.Builder.customerPaymentBuilder.CustomerpaymentInterface;
import com.factory.domain.customerPaymentFactory.customerPayFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CashTest {
    CustomerpaymentInterface custI;
    customerPayFactory custF=new customerPayFactory();

@Before
public void setUp()
{

}

    @Test
    public void buildAmount() {
        custI=custF.getCustPayment("cash");
        Assert.assertNotNull(custI);
        custI.buildAmount(250);
        custI.buildSale(0);
        custI.buildArangement(0);
        custI.buildTip(10);
        custI.buildVat(0012);
        System.out.println(custI.getCustPayment());

    }

    @Test
    public void buildVat() {
    }

    @Test
    public void buildSale() {
    }

    @Test
    public void buildArangement() {
    }

    @Test
    public void buildTip() {
    }

    @Test
    public void getCustPayment() {
    }
}