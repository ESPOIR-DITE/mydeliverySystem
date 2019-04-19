package domain;

import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerDetails {
    private String name;
    private String SurName;
    private String emailAddress;
    private String address;

    public CustomerDetails() {
    }

    public CustomerDetails(String name, String surName, String emailAddress, String address) {
        this.name = name;
        SurName = surName;
        this.emailAddress = emailAddress;
        this.address = address;
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
        return "CustomerDetails{" +
                "name='" + name + '\'' +
                ", SurName='" + SurName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
    public CustomerDetails getCustomerdetails()
    {
        return new CustomerDetails();
    }
}
