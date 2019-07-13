package com.Builder.customerPaymentBuilder;

public class CustPayment
{
    private String customerNumber;
    private String orderNumber;
    private double amount;
    private double vat;
    private double sale;
    private double arrengement;
    private double tip;
    private String payment_type;

    public CustPayment() {
    }

    public CustPayment(String customerNumber, String orderNumber, double amount, double vat, double sale, double arrengement, double tip, String payment_type) {
        this.customerNumber = customerNumber;
        this.orderNumber = orderNumber;
        this.amount = amount;
        this.vat = vat;
        this.sale = sale;
        this.arrengement = arrengement;
        this.tip = tip;
        this.payment_type = payment_type;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public double getTip() {
        return tip;
    }

    public void setTip(double tip) {
        this.tip = tip;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

    public double getArrengement() {
        return arrengement;
    }

    public void setArrengement(double arrengement) {
        this.arrengement = arrengement;
    }

    @Override
    public String toString() {
        return "CustPayment\n------------" +
                "\namount:      " + amount +
                "\nvat:        " + vat +
                "\nsale:       " + sale +
                "\narrengement:" + arrengement+
                "\ntip:        " + tip +
                "\nPay_type:   " + payment_type ;
    }
}
