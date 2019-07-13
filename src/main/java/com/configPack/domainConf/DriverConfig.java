package com.configPack.domainConf;

import com.factory.domain.driverFactory.DriverFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DriverConfig {
    @Bean(name="getDriver")
    public DriverFactory getService()
    {
        return new DriverFactory();
    }

}
