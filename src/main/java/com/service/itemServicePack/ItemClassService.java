package com.service.itemServicePack;

import com.Builder.itemBuilder.ItemProduct;
import com.sun.xml.internal.bind.v2.model.core.ID;
import com.repository.ItemRep.ItemRepo;
import com.service.itemServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * THIS CLASS IS GOING TO BE USED BY MANY CLASSES THAT IMPLEMENT @ ItemInterface
 * so i need to specify what happens when is accessing thos class
 * in the way that the user must be derected to the proper item that the user want to create.
 */


@Service("ItemService")
public class ItemClassService implements itemServiceInt {

    @Autowired
    @Qualifier("serveItem1")
    private  ItemClassService itemClass;
   // private static ItemRepo itemRepo=ItemRepository.getInstance();

    /**  private ItemClassService()
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
    }*/

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

    @RequestMapping("/readAll")
    @Override
    public ItemProduct readAlll()
    {
        return null;
                //itemRepo.readAll("Juice");
    }
}
