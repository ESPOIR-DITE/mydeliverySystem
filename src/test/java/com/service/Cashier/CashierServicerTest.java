package com.service.Cashier;

import com.Builder.cashierBuilderPack.CashierInt;
import com.configPack.factoryConfig.FactoryCashierConfigRep;
import com.configPack.factoryConfig.FactorycashierConfig;
import com.factory.domain.cashierFactory.CashierFactory;
import com.factory.repository.CashierRepFac;
import com.factory.services.cashierServiceFact;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CashierServicerTest {
    // getting cashier factory injected from class  FactoryCashierConfigRep
    CashierRepFac cashierRepFac;
    ApplicationContext ctx = new AnnotationConfigApplicationContext(FactoryCashierConfigRep.class);

    // getting the cashier builder to build cashier
    CashierFactory cashierFactory;
    ApplicationContext ctx2 = new AnnotationConfigApplicationContext(FactorycashierConfig.class);

    //getting the cashierService
    cashierServiceFact cachier=new cashierServiceFact();
    CashierServicer mychier=cachier.getCashier("cashierService");

    CashierInt cashier;
    @Before
    public void setUp() throws Exception {
        cashierRepFac=(CashierRepFac)ctx.getBean("getCashier");

        // getting cashier Object
        cashierFactory=(CashierFactory)ctx2.getBean("getCashier");
        cashier=cashierFactory.getCashier("cashier");
    }

    @Test
    public void create() {
       // Assert.assertNotNull(mychier);
       // Assert.assertNotNull(cashierRepFac);
        //Assert.assertNotNull(mychier);
       // Assert.assertNotNull(cashier);

    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {//29393
        mychier.delete("1");
    }

    @Test
    public void read() {
        System.out.println(mychier.read("1"));

    }

    @Test
    public void readAlll() {
        ArrayList<String>myList=new ArrayList<>();
        myList=mychier.readAlll();
        for(int i=0;i<myList.size();i++)
        {
            System.out.println(myList.get(i));
        }
    }
}