package service.itemServicePack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemClassServiceTest {
    ItemClassService itemClassService= ItemClassService.getItemClass();


    @Test
    public void getItemClass() {
        Assert.assertNotNull(itemClassService);
    }

    @Test
    public void myItemList() {
    }

    @Test
    public void create() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void read() {
    }

    @Test
    public void readAll()
    {
        Assert.assertNotNull(itemClassService.readAlll());
        System.out.println(itemClassService.readAlll());
    }




}