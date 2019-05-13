package Builder.paymentbuilders;

public class DrinverPayDirector {
    private DriverPayInt driverPayInt=null;
    public DrinverPayDirector(DriverPayInt driverPayInt){
        this.driverPayInt = driverPayInt;
    }
    public void constructpayment(int distace,int number,int rate)
    {
        driverPayInt.distance(distace);
        driverPayInt.numberOfOrder(number);
        driverPayInt.paymentRate(rate);

    }
    public DriverPaymentProduct getDriverPaymentProduct()
    {
        return driverPayInt.getDriverPaymentProduct();
    }
}
