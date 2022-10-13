package db;

import bo.Item;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Vector;

public class ItemDB extends Item {

    public static Collection searchItems(String item_group){
        Vector v  = new Vector();
        try{
            Connection con = DBManager.getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select itemid, name, image_path, price from item");

            while (resultSet.next()){
                int id = resultSet.getInt("itemid");
                String name = resultSet.getString("name");
                String imagePath = resultSet.getString("image_path");
                int price = resultSet.getInt("price");
                v.addElement(new ItemDB(id, name, imagePath, price));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return v;
    }

    public ItemDB(int itemId, String name, String imagePath, int price) {
        super(itemId, name, imagePath, price);
    }


}
