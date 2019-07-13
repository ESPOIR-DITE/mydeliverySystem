package com.domain;

import com.Builder.cashierBuilderPack.CashierInt;
import com.configPack.factoryConfig.FactorycashierConfig;
import com.factory.domain.cashierFactory.CashierFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CashierTest {
    CashierFactory cashierFactory;
    ApplicationContext ctx = new AnnotationConfigApplicationContext(FactorycashierConfig.class);



    public CashierTest()
    {

    }



    @Before
    public void setUp()
    {


    }


    @Test
    public void getName() {
        cashierFactory=(CashierFactory)ctx.getBean("getCashier");
        CashierInt cashier=cashierFactory.getCashier("cashier");
        Assert.assertNotNull(cashier);
    }

    @Test
    public void toString1() {
        cashierFactory=(CashierFactory)ctx.getBean("getCashier");
        CashierInt cashier=cashierFactory.getCashier("cashier");
        cashier.buildId(29393);
        cashier.buildName("espoir");
        cashier.buildSurname("dite");
        System.out.println(cashier.getCashier().getId());
        System.out.println(cashier.getCashier().toString());
    }
}