package com.repository.drivers;

import com.Builder.driverBuilderPack.DriverProduct;
import com.configPack.domainConf.DriverConfig;
import com.domain.Driver;
import com.factory.domain.driverFactory.DriverFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.*;
import java.util.ArrayList;

public class DriverRep implements DriverRepInt {

    private int value;
    ApplicationContext ctx2= new AnnotationConfigApplicationContext(DriverConfig.class);

    //database setting up
    private String url="jdbc:mysql://localhost:3306/delivery_system?autoReconnect=true&useSSL=false";
    private String user="root";
    private String password="";
    private Connection conne;


    private static DriverRep driverRep=null;
    private DriverRep() {
        try {
            this.conne = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DriverRep getInstance()
    {
        if(driverRep==null)
        {
            return new DriverRep();
        }
        else return null;
    }


    @Override
    public DriverProduct create(DriverProduct driver) {

        try {
            String sql="INSERT INTO DRIVER(DRIVER_CODE,NAME,SURNAME,ADDRESS,EMAIL,PHONE_NUMBER,STATE)" +
                    " VALUES ('"+getItemNumber()+"','"+driver.getName()+"','"+driver.getSurName()+"','"+driver.getAddress()+"','"+ driver.getEmailAddress()+"','"+driver.getPhoner_Number()+"','"+driver.getAvaillable()+"');";
            PreparedStatement statement=conne.prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("one row inserted in Item table");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**when updating we dont need to update the availability of a driver that should change automatically
     * but the incetence that return the availability of the driver is:>>>>driver.getAvailable<<<<<
     * still need to find out the macanism of how tho update only one or two culomn up to the one who want to edit
     *
     * the idea is that if someone want update an row he/she need to provide a driver code so that the application need to provide all the details of
     * that specific driver so that you can edit  those field that you want to edit and save like you were creating a new driver
      * @param driver
     * @return
     */
    @Override
    public DriverProduct update(DriverProduct driver) {

        String custNumber=driver.getCode();
        System.out.println(custNumber);
        try {
            String sql="update driver set NAME='"+driver.getName()+"',SURNAME='"+driver.getSurName()+"',ADDRESS='"+driver.getAddress()+"',EMAIL='"+driver.getEmailAddress()+"',PHONE_NUMBER='"+driver.getPhoner_Number()+"'WHERE DRIVER_CODE='"+custNumber+"';";
            PreparedStatement statement=conne.prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("one row updated in Driver table");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return read(custNumber);
    }

    @Override
    public void delete(String s) {
        int s2=Integer.parseInt(s);

        //before deleting we read first
        System.out.println(read(s).toString()+"\n this driver is deleted");
        try {
            String sql="DELETE from driver WHERE DRIVER_CODE="+s2+";";
            PreparedStatement statement=conne.prepareStatement(sql);
            statement.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public DriverProduct read(String s) {
        DriverFactory driverFactory=(DriverFactory) ctx2.getBean("getDriver");
        Driver driverP=driverFactory.getDriver("driver");

        int s2=Integer.parseInt(s);
        try {
            String sql="select * from driver WHERE DRIVER_CODE="+s2+";";
            PreparedStatement statement=conne.prepareStatement(sql);
            ResultSet rs=statement.executeQuery();
            while(rs.next())
            {
               driverP.buildDriverCode(rs.getString(1));
               driverP.buildName(rs.getString(2));
               driverP.buildSurName(rs.getString(3));
               driverP.buildAddress(rs.getString(4));
               driverP.buildEmailAddress(rs.getString(5));
               driverP.buildPhone_number(rs.getString(6));
               driverP.buildavaillable(rs.getString(7).charAt(0));

            } }catch (SQLException e)
        {
            e.printStackTrace();
        }catch (NullPointerException e)
        {
            System.out.println("!!! THIS CUSTOMER DOES NOT EXIST");
        }
        return driverP.getDriver();
    }

    @Override
    public DriverProduct readAll(String type) {
        return null;
    }
    public ArrayList getAll()
    {
        DriverFactory driverFactory=(DriverFactory) ctx2.getBean("getDriver");
        Driver driverP=driverFactory.getDriver("driver");

        ArrayList<String> myList2 = new ArrayList<>();
        try {
            String sql="select * from driver ;";
            PreparedStatement statement=conne.prepareStatement(sql);
            ResultSet rs=statement.executeQuery();
            while(rs.next())
            {
                driverP.buildDriverCode(rs.getString(1));
                driverP.buildName(rs.getString(2));
                driverP.buildSurName(rs.getString(3));
                driverP.buildAddress(rs.getString(4));
                driverP.buildEmailAddress(rs.getString(5));
                driverP.buildPhone_number(rs.getString(6));
                driverP.buildavaillable(rs.getString(7).charAt(0));
                myList2.add(driverP.getDriver().toString());

            } }catch (SQLException e)
        {
            e.printStackTrace();
        }catch (NullPointerException x){}


        return myList2;
    }

    @Override
    public int getItemNumber() {
    int highValeu=0;
        try {

            String sql="SELECT MAX(DRIVER_CODE) from DRIVER ;";
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
}
