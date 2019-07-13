package com.factory.domain.cashierFactory;

import com.Builder.cashierBuilderPack.CashierInt;
import com.domain.Cashier;

public class CashierFactory {
    private Cashier cashier;
    public CashierInt getCashier(String value)
    {
        if(value.equalsIgnoreCase("cashier"))
        {
             cashier= new Cashier();}
        return cashier;


    }
}
