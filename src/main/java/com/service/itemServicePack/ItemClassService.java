package com.service.itemServicePack;

import com.Builder.itemBuilder.ItemProduct;
import com.Builder.itemBuilder.drink.noAlcoholProduct.NoAlcoholicProduct;
import com.configPack.repositoryController.NonAlcolRepConfig;
import com.factory.repository.NonAlcoholRepFact;
import com.repository.ItemRep.noAlcoholRepository.NoAlcoholRepositoryClass;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

/**
 * THIS CLASS IS GOING TO BE USED BY MANY CLASSES THAT IMPLEMENT @ ItemInterface
 * so i need to specify what happens when is accessing thos class
 * in the way that the user must be derected to the proper item that the user want to create.
 */


@Service("ItemService")
public class ItemClassService implements itemServiceInt {

    private static ItemClassService itemClassService=null;

    NonAlcoholRepFact nonAlcoholRepFact;
    NoAlcoholRepositoryClass noAl;
    ApplicationContext ctx = new AnnotationConfigApplicationContext(NonAlcolRepConfig.class);


    private ItemClassService() {
        nonAlcoholRepFact = (NonAlcoholRepFact) ctx.getBean("nonRep");
        noAl = nonAlcoholRepFact.getRepNonAlco("nonAlcohol");
    }

    public static ItemClassService getItemService()
    {
        if(itemClassService==null)
        {
            itemClassService=new ItemClassService();
        }
        return itemClassService;
    }


    @Override
    public NoAlcoholicProduct create(NoAlcoholicProduct noAlcoholicProduct) {
        return noAl.create(noAlcoholicProduct);
    }

    @Override
    public NoAlcoholicProduct update(NoAlcoholicProduct noAlcoholicProduct) {
        return noAl.update(noAlcoholicProduct);
    }

    @Override
    public void delete(String id) {
        noAl.delete(id);

    }

    @Override
    public NoAlcoholicProduct read(String id) {
        return noAl.read(id);
    }

    @Override
    public ArrayList readAlll() {
        return noAl.getAll();
    }
}
