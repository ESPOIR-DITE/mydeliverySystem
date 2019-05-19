package Builder.orderBuilder;

public class Orderdirector
{
    private OrderInt orderInt=null;

    public Orderdirector(OrderInt orderInt)
    {
        this.orderInt=orderInt;
    }
    public void constructOrder(String orderNumeber, String customerNumber, String driverNumber, String timeOfPlacing, String timeOfPickUp, String timeOfComplition, boolean orderCompleted, String cashierId, String comment)
    {
       orderInt.buildOrderCompleted(orderCompleted);
       orderInt.buildOrderNumber(orderNumeber);
       orderInt.buildCustomerNumber(customerNumber);
       orderInt.buildCashierId(cashierId);
       orderInt.buildDriverNumber(driverNumber);
       orderInt.buildTimeOfCompletion(timeOfComplition);
       orderInt.buildTimeOfPickUp(timeOfPickUp);
       orderInt.buildTimeOfPlacing(timeOfPlacing);
       orderInt.buildComment(comment);
    }
    public Orders getOPrders()
    {
        return orderInt.getOrders();
    }
}
