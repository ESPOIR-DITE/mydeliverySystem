package domain;

import Builder.itemBuilder.ItemInterface;
import factory.productFactory.ItemFactory;
import org.junit.Before;
import org.junit.Test;
//MY IDEA IS THAT I SHOULD USE THE FACTORY TO GET WINE OBJECT AND SET THE WINE ITEM THROUGH THE BUILDER

public class WineTest {
ItemInterface itemInterface;
Wine wine;
    @Before
    public void setUp() throws Exception {


    }
    @Test
    public void wineTest()
    {
        ItemFactory itemFactory = new ItemFactory();
        ItemInterface a1 = itemFactory.getItem("Juice");
        a1.buildItemPrice(7878);
        a1.buildItemSize('M');
        a1.buildItemNumber("383838");
        a1.buildItemName("espoirWine");
        a1.buildItemDescription("kjsahdkjhkjhkhsfjkhksjh");
        String value1 = a1.toString();
        String value2 = a1.getItemProduct().toString();
        System.out.println(value2);

    }
}