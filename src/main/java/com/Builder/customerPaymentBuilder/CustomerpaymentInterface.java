package com.Builder.customerPaymentBuilder;

public interface CustomerpaymentInterface
{
    // i think we need to provide another variable that will help to distinguish cash payment and credit payment

    void buildAmount(double amount);
    void buildVat(double vat);
    void buildSale(double sale);
    void buildArangement(double arangement);
    void buildTip(double tip);
    void buildOrderNumber(String ordeNumber);
    void buildCustomer(String custNum);
    void builPayment_type(String p_type);
    CustPayment getCustPayment();

}
