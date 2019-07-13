package com.factory.repository;

import com.repository.payment.customerPay.CustomerPayRep;

public class CustomerPayFact {
    CustomerPayRep customerPayRep;
    public CustomerPayRep getCustPayRep(String s)
    {
        if(s.equalsIgnoreCase("customerRep"))
        {
            return customerPayRep.getCustomerRep();
        }
        else return null;
    }
}
