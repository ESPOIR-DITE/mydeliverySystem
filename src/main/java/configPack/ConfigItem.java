package configPack;

import domain.Item;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigItem {
    public @Bean
    Item item()
    {
        return new Item();

    }
}
