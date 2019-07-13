package com.Builder.cashierBuilderPack;

import com.domain.Cashier;

public interface CashierInt {
    void buildName(String name);
    void buildSurname(String surname);
    void buildId(int id);
    CashierProduct getCashier();
}
