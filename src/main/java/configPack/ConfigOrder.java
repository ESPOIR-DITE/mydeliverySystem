package configPack;

import Builder.orderBuilder.Orders;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigOrder {
    public @Bean Orders orders()
    {
        return new Orders();
    }
}
