package com.factory.repository;

import com.repository.casher.CashierRep;

public class CashierRepFac {
    private CashierRep cashierRep,cashierRe;
    public CashierRep getCashier(String chashier){
        if (chashier.equalsIgnoreCase("cashierRep"))
        {
            cashierRe=cashierRep.getCashierRep();
        }
        return cashierRe;
    }
}
