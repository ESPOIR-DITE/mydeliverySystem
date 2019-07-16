package com.repository.casher;

import com.Builder.cashierBuilderPack.CashierInt;
import com.Builder.cashierBuilderPack.CashierProduct;
import com.configPack.factoryConfig.FactorycashierConfig;
import com.domain.Cashier;
import com.factory.domain.cashierFactory.CashierFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.*;
import java.util.ArrayList;

public class CashierRep implements CahierInterface {
    private  static CashierRep cashierRep=null;
    private CashierProduct cashier;
    private int value;
    CashierProduct cashierProduct;

    private String url="jdbc:mysql://localhost:3306/delivery_system?autoReconnect=true&useSSL=false";
    String user="root";
    String password="";
    Connection conne;

    //to get the factory that will help to build cashier

    ApplicationContext ctx = new AnnotationConfigApplicationContext(FactorycashierConfig.class);


    CashierFactory cashierFactory;
    ApplicationContext ctx2 = new AnnotationConfigApplicationContext(FactorycashierConfig.class);


    private CashierRep()
    {
        //cashierFactory.getCashier("cashier");
        try {
            this.conne = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static CashierRep getCashierRep() {
        if(cashierRep==null)
        {
            cashierRep =new CashierRep();
        }
        return cashierRep;
    }

    @Override
    public CashierProduct create(CashierProduct cashierProduct) {

        System.out.println(cashierProduct.toString());


        try {
            String sql="INSERT INTO cashier(ID,FISTNAME,SURNAME) VALUES ("+cashierProduct.getId()+",'"+cashierProduct.getName()+"','"+cashierProduct.getSurName()+"')";
            PreparedStatement statement=conne.prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("one row inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CashierProduct update(CashierProduct cashierProduct) {
        cashier = new CashierProduct();
        try {
            String sql="INSERT INTO CASHIER(ID,NAME,SURNAME) VALUES ("+cashier.getId()+","+cashier.getName()+","+cashier.getSurName()+")";
            PreparedStatement statement=conne.prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("one row inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(String s) {// this method should read what is supposed to be deleted before deleting.
        int s2=Integer.parseInt(s);
        System.out.println("This record was deliter!!!");
        read(s);

        try {
            String sql="DELETE from CASHIER  WHERE ID ="+s2+";";
                PreparedStatement statement=conne.prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("one row deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CashierProduct read(String s) {
        cashierFactory=(CashierFactory)ctx2.getBean("getCashier");
        CashierInt cashier=cashierFactory.getCashier("cashier");

        //int s2=Integer.parseInt(s);
        try {
            String sql="select * from CASHIER WHERE ID="+s+";";
            PreparedStatement statement=conne.prepareStatement(sql);
            ResultSet rs=statement.executeQuery();
            while(rs.next())
            {
                cashier.buildId(rs.getInt(1));
                cashier.buildName(rs.getString(2));
                cashier.buildSurname(rs.getString(3));
                //System.out.println(cashier.getCashier());



        } }catch (SQLException e)
            {
            e.printStackTrace();
        }
        //********this method should return an object like "/ cashier.getCashier.toString
        return cashier.getCashier();
    }

    @Override
    public CashierProduct readAll(String type) {

        //this methode should return an arraylist<>

        ArrayList<String>myList=new ArrayList<>();

        try {
            String sql="select * from CASHIER ORDER BY ID;";
            PreparedStatement statement=conne.prepareStatement(sql);
            ResultSet rs=statement.executeQuery();
            while(rs.next())
            {

                cashier.setId(Integer.parseInt(rs.getString("1")));
                cashier.setName(rs.getString("2"));
                cashier.setSurName(rs.getString("3"));
                myList.add(cashier.toString());

            } }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getItemNumber() {
        int highValeu=0;
        try {
            String sql="select MAX(ID) from CASHIER ;";
            PreparedStatement statement=conne.prepareStatement(sql);
            ResultSet rs=statement.executeQuery();
            while(rs.next())
            {
                highValeu=Integer.parseInt(rs.getString(1));
            } }catch (SQLException e)
        {
            e.printStackTrace();
        }catch (NullPointerException e )
    {
        highValeu=1000;
    }catch (NumberFormatException x){ highValeu=1000;}


        return highValeu;

    }
    public ArrayList getAll()
    {
        ArrayList<CashierProduct>myList=new ArrayList<>();
        ArrayList<String>myList2=new ArrayList<>();

        //trying to get to build cashier.
        cashierFactory=(CashierFactory)ctx.getBean("getCashier");
        CashierInt cashier=cashierFactory.getCashier("cashier");

        try {
            String sql="select * from cashier ORDER BY ID;";
            PreparedStatement statement=conne.prepareStatement(sql);
            ResultSet rs=statement.executeQuery();
            while(rs.next())
            {
                cashier.buildId(rs.getInt(1));
                cashier.buildName(rs.getString(2));
                cashier.buildSurname(rs.getString(3));
                myList2.add(cashier.getCashier().toString());
                //myList.add(cashier.getCashier());


            } }catch (SQLException e)
        {
            e.printStackTrace();
        }
        /**
        for (int i=0;i<myList2.size();i++)
        {
            System.out.println(myList2.get(i));
        }*/
        return myList2;

    }
}
