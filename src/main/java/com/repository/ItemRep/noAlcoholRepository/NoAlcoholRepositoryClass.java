package com.repository.ItemRep.noAlcoholRepository;

import com.Builder.itemBuilder.drink.alcoholProduct.AlcoholProduct;
import com.Builder.itemBuilder.drink.noAlcoholProduct.NoAlcoholicItemInterface;
import com.Builder.itemBuilder.drink.noAlcoholProduct.NoAlcoholicProduct;
import com.configPack.ConfigNoAlcohol;
import com.factory.domain.productFactory.nonAlcoholItemFactory;
import com.factory.repository.NonAlcoholRepFact;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.*;
import java.util.ArrayList;

public class NoAlcoholRepositoryClass implements NoAlcoholRepository {
    private static NoAlcoholRepositoryClass noAlcoholRepositoryClass=null;
    nonAlcoholItemFactory nonAlco;
    ApplicationContext ctx2 = new AnnotationConfigApplicationContext(ConfigNoAlcohol.class);
    int highValeu;
    private NonAlcoholRepFact nonAlcoholRepFact;
    private NoAlcoholicProduct noAlcoholicProduct;
    private String url="jdbc:mysql://localhost:3306/delivery_system?autoReconnect=true&useSSL=false";
    private String user="root";
    private String password="";
    private Connection conne;

    private NoAlcoholRepositoryClass()
    {
        nonAlco = (nonAlcoholItemFactory) ctx2.getBean("getNonAlcohol");
        try {
            this.conne = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static NoAlcoholRepositoryClass getNonAlco()
    {
        if(noAlcoholRepositoryClass==null)
        {
            noAlcoholRepositoryClass = new NoAlcoholRepositoryClass();
        }
        return noAlcoholRepositoryClass;
    }

    @Override
    public NoAlcoholicProduct create(NoAlcoholicProduct noAlcoholicProduct)
    {
        int ITEM_NUMBER=getItemNumber();
        String NAMES=noAlcoholicProduct.getItemName();
        String ITEM_CATEGORY=noAlcoholicProduct.getItemCategory();
       // String ALCOHOL_PERCENT=noAlcoholicProduct.getPercentageOfAlcohol();
        char SIZES=noAlcoholicProduct.getSize();
        String DESCRIPTION =noAlcoholicProduct.getItemDescription();
        double PRICE =noAlcoholicProduct.getPrice();
        try {
            String sql="INSERT INTO nonalcohol_item(ITEM_NUMBER,ITEM_NAME,SIZES,PRICE,ITEM_CATEGORY,ALCOHOL_PERCENT,DESCRIPTION)" +
                    " VALUES ("+ITEM_NUMBER+",'"+NAMES+"','"+SIZES+"',"+PRICE+",'"+ITEM_CATEGORY+"','NA','"+DESCRIPTION+"')";
            PreparedStatement statement=conne.prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("one row inserted in Item table");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return noAlcoholicProduct;
    }


//i will need to find out if it can be possible to set only is provided. this looks like creating a new product.
    @Override
    public NoAlcoholicProduct update(NoAlcoholicProduct noAlcoholicProduct){

        int s2=Integer.parseInt(noAlcoholicProduct.getItemNumber());
        String NAMES=noAlcoholicProduct.getItemName();
        String ITEM_CATEGORY=noAlcoholicProduct.getItemCategory();
        // String ALCOHOL_PERCENT=noAlcoholicProduct.getPercentageOfAlcohol();
        char SIZES=noAlcoholicProduct.getSize();
        String DESCRIPTION =noAlcoholicProduct.getItemDescription();
        double PRICE =noAlcoholicProduct.getPrice();

        try {
            String sql="update nonalcohol_item set ITEM_NAME='"+NAMES+"',SIZES='"+SIZES+"',PRICE="+PRICE+",ITEM_CATEGORY='"+ITEM_CATEGORY+"',DESCRIPTION='"+DESCRIPTION+"'WHERE ITEM_NUMBER="+s2+";";
            PreparedStatement statement=conne.prepareStatement(sql);
            statement.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }

        return read(noAlcoholicProduct.getItemNumber());
    }

    @Override
    public void delete(String s) {
        int s2=Integer.parseInt(s);
        NoAlcoholicItemInterface product=nonAlco.getNonAlcohol("cooldrink");
        try {
            String sql="DELETE from nonalcohol_item WHERE ITEM_NUMBER="+s2+";";
            PreparedStatement statement=conne.prepareStatement(sql);
            statement.executeUpdate();
            }catch (SQLException e)
        {
            e.printStackTrace();
        }


    }

    @Override
    public NoAlcoholicProduct read(String s) {

        NoAlcoholicItemInterface product=nonAlco.getNonAlcohol("cooldrink");

        int s2=Integer.parseInt(s);
        try {
            String sql="select * from nonalcohol_item WHERE ITEM_NUMBER="+s2+";";
            PreparedStatement statement=conne.prepareStatement(sql);
            ResultSet rs=statement.executeQuery();
            while(rs.next())
            {
                product.buildItemNumber(rs.getString(1));
                product.buildItemName(rs.getString(2));
                product.buildItemSize(rs.getString(3).charAt(0));
                product.buildItemPrice(rs.getDouble(4));
                product.buildCategory(rs.getString(5));
                product.buildItemDescription(rs.getString(7));

            } }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return product.getNoAlcohol();
    }

    @Override
    public NoAlcoholicProduct readAll(String type) {
        return null;
    }

    public ArrayList getAll()
    {
        NoAlcoholicItemInterface product=nonAlco.getNonAlcohol("cooldrink");

        ArrayList<String> myList2 = new ArrayList<>();
        try {
            String sql="select * from nonalcohol_item ;";
            PreparedStatement statement=conne.prepareStatement(sql);
            ResultSet rs=statement.executeQuery();
            while(rs.next())
            {
                product.buildItemNumber(rs.getString(1));
                product.buildItemName(rs.getString(2));
                product.buildItemSize(rs.getString(3).charAt(0));
                product.buildItemPrice(rs.getDouble(4));
                product.buildCategory(rs.getString(5));
                product.buildItemDescription(rs.getString(7));

                myList2.add(product.getNoAlcohol().toString());

            } }catch (SQLException e)
        {
            e.printStackTrace();
        }


        return myList2;
    }

    @Override
    public int getItemNumber()
    {
        try {

            String sql="SELECT MAX(ITEM_NUMBER) from ITEM ;";
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
