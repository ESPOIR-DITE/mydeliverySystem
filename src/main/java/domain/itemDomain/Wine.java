package domain.itemDomain;

import Builder.itemBuilder.ItemProduct;
import Builder.itemBuilder.Alcohol;

public class Wine extends Alcohol  //THIS IS THE CRONCRET PRODUCT THROUGH ALCOHOL CLASS IN THE BUILDER PATTERN.
{
    ItemProduct itemProduct;

    public Wine()
    {
        itemProduct=new ItemProduct();
    }

    @Override
    public String percentageOfAlcohol() {
        return "18%";
    }

    @Override
    public void buildItemNumber(String itemNumber) {

        itemProduct.setItemNumber(itemNumber);
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
        itemProduct.setDescription(description+" \n"+percentageOfAlcohol());

    }

    @Override
    public void buildItemPrice(double price) {
        itemProduct.setPrice(price);

    }
    public ItemProduct getItemProduct()
    {
        return itemProduct;
    }
}

