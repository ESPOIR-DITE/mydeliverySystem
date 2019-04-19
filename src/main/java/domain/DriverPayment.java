package domain;

public class DriverPayment {

    //private int numberOfOrder;
    private final int payRate=3;
    private int bonus=0;

    public int pay(int numberOfOrder)
    {
        return payRate+numberOfOrder+bonus;
    }
}
