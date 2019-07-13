package com.repository.ItemRep.alcoholRepository;
import com.Builder.itemBuilder.drink.alcoholProduct.AlcoholProduct;

import java.sql.*;
import java.util.NoSuchElementException;

public class AlcoholRepositoryClass implements AlcoholRepository {
    private String url="jdbc:mysql://localhost:3306/delivery_system?autoReconnect=true&useSSL=false";
    String user="root";
    String password="";
    Connection conne;
    int highValeu;

    String ITEM_NUMBER ;
    String NAMES  ;
    String ITEM_CATEGORY ;
    String ALCOHOL_PERCENT ;
    char SIZES  ;
    String DESCRIPTION,percentage ;
    double PRICE;

    private static AlcoholRepositoryClass alcoholRepository=null;
    private AlcoholProduct alcoholProduct;

    private AlcoholRepositoryClass()
    {
        try {
            this.conne = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static AlcoholRepositoryClass getAlcoholRepository()
    {
        if(alcoholRepository==null)
        {
            alcoholRepository = new AlcoholRepositoryClass();
        }
        return alcoholRepository;
    }
    @Override
    public AlcoholProduct create(AlcoholProduct alcoholProduct)
    {
        System.out.println(getItemNumber());
        int ITEM_NUMBER=getItemNumber();
        int ITEM_NUM=Integer.parseInt(alcoholProduct.getItemNumber().trim());
        String NAMES=alcoholProduct.getItemName();
        String ITEM_CATEGORY=alcoholProduct.getItemCategory();
        String ALCOHOL_PERCENT=alcoholProduct.getPercentageOfAlcohol();
        char SIZES=alcoholProduct.getSize();
        String DESCRIPTION =alcoholProduct.getItemDescription();
        double PRICE =alcoholProduct.getPrice();
        try {
            String sql="INSERT INTO ITEM(ITEM_NUMBER,ITEM_NAME,SIZES,PRICE,ITEM_CATEGORY,ALCOHOL_PERCENT,DESCRIPTION)" +
                    " VALUES ("+ITEM_NUMBER+",'"+NAMES+"','"+SIZES+"',"+PRICE+",'"+ITEM_CATEGORY+"','"+ALCOHOL_PERCENT+"','"+DESCRIPTION+"')";
            PreparedStatement statement=conne.prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("one row inserted in Item table");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public AlcoholProduct update(AlcoholProduct alcoholProduct)// to be reviewed
    {try
    {
        String sql="UPDATE ITEM SET ..... WHERE ITEM_NUMBER='"+ alcoholProduct+"'";
        PreparedStatement statement=conne.prepareStatement(sql);
        statement.executeUpdate();

    }//end try
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return alcoholProduct;
    }

    @Override
    public void delete(String s)
    { try{
            String sql="delete ITEM WHERE ITEM_NUMBER='"+s+"'";
            PreparedStatement statement=conne.prepareStatement(sql);
            statement.executeQuery();
        }//end try
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public AlcoholProduct read(String s) {
        try{
            String sql="SELECT * FROM ITEM WHERE ITEM_NUMBER='"+s+"'";
            PreparedStatement statement=conne.prepareStatement(sql);
            ResultSet rs=statement.executeQuery();
            while(rs.next())
            {
                 ITEM_NUMBER=rs.getString("ITEM_NUMBER");
                 NAMES=rs.getString("NAME");
                 ITEM_CATEGORY=rs.getString("CATEGORY");
                 ALCOHOL_PERCENT=rs.getString("ALCOHOL_PERC");
                 SIZES=rs.getString("SIZES").charAt(0);
                 DESCRIPTION =rs.getString("DESCRIPTION");
                 PRICE =rs.getDouble("PRICE");
                 percentage=rs.getString("PERCENTAGE_OF_ALCOHOL");
            }//end while loop


        }//end try
        catch (SQLException e)
        {
            e.getMessage();
        }
        alcoholProduct.setPrice(PRICE);
        alcoholProduct.setItemDescription(DESCRIPTION);
        alcoholProduct.setItemName(NAMES);
        alcoholProduct.setItemNumber(ITEM_NUMBER);
        alcoholProduct.setSize(SIZES);
        alcoholProduct.setItemCategory(ITEM_CATEGORY);
        alcoholProduct.setPercentageOfAlcohol(percentage);


        return alcoholProduct;
    }

    @Override
    public AlcoholProduct readAll(String type) {
        return alcoholProduct;
    }

    @Override
    public int getItemNumber() {


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
