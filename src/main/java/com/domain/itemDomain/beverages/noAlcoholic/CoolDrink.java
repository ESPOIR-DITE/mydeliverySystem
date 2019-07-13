package com.domain.itemDomain.beverages.noAlcoholic;

import com.Builder.itemBuilder.drink.noAlcoholProduct.NoAlcoholicItemInterface;
import com.Builder.itemBuilder.drink.noAlcoholProduct.NoAlcoholicProduct;

public class CoolDrink implements NoAlcoholicItemInterface {
    NoAlcoholicProduct noAlcoholicProduct;

    public CoolDrink()
    {
        noAlcoholicProduct=new NoAlcoholicProduct();
    }

    @Override
    public NoAlcoholicProduct getNoAlcohol() {
        return noAlcoholicProduct;
    }

    @Override
    public void buildItemSize(char size) {
        noAlcoholicProduct.setSize(size);
    }

    @Override
    public void buildItemNumber(String number) {
        noAlcoholicProduct.setItemNumber(number);
    }

    @Override
    public void buildItemName(String name) {
        noAlcoholicProduct.setItemName(name);
    }

    @Override
    public void buildItemDescription(String description) {
        noAlcoholicProduct.setItemDescription(description);
    }

    @Override
    public void buildItemPrice(double price) {

        noAlcoholicProduct.setPrice(price);
    }

    @Override
    public void buildCategory(String ctegory) {
        noAlcoholicProduct.setItemCategory(ctegory);
    }
}
