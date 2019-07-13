package com.domain;

import com.Builder.customerBuilder.CustomerInterface;
import com.Builder.customerBuilder.CustomerProduct;

public class CustomerDetails implements CustomerInterface {


    private CustomerProduct customerProduct;

    public CustomerDetails() {
        customerProduct=new CustomerProduct();
    }

    @Override
    public void customerNumber(String id) {
        customerProduct.setCustomer_number(id);
    }

    @Override
    public void builName(String name) {
       customerProduct.setName(name);
    }

    @Override
    public void builSurName(String surName) {
        customerProduct.setSurName(surName);
    }

    @Override
    public void builEmailAddress(String emailAddress) {
        customerProduct.setEmailAddress(emailAddress);
    }

    @Override
    public void builAddress(String address) {
        customerProduct.setAddress(address);
    }

    @Override
    public void buildPhone(String phone) {
        customerProduct.setPhone_number(phone);
    }

    @Override
    public CustomerProduct getCustomer() {
        return customerProduct;
    }
}//end CustomerDetails

