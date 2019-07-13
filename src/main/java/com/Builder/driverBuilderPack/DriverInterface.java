package com.Builder.driverBuilderPack;

public interface DriverInterface {
    void buildDriverCode(String code);
    void buildName(String name);
    void buildSurName(String surname);
    void buildEmailAddress(String email);
    void buildAddress(String address);
    void buildavaillable(char stat);
    void buildPhone_number(String phone);
    DriverProduct getDriver();
}
