package com.configPack;

import com.factory.domain.orderFactory.OrderFacto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigOrder {
    @Bean(name="orderF")
    public OrderFacto orders()
    {
        return new OrderFacto();
    }
}
