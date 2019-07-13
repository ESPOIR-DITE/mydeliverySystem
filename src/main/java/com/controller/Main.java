package com.controller;
import com.Builder.itemBuilder.ItemProduct;
import com.ControlClass;
import com.service.itemServicePack.ItemClassService;
import com.service.orderServices.OrderServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@RestController
public class Main {

     ItemClassService itemClass= new ItemClassService();
     OrderServices orderServices=OrderServices.getInstance();
    @Bean
    @GetMapping("/HOME")
    @ResponseBody
    public  ItemProduct getItemInterface()
    {

        System.out.println("ESPOIR");
        return itemClass.readAlll();
    }
    @Bean
    @GetMapping("/CUSTOMER")
    @ResponseBody
    public void setItem()/**we need to specify which it we want to insert by sending*/
    {
        //itemClass.create()

    }
    @Bean
    @GetMapping("/ORDERS")
    @ResponseBody
    public void readOrder()/**we need to specify which it we want to insert by sending*/
    {
        orderServices.readAlll();

    }

    public static void main(String[] args)
    {
        SpringApplication.run(Main.class, args);
    }
}
