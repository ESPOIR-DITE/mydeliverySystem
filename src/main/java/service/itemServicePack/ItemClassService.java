package service.itemServicePack;

import Builder.itemBuilder.ItemInterface;
import Builder.itemBuilder.ItemProduct;
import com.sun.xml.internal.bind.v2.model.core.ID;
import repository.ItemRep.ItemRepo;
import repository.ItemRep.ItemRepository;
import service.itemServiceInt;

import java.util.ArrayList;

/**
 * THIS CLASS IS GOING TO BE USED BY MANY CLASSES THAT IMPLEMENT @ ItemInterface
 * so i need to specify what happens when is accessing thos class
 * in the way that the user must be derected to the proper item that the user want to create.
 */


public class ItemClassService implements itemServiceInt {

    private static ItemClassService itemClass=null;
    private static ItemRepo itemRepo=ItemRepository.getInstance();

    private ItemClassService()
    {
       // this.itemRepo=ItemInterface;

    }
    public static ItemClassService getItemClass()
    {
        if(itemClass==null)
        {
            itemClass=new ItemClassService();
        }
        return itemClass;
    }

    @Override
    public ItemProduct create(ItemProduct itemProduct) {
        return null;
    }

    @Override
    public ItemProduct update(ItemProduct itemProduct) {
        return this.itemClass.update(itemProduct);
    }

    @Override
    public void delete(ID id)/**********I THINK THIS METHOD SHOULD RETURN A STRING OF CONFIRMATION IF THE **/
    {
        itemClass.delete(id);
    }
    @Override
    public ItemProduct read(ID id)
    {
        return itemClass.read(id);
    }

    @Override
    public ItemProduct readAlll()
    {
        return itemRepo.readAll("Juice");
    }
}
