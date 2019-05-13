package Builder.itemBuilder;

public class ItemDirector {

    private ItemInterface itemInterface=null;

    public ItemDirector(ItemInterface itemInterface) {
        this.itemInterface = itemInterface;
    }
    public void createItem(String Description, String name,String number,char size,double price)
    {
        itemInterface.buildItemDescription(Description);
        itemInterface.buildItemName(name);
        itemInterface.buildItemNumber(number);
        itemInterface.buildItemSize(size);
        itemInterface.buildItemPrice(price);
    }
    public ItemProduct getItemProduct()
    {
        return itemInterface.getItemProduct();
    }
}
