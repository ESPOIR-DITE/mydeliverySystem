package Builder.paymentbuilders;

public class DriverPaymentProduct {
    private int rate;
    private int numberOfOrder;
    private double salary;
    private int distance;

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
    public void setSalary()
    {
        salary= rate*numberOfOrder;
    }
    public void setDistance(int distan)
    {
        this.distance=distan;
    }
    public double getSalary()
    {
        return salary;
    }

    @Override
    public String toString() {
        return "Driver Pay" +"\n"+
                "rate: " + rate +"\n"+
                "numberOfOrder: " + numberOfOrder +"\n"+
                " salary: " + salary+"\n"+"Distance"+distance +"\n"
                ;
    }
}
