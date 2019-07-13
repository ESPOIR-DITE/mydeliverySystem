package com.Builder.driverBuilderPack;

public class DriverProduct {
    private  String code;
    private String Name;
    private String SurName;
    private String EmailAddress;
    private String Address;
    private String phoner_Number;
    private char availlable;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPhoner_Number() {
        return phoner_Number;
    }

    public void setPhoner_Number(String phoner_Number) {
        this.phoner_Number = phoner_Number;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurName() {
        return SurName;
    }

    public void setSurName(String surName) {
        SurName = surName;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public char getAvaillable() {
        return availlable;
    }

    public void setAvaillable(char availlable) {
        this.availlable = availlable;
    }

    @Override
    public String toString() {
        return  "Driver\n--------\n" +
                "setName:          " + Name +
                "\nsetSurName:      " + SurName +
                "\nsetEmailAddress: " + EmailAddress +
                "\nsetAddress:      " + Address +
                "\navaillable:      " + availlable+
                "\nphone number:    " + code+
                "\nphone number:    " + phoner_Number ;
    }
}
