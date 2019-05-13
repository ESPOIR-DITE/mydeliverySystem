package Builder.paymentbuilders;

public class DailyPayment implements DriverPayInt {

    DriverPaymentProduct driverPaymentProduct;
    public DailyPayment()
    {
        driverPaymentProduct = new DriverPaymentProduct();
    }

    @Override
    public void distance(int distance) {
        driverPaymentProduct.setDistance(distance);
    }

    @Override
    public void paymentRate(int rate) {
        driverPaymentProduct.setRate(rate);
    }

    @Override
    public void numberOfOrder(int numberOfOrder) {
        driverPaymentProduct.setNumberOfOrder(numberOfOrder);
    }

    @Override
    public DriverPaymentProduct getDriverPaymentProduct() {
        return driverPaymentProduct;
    }
}
