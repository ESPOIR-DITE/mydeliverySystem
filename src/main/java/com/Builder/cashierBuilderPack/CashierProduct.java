package com.Builder.cashierBuilderPack;

public class CashierProduct {
    private String name;
    private String surName;
    private int id;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "  \n     Cashier\n   ------" +
                "\n name:    " + name +
                "\n surName: " + surName +
                "\n id:      " + id;
    }
}
