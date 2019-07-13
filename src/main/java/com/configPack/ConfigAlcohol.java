package com.configPack;

import com.factory.domain.productFactory.alcoholItemFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigAlcohol
{
    @Bean(name="getBeer")
    public alcoholItemFactory getService()
    {
        return new alcoholItemFactory();
    }

}



