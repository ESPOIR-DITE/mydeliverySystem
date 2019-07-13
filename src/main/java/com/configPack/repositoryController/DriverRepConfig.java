package com.configPack.repositoryController;

import com.factory.repository.DriverRepFact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DriverRepConfig {
    @Bean(name = "getDriverRep")
    public DriverRepFact getService()
    {
        return new DriverRepFact();
    }
}
