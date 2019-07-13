package com.repository.casher;

import com.Builder.cashierBuilderPack.CashierProduct;
import com.domain.Cashier;
import java.util.ArrayList;
import com.repository.Irepository;

public interface CahierInterface extends Irepository<CashierProduct,String> {
   public ArrayList<CashierProduct> getAll();
}
