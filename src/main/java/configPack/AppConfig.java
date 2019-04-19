package configPack;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ConfigDriverPayment.class)
public class AppConfig {
    public @Bean ConfigDriverPayment configDriverPayment()
    {
        return new ConfigDriverPayment();
    }
}
