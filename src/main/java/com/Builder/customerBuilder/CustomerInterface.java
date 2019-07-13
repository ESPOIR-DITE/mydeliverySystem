package com.Builder.customerBuilder;

public interface CustomerInterface
{
     void customerNumber(String id);
     void builName(String name);
     void builSurName(String surName);
     void builEmailAddress(String emailAddress);
     void builAddress(String address);
    void buildPhone(String phone);
     CustomerProduct getCustomer();
}
