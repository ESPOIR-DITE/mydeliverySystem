package Builder.itemBuilder;

public class ItemProduct    //THIS IS THE ITEM PRODUCT IN THE BUILDER PATTERN. WHICH REPRESENT
{
    private String name;
    private String description;
    private char size;
    private String ItemNumber;
    private double price;

    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    @Override
    public String toString() {
        return "ItemProduct\n----------\n" +
                "\nname:        " + name +
                "\ndescription: " + description +
                "\nsize:        " + size +
                "\nItemNumber:  " + ItemNumber +
                "\nPRICE:       " + price;
    }
}
