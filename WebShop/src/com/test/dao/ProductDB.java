package com.test.dao;

import com.test.beans.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDB extends Product {
    public static List<ProductDB> searchProducts(String searchString, Connection connection) {

        List products = new ArrayList<>();
        // Connection connection = DBConnection.getConnectionToDatabase();
        try {

            String sql = "select * from fruit.products where product_name like '%" + searchString + "%'";

            Statement statement = connection.createStatement();

            ResultSet set = statement.executeQuery(sql);

            while (set.next()) {
                int id = set.getInt("product_id");
                String name = set.getString("product_name");
                String imgPath = set.getString("image_path");

                products.add(new ProductDB(id, name, imgPath));

            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return products;
    }

    private ProductDB(int id, String name, String imagePath) {
        super(id, name, imagePath);
    }
}
