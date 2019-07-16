package com.domain;

import com.Builder.cashierBuilderPack.CashierInt;
import com.Builder.cashierBuilderPack.CashierProduct;

public class Cashier implements CashierInt {
    CashierProduct cashierProduct;
    public Cashier()
    {
        cashierProduct=new CashierProduct();
    }
    @Override
    public void buildName(String name) {
        cashierProduct.setName(name);
    }
    @Override
    public void buildSurname(String surname) {
        cashierProduct.setSurName(surname);
    }

    @Override
    public void buildId(int id) {
        cashierProduct.setId(id);
    }

    @Override
    public CashierProduct getCashier() {
        return cashierProduct;
    }
}









