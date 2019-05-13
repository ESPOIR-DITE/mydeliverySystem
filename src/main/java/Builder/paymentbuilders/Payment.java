package Builder.paymentbuilders;

import Builder.paymentbuilders.DriverPaymentProduct;

public interface Payment {
      void distance(int distance);
      void paymentRate(int rate);
      void numberOfOrder(int number);
      DriverPaymentProduct getDriverPaymentProduct();


}
