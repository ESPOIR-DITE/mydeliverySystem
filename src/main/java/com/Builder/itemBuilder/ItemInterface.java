package com.Builder.itemBuilder;
/*
this is the builder interface that features ALL THE METHODS THAT ARE USED TO CREATE AN ITEM.
 */

public interface ItemInterface {
    public void buildItemNumber(String number);
    public void buildItemName(String name);
    public void buildItemDescription(String description);  /****in description i can put some identifications*/
    public void buildItemPrice(double price);
           void buildCategory(String ctegory);
   // public ItemProduct getItemProduct();
}
