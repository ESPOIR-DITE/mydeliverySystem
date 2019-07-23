package com;
import com.Builder.itemBuilder.ItemProduct;
import com.controller.ControlClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class Main {
   // @Bean
   // public RestTemplate restTemplate() {
    //    return new RestTemplate();
   // }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
