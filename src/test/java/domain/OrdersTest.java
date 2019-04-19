package domain;

import configPack.AppConfig;
import configPack.ConfigOrder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class OrdersTest {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigOrder.class);
    Orders orders = applicationContext.getBean(Orders.class);

    @Test
    public void toString1() {
        String result =orders.toString();
        System.out.println(result);
    }
}