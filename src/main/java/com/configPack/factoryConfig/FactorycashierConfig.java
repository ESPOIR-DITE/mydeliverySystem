package com.configPack.factoryConfig;

import com.factory.domain.cashierFactory.CashierFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactorycashierConfig {
    @Bean(name="getCashier")
    public CashierFactory getService()
    {
        return new CashierFactory();
    }
}
