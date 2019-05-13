package domain;

import Builder.itemBuilder.ItemInterface;
import Builder.itemBuilder.ItemProduct;

public class Beer implements ItemInterface {
    ItemProduct itemProduct;
    public Beer() {
        itemProduct = new ItemProduct();
    }

    @Override
    public void buildItemNumber(String number) {
        itemProduct.setItemNumber(number);

    }

    @Override
    public void buildItemName(String name) {

        itemProduct.setName(name);
    }

    @Override
    public void buildItemSize(char size) {

        itemProduct.setSize(size);
    }

    @Override
    public void buildItemDescription(String description) {

        itemProduct.setDescription(description);
    }

    @Override
    public void buildItemPrice(double price) {

        itemProduct.setPrice(price);
    }

    @Override
    public ItemProduct getItemProduct() {
        return itemProduct;
    }
}
