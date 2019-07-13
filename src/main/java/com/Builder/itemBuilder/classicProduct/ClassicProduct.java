package com.Builder.itemBuilder.classicProduct;

public class ClassicProduct {
    private String name;
    private String description;
    private String ItemNumber;
    private double price;
    private String Flavor;
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getItemNumber() {
        return ItemNumber;
    }

    public void setItemNumber(String itemNumber) {
        ItemNumber = itemNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFlavor() {
        return Flavor;
    }

    public void setFlavor(String flavor) {
        Flavor = flavor;
    }

    @Override
    public String toString() {
        return "ClassicProduct{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ItemNumber='" + ItemNumber + '\'' +
                ", price=" + price +
                ", Flavor='" + Flavor +
                "ITEM CATEGORY:"+ category
                ;
    }
}
