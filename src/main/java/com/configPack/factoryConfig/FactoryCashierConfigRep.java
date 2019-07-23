package com.configPack.factoryConfig;

import com.factory.repository.CashierRepFac;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryCashierConfigRep {
       // CashierRepFac cashierRepFac;
        @Bean(name="getCashierRep")
        public CashierRepFac getService()
        {
            return new CashierRepFac();
        }

}
