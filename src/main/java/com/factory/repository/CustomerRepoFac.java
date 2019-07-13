package com.factory.repository;

import com.repository.customerRepPack.CustomerRepository;

public class CustomerRepoFac {
    CustomerRepository customerRepository,customerRepository2;

    public CustomerRepository getCustomerRepository(String s) {
        if(s.equalsIgnoreCase("customerRep")) {
            customerRepository2=customerRepository.getInstance();
        }
        return customerRepository2;
    }
}
