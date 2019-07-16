package com.repository.orderRepository;

import com.Builder.orderBuilder.OrderInt;
import com.Builder.orderBuilder.Orders;
import com.domain.OrderClass;
import com.factory.domain.orderFactory.OrderFacto;

import java.sql.*;
import java.util.ArrayList;

public class OrderRep implements OrderRepositoryIn
{
    private String url="jdbc:mysql://localhost:3306/delivery_system?autoReconnect=true&useSSL=false";
    String user="root";
    String password="";
    Connection conne;

    String valeu;

    private String orderNumeber;
    private String customerNumber;
    private String driverNumber;
    private String timeOfPlacing;
    private String timeOfPickUp;
    private String timeOfComplition;
    private boolean orderCompleted;
    private String cashierId;
    private String comment;

    private static OrderRep orderRep=null;
    private OrderClass orderClass;

    private OrderRep()
    {
        try {
            this.conne = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static OrderRep getOrders()
    {
        if(orderRep==null)
            orderRep= new OrderRep();
        return orderRep;

    }
    //String sql="CREATE TABLE ORDERS(ORDER_NUMBER INTEGER(6),CUSTOMER_NUMBER INTEGER(6),DRIVER_NUMBER INTEGER(6),CASHIER_NUMBER INTEGER(6),TIME_PLACING VARCHAR(10),TIME_PICKUP VARCHAR(10),TIME_COMPLETION VARCHAR(10),ORDER_COMPLETED boolean ,COMMENT varchar(30))";
    @Override
    public Orders create(Orders ord) {
        try {
            String sql="insert into ORDERS(ORDER_NUMBER ,CUSTOMER_NUMBER ,DRIVER_NUMBER ,CASHIER_NUMBER ,TIME_PLACING ,TIME_PICKUP,TIME_COMPLETION,ORDER_COMPLETED ,COMMENT)" +
                    "VALUES ("+getItemNumber()+","+ord.getCustomerNumber()+","+ord.getDriverNumber()+","+ord.getCashierId()+",'"+ord.getTimeOfPlacing()+"','"+ord.getTimeOfPickUp()+"','"+ord.getTimeOfComplition()+"',"+ord.isOrderCompleted()+",'"+ord.getComment()+"');";
            PreparedStatement statement=conne.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Orders update(Orders ord) {
        try {
            String sql="update ORDERS set CUSTOMER_NUMBER="+ord.getCustomerNumber()+",DRIVER_NUMBER="+ord.getDriverNumber()+",CASHIER_NUMBER="+ord.getCashierId()+
                    ",TIME_PLACING='"+ord.getTimeOfPlacing()+"',TIME_PICKUP='"+ord.getTimeOfPickUp()+"',TIME_COMPLETION='"+ord.getTimeOfComplition()+"',ORDER_COMPLETED="+ord.isOrderCompleted()+",COMMENT='"+ord.getComment()+"'WHERE ORDER_NUMBER='"+ord.getOrderNumeber()+"';";
            PreparedStatement statement=conne.prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("one row updated in Driver table");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return read(ord.getOrderNumeber());
    }

    @Override
    public void delete(String s) {
        int s2=Integer.parseInt(s);

        //before deleting we read first
        System.out.println(read(s).toString()+"\n this order is deleted");
        try {
            String sql="DELETE from ORDERS WHERE ORDER_NUMBER="+s2+";";
            PreparedStatement statement=conne.prepareStatement(sql);
            statement.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public Orders read(String s) {
        OrderFacto orderFacto=new OrderFacto();
        OrderInt a1=orderFacto.getOrders("order");
        int s2=Integer.parseInt(s);
        try {
            String sql="select * from ORDERS WHERE ORDER_NUMBER="+s2+";";
            PreparedStatement statement=conne.prepareStatement(sql);
            ResultSet rs=statement.executeQuery();
            while(rs.next())
            {
                a1.buildOrderNumber(rs.getString(1));
                a1.buildCustomerNumber(rs.getString(2));
                a1.buildDriverNumber(rs.getString(3));
                a1.buildCashierId(rs.getString(4));
                a1.buildTimeOfPlacing(rs.getString(5));
                a1.buildTimeOfPickUp(rs.getString(6));
                a1.buildTimeOfCompletion(rs.getString(7));
                a1.buildOrderCompleted(rs.getBoolean(8));
                a1.buildComment(rs.getString(9));


            } }catch (SQLException e)
        {
            e.printStackTrace();
        }catch (NullPointerException e)
        {
            System.out.println("!!! THIS CUSTOMER DOES NOT EXIST");
        }
        return a1.getOrders();

    }

    @Override
    public Orders readAll(String type) {
        try {
            String sql="select * from ORDERS ORDER BY TIME_PLACING;";
            PreparedStatement statement=conne.prepareStatement(sql);
            ResultSet rs=statement.executeQuery();
            while(rs.next())
            {
                orderNumeber=rs.getString("ORDER_NUMBER");
                customerNumber=rs.getString("CUSTOMER_NUMBER");
                driverNumber=rs.getString("DRIVER_NUMBER");
                timeOfPlacing=rs.getString("TIME_PLACING");
                timeOfPickUp=rs.getString("TIME_PICKUP");
                timeOfComplition=rs.getString("TIME_COMPLETION");
                orderCompleted=rs.getBoolean("ORDER_COMPLETED");
                cashierId=rs.getString("CASHIER_NUMBER");
                comment=rs.getString("COMMENT");
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }
    public ArrayList getAll()
    { ArrayList<String>myList=new ArrayList<>();
        OrderFacto orderFacto=new OrderFacto();
        OrderInt a1=orderFacto.getOrders("order");


        try {
            String sql="select * from ORDERS ORDER BY TIME_PLACING;";
            PreparedStatement statement=conne.prepareStatement(sql);
            ResultSet rs=statement.executeQuery();
            while(rs.next())
            {
                a1.buildOrderNumber(rs.getString(1));
                a1.buildCustomerNumber(rs.getString(2));
                a1.buildDriverNumber(rs.getString(3));
                a1.buildCashierId(rs.getString(4));
                a1.buildTimeOfPlacing(rs.getString(5));
                a1.buildTimeOfPickUp(rs.getString(6));
                a1.buildTimeOfCompletion(rs.getString(7));
                a1.buildOrderCompleted(rs.getBoolean(8));
                a1.buildComment(rs.getString(9));
                myList.add(a1.getOrders().toString());
            }} catch (SQLException e) {
            e.printStackTrace();
        }

        return myList;
    }

    @Override
    public int getItemNumber() {
        int highValeu=0;
        try {

            String sql="SELECT MAX(ORDER_NUMBER) from ORDERS ;";
            PreparedStatement statement=conne.prepareStatement(sql);
            ResultSet rs=statement.executeQuery();
            while (rs.next())
            {
                String s=rs.getString(1);
                highValeu=Integer.parseInt(s)+1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (NullPointerException e )
        {
            highValeu=1000;
        }catch (NumberFormatException x){ highValeu=1000;}


        return highValeu;
    }


    public Orders insert(Orders orderClass) {
        return null;
    }


    public String readAll() {
        try {
            String sql="select * from ORDERS ORDER BY TIME_PLACING;";
            PreparedStatement statement=conne.prepareStatement(sql);
            ResultSet rs=statement.executeQuery();
            while(rs.next())
            {
                orderNumeber=rs.getString("ORDER_NUMBER");
                customerNumber=rs.getString("CUSTOMER_NUMBER");
                driverNumber=rs.getString("DRIVER_NUMBER");
                timeOfPlacing=rs.getString("TIME_PLACING");
                timeOfPickUp=rs.getString("TIME_PICKUP");
                timeOfComplition=rs.getString("TIME_COMPLETION");
                orderCompleted=rs.getBoolean("ORDER_COMPLETED");
                cashierId=rs.getString("CASHIER_NUMBER");
                comment=rs.getString("COMMENT");
            }
            valeu=String.format(cashierId+""+orderCompleted+" "+customerNumber+" "+driverNumber+" "+timeOfPlacing+" "+timeOfPickUp+" "+timeOfComplition+" "+orderCompleted+" "+comment+"\n read");

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return valeu;
    }

    @Override
    public String insertAll(Orders order)// i think this method should be used to pass in the valeus for the new orders.
    {
        orderNumeber=order.getOrderNumeber();
        customerNumber=order.getCustomerNumber();
        driverNumber=order.getDriverNumber();
        timeOfPlacing=order.getTimeOfPlacing();
        timeOfPickUp=order.getTimeOfPickUp();
        timeOfComplition=order.getTimeOfComplition();
        orderCompleted=order.isOrderCompleted();
        cashierId=order.getCashierId();
        comment=order.getComment();
        String valeu=String.format(cashierId+""+orderCompleted+" "+customerNumber+" "+driverNumber+" "+timeOfPlacing+" "+timeOfPickUp+" "+timeOfComplition+" "+orderCompleted+" "+comment+"\n inserted");

        try {
            String sql="INSERT INTO ORDERS(ORDER_NUMBER,CUSTOMER_NUMBER,DRIVER_NUMBER,CASHIER_NUMBER,TIME_PLACING,TIME_PICKUP,TIME_COMPLETION,ORDER_COMPLETED,COMMENT)" +
                    " VALUES ("+orderNumeber+","+customerNumber+","+driverNumber+","+cashierId+",'"+timeOfPlacing+"','"+timeOfPickUp+"','"+timeOfComplition+"',"+orderCompleted+",'"+comment+"')";
            PreparedStatement statement=conne.prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("one row inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return valeu;
    }

}
