package com.domain.itemDomain.classicItem;

import com.Builder.itemBuilder.ItemInterface;
import com.Builder.itemBuilder.ItemProduct;
import com.Builder.itemBuilder.classicProduct.ClassiProductInterface;
import com.Builder.itemBuilder.classicProduct.ClassicProduct;

public class Cigarette implements ClassiProductInterface {

    ClassicProduct classicProduct;

    public Cigarette() {classicProduct=new ClassicProduct();
    }

    @Override

    public void flavor(String flavor)
    {
        classicProduct.setFlavor(flavor);

    }

    @Override
    public void buildItemNumber(String number) {
        classicProduct.setItemNumber(number);
    }

    @Override
    public void buildItemName(String name) {
        classicProduct.setName(name);
    }

    @Override
    public void buildItemDescription(String description) {
        classicProduct.setDescription(description);
    }

    @Override
    public void buildItemPrice(double price) {

        classicProduct.setPrice(price);
    }

    @Override
    public void buildCategory(String ctegory) {
        classicProduct.setCategory(ctegory);
    }

    @Override
    public ClassicProduct getClassic() {
        return classicProduct;
    }
}
