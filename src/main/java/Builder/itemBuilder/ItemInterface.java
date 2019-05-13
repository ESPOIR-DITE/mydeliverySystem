package Builder.itemBuilder;
/*
this is the builder interface that features ALL THE METHODS THAT ARE USED TO CREATE AN ITEM.
 */

public interface ItemInterface {
    public void buildItemNumber(String number);
    public void buildItemName(String name);
    public void buildItemSize(char size);
    public void buildItemDescription(String description);
    public void buildItemPrice(double price);
    public ItemProduct getItemProduct();
}
