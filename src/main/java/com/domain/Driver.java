package com.domain;

import com.Builder.driverBuilderPack.DriverInterface;
import com.Builder.driverBuilderPack.DriverProduct;

public class Driver implements DriverInterface
{

   private DriverProduct driverProduct;
    public Driver() {
        driverProduct=new DriverProduct();
    }

    @Override
    public void buildDriverCode(String code) {
        driverProduct.setCode(code);
    }

    @Override
    public void buildName(String name) {
        driverProduct.setName(name);
    }

    @Override
    public void buildSurName(String surname) {
        driverProduct.setSurName(surname);
    }

    @Override
    public void buildEmailAddress(String email) {
        driverProduct.setEmailAddress(email);
    }

    @Override
    public void buildAddress(String address) {
        driverProduct.setAddress(address);
    }

    @Override
    public void buildavaillable(char stat) {
        driverProduct.setAvaillable(stat);
    }

    @Override
    public void buildPhone_number(String phone) {
        driverProduct.setPhoner_Number(phone);
    }

    @Override
    public DriverProduct getDriver() {
        return driverProduct;
    }
}//end of Driver class
