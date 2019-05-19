package repository.ItemRep;

import Builder.itemBuilder.ItemInterface;
import Builder.itemBuilder.ItemProduct;
import factory.productFactory.ItemFactory;

import java.sql.*;
import java.util.List;

public class ItemRepository implements ItemRepo {

    private String url="jdbc:mysql://localhost:3306/delivery_system?autoReconnect=true&useSSL=false";
    String user="root";
    String password="";
    Connection conne;
    String size;

    /***variable**/
    String itmNumber;

    String itmeName;

    double price;

    char sizes;

    String des ;

/*****the following is the private INSTANCE STATIC THAT REPRESENTS THE CLASS***/
    private static ItemRepository repository=null;
    private ItemProduct itemProduct;
    private ItemInterface itemInterface;

    private ItemRepository() {
        try {
            this.conne = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
       // itemInterface=I
    }

    public static ItemRepository getInstance()
    {
        if(repository==null)
        {
            repository=new ItemRepository();
        }
        return repository;
    }

/***
    @Override
    public List<ItemProduct> getItems() {
        return null;
    }*/

    public void createTable()
    {
        try {
            String sql="CREATE TABLE ITEM(ITEM_NUMBER INTEGER(6),NAMES VARCHAR(30),SIZES CHAR, PRICE DOUBLE(8,2), DESCRIPTION VARCHAR (30)) ";
            PreparedStatement statement=conne.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ItemProduct create(ItemProduct itemProduct)
    {
        try {
            String sql="INSERT INTO ITEM(ITEM_NUMBER,NAMES,SIZES,PRICE, DESCRIPTION ) VALUES ('"+itemProduct.getItemNumber()+"','"+itemProduct.getName()+"','"+itemProduct.getSize()+"','"+itemProduct.getPrice()+"','"+itemProduct.getDescription()+"');";
            PreparedStatement statement=conne.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ItemProduct update(ItemProduct itemProduct) {
        return null;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public ItemProduct read(String s)/***THIS METHOD ALLOW TO READ OME ROW IN THE TABLE**/
    {
        try {
            int itemNumber=Integer.parseInt(s);
            String sql="SELECT * from ITEM WHERE ITEM_NUMBER='"+itemNumber+"';";
            PreparedStatement statement=conne.prepareStatement(sql);
            ResultSet rs=statement.executeQuery();
            while (rs.next())
            {
                String itmNumber=rs.getString("ITEM_NUMBER");
                String itmeName=rs.getString("NAMES");
                double price=rs.getDouble("PRICE");
                char size=rs.getString("SIZE").charAt(0);
                String des=rs.getString("DESCRIPTION");
               // System.out.println(itmNumber+" "+itmeName+" "+price+" "+size+" "+des+" "+des);

                /***
                itemProduct.setItemNumber(rs.getString("ITEM_NUMBER"));
                itemProduct.setName(rs.getString("NAMES"));
                itemProduct.setPrice(rs.getDouble("PRICE"));
                itemProduct.setSize(rs.getString("SIZE").charAt(0));
                itemProduct.setDescription((rs.getString("DESCRIPTION")));*/
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return itemProduct;
    }

    @Override
    public ItemProduct readAll(String type)
    {
        ItemFactory itemFactory = new ItemFactory();
        ItemInterface a1 = itemFactory.getItem(type);
        try {
            String sql="SELECT * from ITEM;";
            PreparedStatement statement=conne.prepareStatement(sql);
            ResultSet rs=statement.executeQuery();
            while (rs.next())
            {
               // itemProduct=new ItemProduct();
                 itmNumber=rs.getString("ITEM_NUMBER");

                 itmeName=rs.getString("NAMES");

                 price=rs.getDouble("PRICE");

                  sizes=rs.getString("SIZES").charAt(0);

                  des=rs.getString("DESCRIPTION");

                System.out.println(itmNumber+" "+itmeName+" "+price+" "+size+" "+des+" "+des);
                /***
                itemProduct.setItemNumber(rs.getString("ITEM_NUMBER"));
                itemProduct.setName(rs.getString("NAMES"));
                itemProduct.setPrice(rs.getDouble("PRICE"));
                itemProduct.setSize(rs.getString("SIZES").charAt(0));
                itemProduct.setDescription(rs.getString("DESCRIPTION"));*/

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        a1.buildItemNumber(itmNumber);
        a1.buildItemName(itmeName);
        a1.buildItemPrice(price);
        a1.buildItemSize(sizes);
        a1.buildItemDescription(des);
       // itemProduct.setSize();

        return a1.getItemProduct();
    }

    @Override
    public ItemProduct insert(ItemProduct itemProduct) {
        return null;
    }

}
