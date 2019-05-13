package Builder.paymentbuilders;

import Builder.paymentbuilders.DriverPaymentProduct;

public interface DriverPayInt {
    public void distance(int distance);
    public void paymentRate(int rate);
    public void numberOfOrder(int number);
    public DriverPaymentProduct getDriverPaymentProduct();


}
