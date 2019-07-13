package com.configPack.repositoryController;

import com.factory.repository.OrderRepFact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderRepConfig {
    @Bean(name="getOrderRep")
    public OrderRepFact getOrderRepFact()
    {
        return new OrderRepFact();
    }
}
