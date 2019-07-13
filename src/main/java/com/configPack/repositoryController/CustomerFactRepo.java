package com.configPack.repositoryController;

import com.factory.repository.CustomerRepoFac;
import com.repository.customerRepPack.CustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerFactRepo {
    CustomerRepoFac customerRepository;
    @Bean(name = "getCustomerRep")
    public CustomerRepoFac getRepoService()
    {
        return new CustomerRepoFac();
    }
}
