package domain.itemDomain;

import Builder.itemBuilder.ItemProduct;
import Builder.itemBuilder.Alcohol;

public class Whisky extends Alcohol {

    ItemProduct itemProduct;
    private String percentage="42%";

    public Whisky() {
        itemProduct =new ItemProduct();
    }

    @Override
    public String percentageOfAlcohol() {
        return percentage;
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

        itemProduct.setDescription(description+"\n"+percentageOfAlcohol());
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
