package com.service.Cashier;

import com.Builder.cashierBuilderPack.CashierInt;
import com.Builder.cashierBuilderPack.CashierProduct;
import com.configPack.factoryConfig.FactoryCashierConfigRep;
import com.configPack.factoryConfig.FactorycashierConfig;
import com.factory.domain.cashierFactory.CashierFactory;
import com.factory.repository.CashierRepFac;
import com.repository.casher.CashierRep;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;

public class CashierServicer implements CashierServiceInt {
    private static CashierServicer cashier=null;
    CashierRep cashierRep;
    CashierRepFac cashierRepFac;
    ApplicationContext ctx = new AnnotationConfigApplicationContext(FactoryCashierConfigRep.class);





    private CashierServicer() {
        cashierRepFac=(CashierRepFac)ctx.getBean("getCashier");
        cashierRep =cashierRepFac.getCashier("cashierRep");
    }

    public static CashierServicer getCashier() {
        if(cashier==null){
            cashier=new CashierServicer();
        }
        return cashier;
    }

    @Override
    public CashierProduct create(CashierProduct cashierProduct) {
        CashierProduct newCashier= cashierRep.create(cashierProduct);
        return newCashier;
    }

    @Override
    public CashierProduct update(CashierProduct cashierProduct) {
        cashierRep.update(cashierProduct);
        return null;
    }

    @Override
    public void delete(String id) {
        cashierRep.delete(id);
    }

    @Override
    public CashierProduct read(String id) {
        /**
         * we are reading from the database through the repository class
         * this method read returns an object a product that will help
         * create
         */
        CashierProduct cashier2= cashierRep.read("id");
        /**
         * now we return the all cashier Object.
         */
        return cashier2;
    }

    @Override
    public ArrayList readAlll() {
        return cashierRep.getAll();
    }
}
