package repository.ItemRep;

import Builder.itemBuilder.ItemInterface;
import Builder.itemBuilder.ItemProduct;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemRepositoryTest {
    ItemRepository itemRepository=ItemRepository.getInstance();


    @Test
    public void create1() {
       // itemRepository.create();
        Assert.assertNotNull(itemRepository);
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
    public void readAll() {

        Assert.assertNotNull(itemRepository);
        System.out.println(itemRepository.readAll("Juice"));
       // System.out.println(a1);
    }
/***
    @Test
    public void update1() {
    }

    @Test
    public void delete1() {
    }

    @Test
    public void read1() {
    }

    @Test
    public void readAll() {
    }*/
}