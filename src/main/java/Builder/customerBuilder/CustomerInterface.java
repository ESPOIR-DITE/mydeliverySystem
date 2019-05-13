package Builder.customerBuilder;

public interface CustomerInterface
{
    public void setName(String name);
    public void setSurName(String surName);
    public void setEmailAddress(String emailAddress);
    public void setAddress(String address);
    public CustomerProduct getCustomer();
}
