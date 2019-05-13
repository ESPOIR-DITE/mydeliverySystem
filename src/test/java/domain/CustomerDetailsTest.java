package domain;

import Builder.customerBuilder.CustomerInterface;
import factory.productFactory.customerFactory.CustomerFactory;
import org.junit.Assert;
import org.junit.Test;

public class CustomerDetailsTest {
    CustomerFactory customerFactory=new CustomerFactory();
    CustomerDetails x = customerFactory.getCustomer("voortreker","espoir","espoir@gmail","ditekemena");





    @Test
    public void getCustomer() {
        //Assert.assertNotNull(x.getSetAddress());
        System.out.println(x.toString());
    }
}