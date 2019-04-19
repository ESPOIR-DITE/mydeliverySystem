package domain;

import configPack.ConfigItem;
import configPack.ConfigOrder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class ItemTest {

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigItem.class);
    Item orders = applicationContext.getBean(Item.class);
    @Test
    public void toString1() {
        orders=new Item(3,"boobay","25/11/2023",'M',"fhfhfhf");
        String result=orders.toString();
        System.out.println(result);
    }
}