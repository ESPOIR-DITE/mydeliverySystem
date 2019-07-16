package com.repository.payment.customerPay;

import com.Builder.customerPaymentBuilder.CustPayment;
import com.Builder.customerPaymentBuilder.CustomerpaymentInterface;
import com.factory.domain.customerPaymentFactory.customerPayFactory;


import java.sql.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CustomerPayRep implements CustomerRepInt  {

    private String url="jdbc:mysql://localhost:3306/delivery_system?autoReconnect=true&useSSL=false";
    private String user="root";
    private String password="";
    private Connection conne;
    /**
     * getting the factory object to build with
     */
    customerPayFactory custF=new customerPayFactory();
    CustomerpaymentInterface custI;


    private static CustomerPayRep customerRep=null;

    private CustomerPayRep() {
        try {
            this.conne = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static CustomerPayRep getCustomerRep() {
        if(customerRep==null)
        {
            customerRep=new CustomerPayRep();
        }
        return customerRep;
    }



    @Override
    public CustPayment create(CustPayment cust) {
        try {
            String sql="insert into customer_p(customerNumber ,orderNumber,amount,vat ,sale,arrengement,tip,PAYMENT_TYPE) " +
                    "VALUES ('"+cust.getCustomerNumber()+"','"+cust.getOrderNumber()+"',"+cust.getAmount()+","+cust.getVat()+","+cust.getSale()+","+cust.getArrengement()+","+cust.getTip()+",'"+cust.getPayment_type()+"');";
            PreparedStatement statement=conne.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CustPayment update(CustPayment cust) {
        try {
            String sql="update customer_p set amount="+cust.getAmount()+",vat="+cust.getVat()+",sale="+cust.getSale()+
                    ",arrengement="+cust.getArrengement()+",tip="+cust.getTip()+",PAYMENT_TYPE='"+cust.getPayment_type()+"'WHERE customerNumber='"+cust.getCustomerNumber()+"' and orderNumber='"+cust.getOrderNumber()+"';";
            PreparedStatement statement=conne.prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("one row updated in Driver table");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //return read("Your update has been saved\n"+ord.getOrderNumeber());
        return null;
    }

    @Override
    public void delete(String s) {
        String orderNumber=null;
        String customerNuber=null;

        StringTokenizer token = new StringTokenizer(s, "#");
        if(s!=null){
            orderNumber=token.nextToken();
            customerNuber=token.nextToken();
        //before deleting we read first
        System.out.println(read(s).toString()+"\n !!!this order is deleted!!!");
        try {
            String sql="DELETE from customer_p WHERE customerNumber='"+customerNuber+"' and orderNumber='"+orderNumber+"';";
            PreparedStatement statement=conne.prepareStatement(sql);
            statement.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }}

    }

    /**
     * this method is getting a concutinated string which contains an orderNumber and customerNumber for a specific order.
     * this means that this table called customer_p in the database has a composed primary key of orderNumber and customerNumber
     * @param s
     * @return
     */
    @Override
    public CustPayment read(String s) {
        System.out.println(s);

        custI=custF.getCustPayment("cash"); //builder object

        String orderNumber=null;
        String customerNuber=null;

        StringTokenizer token = new StringTokenizer(s, "#");
        if(s!=null){
            orderNumber=token.nextToken();
            customerNuber=token.nextToken();

        try {
            String sql="select * from customer_p WHERE customerNumber='"+customerNuber+"' and orderNumber='"+orderNumber+"';";
            PreparedStatement statement=conne.prepareStatement(sql);
            ResultSet rs=statement.executeQuery();
            while(rs.next())
            {

                custI.buildAmount(rs.getDouble(3));
                custI.buildOrderNumber(rs.getString(2));
                custI.buildCustomer(rs.getString(1));
                custI.buildSale(rs.getDouble(5));
                custI.buildTip(rs.getDouble(7));
                custI.buildArangement(rs.getDouble(6));
                custI.buildVat(rs.getDouble(4));
                custI.builPayment_type(rs.getString(8));




            } }catch (SQLException e)
        {
            e.printStackTrace();
        }catch (NullPointerException e)
        {
            System.out.println("!!! THIS CUSTOMER DOES NOT EXIST");
        }
            return custI.getCustPayment();
        }return null;




    }
    public ArrayList getAll()
    { ArrayList<String>myList=new ArrayList<>();

        custI=custF.getCustPayment("cash"); //builder object


        try {
            String sql="select * from customer_p ORDER BY orderNumber;";
            PreparedStatement statement=conne.prepareStatement(sql);
            ResultSet rs=statement.executeQuery();
            while(rs.next())
            {
                custI.buildAmount(rs.getDouble(3));
                custI.buildOrderNumber(rs.getString(2));
                custI.buildCustomer(rs.getString(1));
                custI.buildSale(rs.getDouble(5));
                custI.buildTip(rs.getDouble(7));
                custI.buildArangement(rs.getDouble(6));
                custI.buildVat(rs.getDouble(4));
                custI.builPayment_type(rs.getString(8));
                myList.add(custI.getCustPayment().toString());
            }} catch (SQLException e) {
            e.printStackTrace();
        }

        return myList;
    }

    @Override
    public CustPayment readAll(String type) {
        return null;
    }

    @Override
    public int getItemNumber() {
        return 0;
    }
}
