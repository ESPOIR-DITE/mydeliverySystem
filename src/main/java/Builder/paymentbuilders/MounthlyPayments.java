package Builder.paymentbuilders;

public class MounthlyPayments implements DriverPayInt {

    DriverPaymentProduct driverPaymentProduct;

    public MounthlyPayments() {
        driverPaymentProduct =new DriverPaymentProduct();
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
    public void numberOfOrder(int number) {
        driverPaymentProduct.setNumberOfOrder(number);
    }

    @Override
    public DriverPaymentProduct getDriverPaymentProduct() {
        return driverPaymentProduct;
    }
}
