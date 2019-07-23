package com.repository.ItemRep.classicProducat;

import com.Builder.itemBuilder.classicProduct.ClassiProductInterface;
import com.Builder.itemBuilder.classicProduct.ClassicProduct;
import com.factory.domain.productFactory.ClassicItemFactory;

import java.sql.*;
import java.util.ArrayList;

public class ClassicProductRep implements ClassicRepInt {
    //Mysql settup
    private String url="jdbc:mysql://localhost:3306/delivery_system?autoReconnect=true&useSSL=false";
    private String user="root";
    private String password="";
    private Connection conne;
    private static ClassicProductRep classic=null;

    private ClassicProductRep() {
        try {
            this.conne = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static ClassicProductRep getClassic()
    {
        if(classic==null)
        {
            classic=new ClassicProductRep();
        }return classic;
    }

    @Override
    public ClassicProduct create(ClassicProduct clas) {
        int ItemNumber=getItemNumber();
        String ItemNumberStr=""+ItemNumber+"";
        try {
            String sql="INSERT INTO classic_prodaut(NAME,ITEM_NUMBER,DESCRIPTION,PRICE,FLAVER,CATEGORY)" +
                    " VALUES ('"+clas.getName()+"',"+ItemNumber+",'"+clas.getDescription()+"',"+clas.getPrice()+",'"+clas.getFlavor()+"','"+clas.getCategory()+"');";
            PreparedStatement statement=conne.prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("one row inserted in Item table");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return read(ItemNumberStr);
    }

    @Override
    public ClassicProduct update(ClassicProduct clas) {
        try {
            String sql="update classic_prodaut set NAME='"+clas.getName()+"',DESCRIPTION='"+clas.getDescription()+"',PRICE="+clas.getPrice()+",FLAVER='"+clas.getFlavor()+"',CATEGORY='"+clas.getCategory()+"'WHERE ITEM_NUMBER="+clas.getItemNumber()+";";
            PreparedStatement statement=conne.prepareStatement(sql);
            statement.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return read(clas.getItemNumber());
    }

    @Override
    public void delete(String s) {
        int s2=Integer.parseInt(s);
        System.out.println(read(s).toString()+"\n thes records are deleted");
        try {
            String sql="DELETE from classic_prodaut WHERE ITEM_NUMBER="+s2+";";
            PreparedStatement statement=conne.prepareStatement(sql);
            statement.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }


    }

    @Override
    public ClassicProduct read(String s) {
        ClassicItemFactory clasFac=new ClassicItemFactory();
        ClassiProductInterface getClassicP=clasFac.getClassicProduct("cigaratte");


        int s2=Integer.parseInt(s);
        try {
            String sql="select * from classic_prodaut WHERE ITEM_NUMBER="+s2+";";
            PreparedStatement statement=conne.prepareStatement(sql);
            ResultSet rs=statement.executeQuery();
            while(rs.next())
            {
                getClassicP.buildItemNumber(rs.getString(1));
                getClassicP.buildItemName(rs.getString(2));
                getClassicP.buildItemPrice(rs.getDouble(4));
                getClassicP.flavor(rs.getString(5));
                getClassicP.buildItemDescription(rs.getString(3));
                getClassicP.buildCategory(rs.getString(6));

            } }catch (SQLException e)
        {
            e.printStackTrace();
        }
        getClassicP.buildItemNumber(s);
        return getClassicP.getClassic();
    }

    @Override
    public ClassicProduct readAll(String type) {
        return null;
    }
    public ArrayList getAll()
    {
        ArrayList<String> myList2 = new ArrayList<>();
        ClassicItemFactory clasFac=new ClassicItemFactory();
        ClassiProductInterface getClassicP=clasFac.getClassicProduct("cigaratte"); // we have used a default item category
        try {
            String sql="select * from classic_prodaut ;";
            PreparedStatement statement=conne.prepareStatement(sql);
            ResultSet rs=statement.executeQuery();
            while(rs.next())
            {
                getClassicP.buildItemNumber(rs.getString(1));
                getClassicP.buildItemName(rs.getString(2));
                getClassicP.buildItemDescription(rs.getString(3));
                getClassicP.buildItemPrice(rs.getDouble(4));
                getClassicP.flavor(rs.getString(5));
                getClassicP.buildCategory(rs.getString(6));
                myList2.add(getClassicP.getClassic().toString());
            } }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return myList2;
    }

    @Override
    public int getItemNumber() {
        int highValeu=0;
        try {
            String sql="SELECT MAX(ITEM_NUMBER) from classic_prodaut ;";
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
        }catch (NumberFormatException x)
        {
            highValeu=1000;
        }
        return highValeu;
    }
}
