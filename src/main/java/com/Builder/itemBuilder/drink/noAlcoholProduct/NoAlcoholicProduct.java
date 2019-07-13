package com.Builder.itemBuilder.drink.noAlcoholProduct;

public class NoAlcoholicProduct
{
    private char size;
    private String ItemNumber;
    private String itemName;
    private String itemDescription;
    private double price;
    private String itemCategory;

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }

    public String getItemNumber() {
        return ItemNumber;
    }

    public void setItemNumber(String itemNumber) {
        ItemNumber = itemNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    @Override
    public String toString() {
        return  "    NoAlcoholicProduct" +
                " \n size:              " + size +
                " \n ItemNumber:      " + ItemNumber +
                " \n itemName:        " + itemName +
                " \n itemDescription: " + itemDescription +
                " \n price:           " + price +
                " \n itemCategory:    " + itemCategory ;
    }
}
