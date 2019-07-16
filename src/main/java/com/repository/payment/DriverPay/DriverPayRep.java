package com.repository.payment.DriverPay;

import com.Builder.driverPay.DriverPaymentProduct;
import com.Builder.driverPay.Payment;
import com.Builder.orderBuilder.OrderInt;
import com.factory.domain.orderFactory.OrderFacto;
import com.factory.domain.paymentfacto.PaymentFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DriverPayRep implements DriverPayint {
    private String url="jdbc:mysql://localhost:3306/delivery_system?autoReconnect=true&useSSL=false";
    private String user="root";
    private String password="";
    private Connection conne;
    private static DriverPayRep driverPayRep=null;


    PaymentFactory paymentFactory = new PaymentFactory();
    Payment b1=paymentFactory.getDriverPayInt("month");

    private DriverPayRep() {
        try {
            this.conne = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DriverPayRep getDriverPayRep() {

        if (driverPayRep==null)
        {
             driverPayRep=new DriverPayRep();
        }return driverPayRep;
    }

    @Override
    public DriverPaymentProduct create(DriverPaymentProduct driverP) {
        try {
            String sql="insert into driver_pay(PAY_CODE ,PAY_DATE,DRIVER_NUMBER,PAY_RATE ,NUMBER_ORDER,DISTANCE,SALAIR,PAYMENT_TYPE) " +
                    "VALUES ('"+getItemNumber()+"','"+driverP.getPayDate()+"',"+driverP.getDriverBumber()+","+driverP.getRate()+","+driverP.getNumberOfOrder()+","+driverP.getDistance()+","+driverP.getSalary()+",'"+driverP.getPayType()+"');";
            PreparedStatement statement=conne.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public DriverPaymentProduct update(DriverPaymentProduct driverP) {
      try{  String sql="update driver_pay set PAY_DATE='"+driverP.getPayDate()+"',DRIVER_NUMBER="+driverP.getNumberOfOrder()+",PAY_RATE ="+driverP.getRate()+",NUMBER_ORDER="+driverP.getNumberOfOrder()+",DISTANCE="+driverP.getDistance()+",SALAIR="+driverP.getSalary()+",PAYMENT_TYPE='"+driverP.getPayType()+"' WHERE PAY_CODE="+driverP.getPayCode()+";";
        PreparedStatement statement=conne.prepareStatement(sql);
        statement.executeUpdate();
        System.out.println("one row updated in Driver table");
    } catch (SQLException e) {
        e.printStackTrace();
    }
        return read(driverP.getPayCode());
    }

    @Override
    public void delete(String s) {
        int s2=Integer.parseInt(s);

        //before deleting we read first
        System.out.println(read(s).toString()+"\n !!!this record was deleted");
        try {
            String sql="DELETE from driver_pay WHERE PAY_CODE="+s2+";";
            PreparedStatement statement=conne.prepareStatement(sql);
            statement.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public DriverPaymentProduct read(String s) {
        int s2=Integer.parseInt(s);
        try {
            String sql="select * from driver_pay WHERE PAY_CODE="+s2+";";
            PreparedStatement statement=conne.prepareStatement(sql);
            ResultSet rs=statement.executeQuery();
            while(rs.next())
            {
                b1.payCode(rs.getString(1));
                b1.distance(rs.getInt(5));
                b1.numberOfOrder(rs.getInt(4));
                b1.paymentRate(rs.getInt(3));
                b1.buildDriverNumber(rs.getString(2));
                b1.buildPayDate(rs.getString(8));
               // b1.(rs.getString(7));
                b1.paymentType();                                           // i need to work ont this field in the interface and the product builder


            } }catch (SQLException e)
        {
            e.printStackTrace();
        }catch (NullPointerException e)
        {
            System.out.println("!!! THIS CUSTOMER DOES NOT EXIST");
        }
        return b1.getDriverPaymentProduct();
    }

    @Override
    public DriverPaymentProduct readAll(String type) {
        return null;
    }

    //not tested yet
    public ArrayList getAll()
    { ArrayList<String>myList=new ArrayList<>();
        OrderFacto orderFacto=new OrderFacto();
        OrderInt a1=orderFacto.getOrders("order");
        try {
            String sql="select * from driver_pay ;";
            PreparedStatement statement=conne.prepareStatement(sql);
            ResultSet rs=statement.executeQuery();
            while(rs.next())
            {
                b1.payCode(rs.getString(1));
                b1.distance(rs.getInt(5));
                b1.numberOfOrder(rs.getInt(4));
                b1.paymentRate(rs.getInt(3));
                b1.buildDriverNumber(rs.getString(2));
                b1.buildPayDate(rs.getString(8));
                // b1.(rs.getString(7));
                b1.paymentType();
                myList.add(b1.getDriverPaymentProduct().toString());
            }} catch (SQLException e) {
            e.printStackTrace();
        }

        return myList;
    }

    @Override
    public int getItemNumber() {
        int highValeu=0;
        try {

            String sql="SELECT MAX(PAY_CODE) from driver_pay ;";
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

    /**
    public Date getTime(int year,int month, int day)
    {
         Date date;
        String months[] = {
                "Jan", "Feb", "Mar", "Apr",
                "May", "Jun", "Jul", "Aug",
                "Sep", "Oct", "Nov", "Dec"};
        GregorianCalendar gcalendar = new GregorianCalendar();

        System.out.print(gcalendar.get(Calendar.MONTH));
        System.out.print(" " + gcalendar.get(Calendar.DATE) + " ");
        System.out.println(year = gcalendar.get(Calendar.YEAR));

        Date date1=new Date(year,month,day);
       // date= new Date(gcalendar.get(Calendar.YEAR),months[gcalendar.get(Calendar.MONTH)],gcalendar.get(Calendar.DATE),);
        return date1;
    }*/
}
