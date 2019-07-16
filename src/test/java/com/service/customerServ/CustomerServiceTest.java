package com.service.customerServ;

import com.configPack.domainConf.CustomerConfig;
import com.domain.CustomerDetails;
import com.factory.domain.customerFactory.CustomerFactory;
import com.factory.services.CustomerServiceFac;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CustomerServiceTest {
    ApplicationContext ctx2= new AnnotationConfigApplicationContext(CustomerConfig.class);

    CustomerFactory customerFactory=(CustomerFactory)ctx2.getBean("getCustomer");
    private CustomerServiceFac custServFac=new CustomerServiceFac();
   private CustomerDetails x;
    private CustomerService custRep;


    @Before
    public void setUp() throws Exception {
        x = customerFactory.getCustomer("customer");      //getting the customerDetails Object
        custRep=custServFac.getCustomerServ("customerService");
    }

    @Test
    public void getCustomer() {
        custRep=custServFac.getCustomerServ("customerService");
        Assert.assertNotNull(custRep);
        Assert.assertNotNull(x);
    }

    @Test
    public void create() {
       // x.customerNumber("21");
        x.builName("yassin");
        x.builSurName("abel");
        x.builEmailAddress("espoirditekemen@gmail.com");
        x.builAddress("21 rebeick str goodwood");
        x.buildPhone("3820498035");
        custRep.create(x.getCustomer());
    }

    @Test
    public void update() {
        x.customerNumber("409406");
        x.builName("yassin");
        x.builSurName("abelo");
        x.builEmailAddress("espoirditekemen@gmail.com");
        x.builAddress("21 rebeick str goodwood");
        x.buildPhone("3820498035");
        System.out.println(custRep.update(x.getCustomer()).toString());
    }

    @Test
    public void delete() {
        custRep.delete("409406");
    }

    @Test
    public void read() {
        System.out.println(custRep.read("409406").toString());
    }

    @Test
    public void readAlll() {
        ArrayList<String> myList=new ArrayList<>();
        myList=custRep.readAlll();
        for(int i=0;i<myList.size();i++)
        {
            System.out.println(i+" "+myList.get(i)+"\n");
        }
    }
}