package db;

import bo.User;

import java.sql.*;
import java.util.Collection;
import java.util.Vector;

public class UserDB extends User {


    public static Collection searchUser(String user) {
        Vector v = new Vector();

        try{
            Connection connection = DBManager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select username, password from user");

            while(resultSet.next()){
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                v.addElement(new UserDB(username, password));
            }

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return v;
    }

    private UserDB(String username, String password) {
        super(username, password);
    }
}
