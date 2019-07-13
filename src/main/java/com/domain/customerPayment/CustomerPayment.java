package com.domain.customerPayment;

public class CustomerPayment {
    private int numberOfItem;
    private int itemPrice;

    public CustomerPayment(int numberOfItem, int itemPrice) {
        this.numberOfItem = numberOfItem;
        this.itemPrice = itemPrice;
    }

    public int priceOfItem(int numberOfItem,int itemPrice)
    {
        return numberOfItem*itemPrice;
    }
}
