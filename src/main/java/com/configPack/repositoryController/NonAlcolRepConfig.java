package com.configPack.repositoryController;

import com.factory.repository.NonAlcoholRepFact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NonAlcolRepConfig {
    @Bean(name = "nonRep")
    public NonAlcoholRepFact getNonAlcolRep()
    {
       return new NonAlcoholRepFact();
    }
}
