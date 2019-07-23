package com.domain;

import com.configPack.domainConf.CustomerConfig;
import com.factory.domain.customerFactory.CustomerFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CustomerDetailsTest {

    ApplicationContext ctx= new AnnotationConfigApplicationContext(CustomerConfig.class);

    CustomerFactory customerFactory=(CustomerFactory)ctx.getBean("getCustomer");

    CustomerDetails x;

    @Before
    public void setUp()
    {
         x = customerFactory.getCustomer("customer");
    }

    @Test
    public void getCustomer() {

        //Assert.assertNotNull(x);
        //System.out.println(x.toString());
        Assert.assertNotNull(x);
    }
    @Test
    public void getNameTest()
    {
       // CustomerDetails x = customerFactory.getCustomer("customer");
        x.customerNumber("409404");
        x.builName("espoir");
        x.builSurName("ditekemena");
        x.builEmailAddress("espoirditekemen@gmail.com");
        x.builAddress("21 rebeick str goodwood");
        x.buildPhone("3820498035");



        System.out.println(x.getCustomer().toString());
    }


}