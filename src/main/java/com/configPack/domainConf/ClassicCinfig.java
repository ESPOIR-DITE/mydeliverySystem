package com.configPack.domainConf;

import com.Builder.itemBuilder.classicProduct.ClassiProductInterface;
import com.domain.itemDomain.classicItem.Cigarette;
import com.domain.itemDomain.classicItem.Ice;
import com.domain.itemDomain.classicItem.Snaks;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClassicCinfig {
    @Bean(name = "getCigarette")
    public ClassiProductInterface getClassicConf()
    {
        return new Cigarette();
    }
    @Bean(name="getIce")
    public ClassiProductInterface getCigaretteClassic()
    {
        return new Ice();
    }
    @Bean(name="getSnakes")
    public ClassiProductInterface getSnakecClassic()
    {
        return new Snaks();
    }
}
