package Builder.orderBuilder;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/***this is the product class*/
public class Orders {
    private String orderNumeber;
    private String customerNumber;
    private String driverNumber;
    private String timeOfPlacing;
    private String timeOfPickUp;
    private String timeOfComplition;
    private boolean orderCompleted;
    private String cashierId;
    private String comment;



    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getOrderNumeber() {
        return orderNumeber;
    }

    public void setOrderNumeber(String orderNumeber) {
        this.orderNumeber = orderNumeber;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getDriverNumber() {
        return driverNumber;
    }

    public void setDriverNumber(String driverNumber) {
        this.driverNumber = driverNumber;
    }

    public String getTimeOfPlacing() {
        return timeOfPlacing;
    }

    public void setTimeOfPlacing(String timeOfPlacing) {
        this.timeOfPlacing = timeOfPlacing;
    }

    public String getTimeOfPickUp() {
        return timeOfPickUp;
    }

    public void setTimeOfPickUp(String timeOfPickUp) {
        this.timeOfPickUp = timeOfPickUp;
    }

    public String getTimeOfComplition() {
        return timeOfComplition;
    }

    public void setTimeOfComplition(String timeOfComplition) {
        this.timeOfComplition = timeOfComplition;
    }

    public boolean isOrderCompleted() {
        return orderCompleted;
    }

    public void setOrderCompleted(boolean orderCompleted) {
        this.orderCompleted = orderCompleted;
    }

    public String getCashierId() {
        return cashierId;
    }

    public void setCashierId(String cashierId) {
        this.cashierId = cashierId;
    }

    @Override
    public String toString() {
        return  "   Orders\n   -------" +
                "\n orderNumeber:        " + orderNumeber +
                "\n customerNumber:     " + customerNumber +
                "\n driverNumber:       " + driverNumber +
                "\n timeOfPlacing:      " + timeOfPlacing +
                "\n timeOfPickUp:       " + timeOfPickUp +
                "\n timeOfComplition:   " + timeOfComplition +
                "\n orderCompleted:     " + orderCompleted +
                "\n cashierId:          " + cashierId ;
    }
}



