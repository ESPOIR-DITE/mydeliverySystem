package com.Builder.customerBuilder;

public class CustomerProduct {
    private String name;
    private String SurName;
    private String emailAddress;
    private String address;
    private String phone_number;
    private String customer_number;

    public String getCustomer_number() {
        return customer_number;
    }

    public void setCustomer_number(String customer_number) {
        this.customer_number = customer_number;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return SurName;
    }

    public void setSurName(String surName) {
        SurName = surName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CustomerProduct" +
                "\ncustomer numb:"+customer_number+
                "\nname:         "+name +
                "\nSurName:      "+SurName +
                "\nemailAddress: "+emailAddress +
                "\naddress:      "+address+
                "\nphone number: "+phone_number;

    }
}
