package com.service.customerServ;

import com.Builder.customerBuilder.CustomerProduct;
import com.configPack.repositoryController.CustomerFactRepo;
import com.factory.repository.CustomerRepoFac;
import com.repository.customerRepPack.CustomerRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;

public class CustomerService implements CustomerServiceInt {
    private static CustomerService customer=null;

    //Getting the repository class.
    CustomerRepository rep;
    ApplicationContext ctx= new AnnotationConfigApplicationContext(CustomerFactRepo.class);
    CustomerRepoFac cfr=(CustomerRepoFac)ctx.getBean("getCustomerRep");
    private CustomerService() {
        rep=cfr.getCustomerRepository("customerRep");
    }

    public static CustomerService getCustomer() {
         if(customer==null)
         {
             customer=new CustomerService();
         }
         return customer;

    }

    @Override
    public CustomerProduct create(CustomerProduct customerProduct) {

        return rep.create(customerProduct);
    }

    @Override
    public CustomerProduct update(CustomerProduct customerProduct) {
        return rep.update(customerProduct);
    }

    @Override
    public void delete(String id) {
        rep.delete(id);
    }

    @Override
    public CustomerProduct read(String id) {
        return rep.read(id);
    }

    @Override
    public ArrayList readAlll() {
        return rep.getAll();
    }
}
