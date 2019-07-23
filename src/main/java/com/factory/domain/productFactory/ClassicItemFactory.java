package com.factory.domain.productFactory;

import com.Builder.itemBuilder.classicProduct.ClassiProductInterface;
import com.domain.itemDomain.classicItem.Cigarette;
import com.domain.itemDomain.classicItem.Ice;
import com.domain.itemDomain.classicItem.Snaks;

public class ClassicItemFactory {
    public ClassiProductInterface getClassicProduct(String s)
    {
        if(s.equalsIgnoreCase("cigaratte"))
        {
            return new Cigarette();
        }else if(s.equalsIgnoreCase("ice"))
        {
            return new Ice();
        }else if(s.equalsIgnoreCase("snaks"))
        {
            return new Snaks();
        }else return null;

    }
}
