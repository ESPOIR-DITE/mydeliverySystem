package com.factory.domain.customerFactory;

import com.domain.CustomerDetails;

public class CustomerFactory {
    public CustomerDetails getCustomer(String s)
    {
        if(s.equalsIgnoreCase("customer"))
        {
            return new  CustomerDetails();
        }
        else return null;
    }
}
