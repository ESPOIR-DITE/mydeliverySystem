package com.configPack.repositoryController;

import com.repository.ItemRep.classicProducat.ClassicProductRep;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClassicRepConfig {
    private ClassicProductRep clas,class2;
    @Bean(name="getClassicRep")
    public ClassicProductRep getClassicRep()
    {
        return class2=clas.getClassic();
    }
}
