package domain;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Orders {
    //ApplicationContext ctx = new AnnotationConfigApplicationContext(Appconfig.class);
    private String orderNumeber="282828";
    private String timeOfreceiving="12:38";
    private String timeOfrequestingDriver="12:40";
    private String timeOfComplition="1:20";
    private boolean orderCompleted;

    public Orders() {
    }

    public Orders(ApplicationContext ctx, String orderNumeber, String timeOfreceiving, String timeOfrequestingDriver, String timeOfComplition, boolean orderCompleted) {
        //this.ctx = ctx;
        this.orderNumeber = orderNumeber;
        this.timeOfreceiving = timeOfreceiving;
        this.timeOfrequestingDriver = timeOfrequestingDriver;
        this.timeOfComplition = timeOfComplition;
        this.orderCompleted = orderCompleted;
    }

//    public ApplicationContext getCtx() {
//        return ctx;
//    }

    public String getOrderNumeber() {
        return orderNumeber;
    }

    public String getTimeOfreceiving() {
        return timeOfreceiving;
    }

    public String getTimeOfrequestingDriver() {
        return timeOfrequestingDriver;
    }

    public String getTimeOfComplition() {
        return timeOfComplition;
    }

    public void setOrderNumeber(String orderNumeber) {
        this.orderNumeber = orderNumeber;
    }

    public void setTimeOfreceiving(String timeOfreceiving) {
        this.timeOfreceiving = timeOfreceiving;
    }

    public void setTimeOfrequestingDriver(String timeOfrequestingDriver) {
        this.timeOfrequestingDriver = timeOfrequestingDriver;
    }

    public void setTimeOfComplition(String timeOfComplition) {
        this.timeOfComplition = timeOfComplition;
    }

    public void setOrderCompleted(boolean orderCompleted) {
        this.orderCompleted = true;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderNumeber='" + getOrderNumeber() + '\'' +
                ", timeOfreceiving='" + timeOfreceiving + '\'' +
                ", timeOfrequestingDriver='" + timeOfrequestingDriver + '\'' +
                ", timeOfComplition='" + timeOfComplition + '\'' +
                ", orderCompleted=" + orderCompleted +
                '}';
    }

    public boolean isOrderCompleted()
    {
        return orderCompleted;
    }
    public Orders getOrder()
    {
        return new Orders();


    }
}



