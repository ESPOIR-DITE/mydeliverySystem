package com.repository.casher;

import com.Builder.cashierBuilderPack.CashierInt;
import com.Builder.cashierBuilderPack.CashierProduct;
import com.configPack.factoryConfig.FactoryCashierConfigRep;
import com.configPack.factoryConfig.FactorycashierConfig;
import com.domain.Cashier;
import com.factory.domain.cashierFactory.CashierFactory;
import com.factory.repository.CashierRepFac;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;

public class CashierRepTest {

    // getting cashier factory injected from class  FactoryCashierConfigRep

    CashierRepFac cashierRepFac;
    ApplicationContext ctx = new AnnotationConfigApplicationContext(FactoryCashierConfigRep.class);

    // getting the cashier builder to build cashier
    CashierFactory cashierFactory;
    ApplicationContext ctx2 = new AnnotationConfigApplicationContext(FactorycashierConfig.class);

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getCashierRep() {
        // getting cashierRep Object
        cashierRepFac=(CashierRepFac)ctx.getBean("getCashier");
        CashierRep cashierRep=cashierRepFac.getCashier("cashierRep");
        Assert.assertNotNull(cashierRep);

        // getting cashier Object
        cashierFactory=(CashierFactory)ctx2.getBean("getCashier");
        CashierInt cashier=cashierFactory.getCashier("cashier");

        System.out.println(cashier.getCashier().getId());
    }

    @Test
    public void create() {
        // getting cashierRep Object
        cashierRepFac=(CashierRepFac)ctx.getBean("getCashier");
        CashierRep cashierRep=cashierRepFac.getCashier("cashierRep");


        cashierFactory=(CashierFactory)ctx2.getBean("getCashier");
        CashierInt cashier=cashierFactory.getCashier("cashier");
        cashier.buildId(29393);
        cashier.buildName("espoi");
        cashier.buildSurname("dite");
        System.out.println(cashier.getCashier().toString());

        CashierProduct cashier2=cashier.getCashier();
        //System.out.println(cashier2.toString());
        cashierRep.create(cashier2);//need to creat an object of

    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void read() {
        cashierRepFac=(CashierRepFac)ctx.getBean("getCashier");
        CashierRep cashierRep=cashierRepFac.getCashier("cashierRep");
        CashierProduct cashier2= cashierRep.read("29393");
        System.out.println(cashier2);
    }

    @Test
    public void getAll() {

        ArrayList<String>myList=new ArrayList<>();
        cashierRepFac=(CashierRepFac)ctx.getBean("getCashier");
        CashierRep cashierRep=cashierRepFac.getCashier("cashierRep");


        System.out.println(cashierRep.getAll());

    }

    @Test
    public void getItemNumber() {
    }
}