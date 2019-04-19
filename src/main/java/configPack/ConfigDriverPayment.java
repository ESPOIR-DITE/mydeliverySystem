package configPack;


import domain.DriverPayment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigDriverPayment {

    public @Bean DriverPayment customerDetails()
    {
        return new DriverPayment();
    }
}
