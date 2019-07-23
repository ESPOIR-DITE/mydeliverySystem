package com.repository.customerRepPack;

import com.Builder.customerBuilder.CustomerProduct;
import com.configPack.domainConf.CustomerConfig;
import com.configPack.repositoryController.CustomerFactRepo;
import com.domain.CustomerDetails;
import com.factory.domain.customerFactory.CustomerFactory;
import com.factory.repository.CustomerRepoFac;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CustomerRepositoryTest {
    ApplicationContext ctx= new AnnotationConfigApplicationContext(CustomerFactRepo.class);
    CustomerRepoFac cfr=(CustomerRepoFac)ctx.getBean("getCustomerRep");

    /**
     * setting up the builder
     * @throws Exception
     */
    ApplicationContext ctx2= new AnnotationConfigApplicationContext(CustomerConfig.class);

    CustomerFactory customerFactory=(CustomerFactory)ctx2.getBean("getCustomer");

    CustomerRepository rep;
    CustomerDetails x;
    @Before
    public void setUp() throws Exception {
        rep=cfr.getCustomerRepository("customerRep");
         x = customerFactory.getCustomer("customer");      //getting the customerDetails Object
    }

    @Test
    public void getInstance() {
        Assert.assertNotNull(cfr);
        CustomerRepository rep=cfr.getCustomerRepository("customerRep");
       // CustomerDetails x = customerFactory.getCustomer("customer");      //getting the customerDetails Object


        x.customerNumber("409404");
        x.builName("charla");
        x.builSurName("kalombo");
        x.builEmailAddress("espoirditekemen@gmail.com");
        x.builAddress("21 rebeick str goodwood");
        x.buildPhone("3820498035");
        rep.create(x.getCustomer());
    }

    @Test
    public void create() {
        CustomerRepository rep=cfr.getCustomerRepository("customerRep");        //returning a customer repository object
        CustomerDetails custD = customerFactory.getCustomer("customer");        //getting the customerDetails Object
        CustomerProduct custP=rep.read("409404");                               //returning the customer product object
        System.out.println(custP.toString());
    }
    @Test
    public void update() {
        CustomerRepository rep=cfr.getCustomerRepository("customerRep");



        x.customerNumber("409405");
        x.builName("charls");
        x.builSurName("kalombo");
        x.builEmailAddress("espoirditekemen@gmail.com");
        x.builAddress("21 rebeick str goodwood");
        x.buildPhone("3820498035");
        System.out.println(rep.update(x.getCustomer()).toString());
    }
    @Test
    public void delete() {
        CustomerRepository rep=cfr.getCustomerRepository("customerRep");
        rep.delete("409404");
    }
    @Test
    public void read() {
        System.out.println(rep.read("409406").toString());
    }

    @Test
    public void readAll() {
        ArrayList<String>myList=new ArrayList<>();
        CustomerRepository rep=cfr.getCustomerRepository("customerRep");
       myList= rep.getAll();
       for(int i=0;i<myList.size();i++)
       {
           System.out.println(myList.get(i));
       }
    }
    @Test
    public void getItemNumber() {

        CustomerRepository rep=cfr.getCustomerRepository("customerRep");
        CustomerDetails x = customerFactory.getCustomer("customer");      //getting the customerDetails Object
        System.out.println(rep.getItemNumber());
    }
}