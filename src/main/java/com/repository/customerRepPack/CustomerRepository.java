package com.repository.customerRepPack;

import com.Builder.customerBuilder.CustomerProduct;
import com.Builder.itemBuilder.ItemInterface;
import com.Builder.itemBuilder.ItemProduct;
import com.Builder.itemBuilder.drink.noAlcoholProduct.NoAlcoholicItemInterface;
import com.configPack.domainConf.CustomerConfig;
import com.domain.CustomerDetails;
import com.factory.domain.customerFactory.CustomerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.*;
import java.util.*;

public class CustomerRepository implements CustomerRep
{
    private int highValeu;
    private static CustomerRepository rep =null;
    private CustomerProduct customerProduct;

    private String url="jdbc:mysql://localhost:3306/delivery_system?autoReconnect=true&useSSL=false";
    private String user="root";
    private String password="";
    private Connection conne;

    ApplicationContext ctx2= new AnnotationConfigApplicationContext(CustomerConfig.class);

    CustomerFactory customerFactory=(CustomerFactory)ctx2.getBean("getCustomer");

    private CustomerRepository()
    {
        try {
            this.conne = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static CustomerRepository getInstance()
    {
        if(rep==null)
        {
            rep=new CustomerRepository();
        }
        return rep;
    }


    @Override
    public CustomerProduct create(CustomerProduct cust) {
        try {
            String sql="INSERT INTO customer(CUSTOMER_NUMBER,FIRST_NAME,SURNAME,EMAIL,ADDRESS,PHONE_NUMBER)" +
                    " VALUES ("+getItemNumber()+",'"+cust.getName()+"','"+cust.getSurName()+"','"+cust.getEmailAddress()+"','"+cust.getAddress()+"','"+cust.getPhone_number()+"')";
            PreparedStatement statement=conne.prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("one row inserted in Item table");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CustomerProduct update(CustomerProduct cust) {
        String custNumber=cust.getCustomer_number();
        try {
            String sql="update customer set FIRST_NAME='"+cust.getName()+"',SURNAME='"+cust.getSurName()+"',EMAIL='"+cust.getEmailAddress()+"',ADDRESS='"+cust.getAddress()+"',PHONE_NUMBER='"+cust.getPhone_number()+"'WHERE CUSTOMER_NUMBER="+custNumber+";";
            PreparedStatement statement=conne.prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("one row updated in Item table");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return read(custNumber);


    }

    @Override
    public void delete(String s) {

        int s2=Integer.parseInt(s);

        //before deleting we read first
        System.out.println(read(s).toString()+"\n this customer is deleted");
        try {
            String sql="DELETE from customer WHERE CUSTOMER_NUMBER="+s2+";";
            PreparedStatement statement=conne.prepareStatement(sql);
            statement.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public CustomerProduct read(String s) {
        CustomerDetails cust = customerFactory.getCustomer("customer");      //getting the customerDetails Object
        int s2=Integer.parseInt(s);
        try {
            String sql="select * from customer WHERE CUSTOMER_NUMBER="+s2+";";
            PreparedStatement statement=conne.prepareStatement(sql);
            ResultSet rs=statement.executeQuery();
            while(rs.next())
            {
                cust.customerNumber(rs.getString(1));
                cust.builName(rs.getString(2));
                cust.builSurName(rs.getString(3));
                cust.builEmailAddress(rs.getString(4));
                cust.builAddress(rs.getString(5));
                cust.buildPhone(rs.getString(6));

            } }catch (SQLException e)
        {
            e.printStackTrace();
        }catch (NullPointerException e)
        {
            System.out.println("!!! THIS CUSTOMER DOES NOT EXIST");
        }
        return cust.getCustomer();
    }
    public ArrayList getAll()
    {
        CustomerDetails cust = customerFactory.getCustomer("customer");      //getting the customerDetails Object

        ArrayList<String> myList2 = new ArrayList<>();
        try {
            String sql="select * from customer ;";
            PreparedStatement statement=conne.prepareStatement(sql);
            ResultSet rs=statement.executeQuery();
            while(rs.next())
            {
                cust.customerNumber(rs.getString(1));
                cust.builName(rs.getString(2));
                cust.builSurName(rs.getString(3));
                cust.builEmailAddress(rs.getString(4));
                cust.builAddress(rs.getString(5));
                cust.buildPhone(rs.getString(6));
                myList2.add(cust.getCustomer().toString());

            } }catch (SQLException e)
        {
            e.printStackTrace();
        }


        return myList2;
    }

    @Override
    public CustomerProduct readAll(String type) {
        return null;
    }

    @Override
    public int getItemNumber()
    {
        try {

            String sql="SELECT MAX(CUSTOMER_NUMBER) from CUSTOMER ;";
            PreparedStatement statement=conne.prepareStatement(sql);
            ResultSet rs=statement.executeQuery();
            while (rs.next())
            {
                String s=rs.getString(1);
                highValeu=Integer.parseInt(s)+1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (NullPointerException n)
        {
            highValeu=1000;
        }


        return highValeu;
    }
}
