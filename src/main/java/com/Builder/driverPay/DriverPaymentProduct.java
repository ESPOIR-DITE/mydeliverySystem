package com.Builder.driverPay;

public class DriverPaymentProduct {
    private int rate;
    private int numberOfOrder;
    private double salary;
    private int distance;
    private String payType;
    private String driverBumber;
    private String payDate;
    private String payCode;

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

    public String getDriverBumber() {
        return driverBumber;
    }

    public void setDriverBumber(String driverBumber) {
        this.driverBumber = driverBumber;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDistance() {
        return distance;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getNumberOfOrder() {
        return numberOfOrder;
    }

    public void setNumberOfOrder(int numberOfOrder) {
        this.numberOfOrder = numberOfOrder;
    }

    public void setSalary() {
        salary = rate * numberOfOrder;
    }

    public void setDistance(int distan) {
        this.distance = distan;
    }

    public double getSalary() {
        return salary = rate * numberOfOrder;
    }

    @Override
    public String toString() {
        return "\nDriver Pay" + "" + "\n------------\n" +
                "Paycode:        " + payCode + "\n" +
                "rate:           " + rate + "\n" +
                "numberOfOrder:  " + numberOfOrder + "\n" +
                "salary:         " + getSalary() + "\n" +
                "Distance        " + distance + "\n"+
                "payment Type    " + payType + "\n"+
                "driver number   " + driverBumber + "\n"+
                "Date            " + payDate + "\n"
                ;
    }
}
