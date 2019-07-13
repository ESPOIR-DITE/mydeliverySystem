package com.domain.customerPayment;

import com.Builder.customerPaymentBuilder.CustPayment;
import com.Builder.customerPaymentBuilder.CustomerpaymentInterface;

public class Cash implements CustomerpaymentInterface {
    CustPayment custPayment;

    public Cash() {
        custPayment =new  CustPayment();
    }

    @Override
    public void buildAmount(double amount) {
        custPayment.setAmount(amount);
    }

    @Override
    public void buildVat(double vat) {
        custPayment.setVat(vat);
    }

    @Override
    public void buildSale(double sale) {
        custPayment.setSale(sale);
    }

    @Override
    public void buildArangement(double arangement) {
        custPayment.setArrengement(arangement);
    }

    @Override
    public void buildTip(double tip) {
        custPayment.setTip(tip);
    }

    @Override
    public void buildOrderNumber(String ordeNumber) {
        custPayment.setOrderNumber(ordeNumber);
    }
    @Override
    public void buildCustomer(String custNum) {
        custPayment.setCustomerNumber(custNum);
    }

    @Override
    public void builPayment_type(String p_type) {
        custPayment.setPayment_type(p_type);    }

    @Override
    public CustPayment getCustPayment() {
        return custPayment;
    }
}
