package factory.productFactory.customerFactory;

import Builder.customerBuilder.CustomerInterface;
import domain.CustomerDetails;

public class CustomerFactory {
    public CustomerDetails getCustomer(String adress,String name,String email,String surname)
    {
        return new  CustomerDetails.CustomerDetailsBuilder()
                .setSetAddress(adress)
                .setSetEmailAddress(email)
                .setSetName(name)
                .setSetSurName(surname)
                .customerDetailsBuilder();
    }
}
