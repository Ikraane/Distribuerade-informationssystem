package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static DBManager instance = null;
    private Connection con = null;

    private static DBManager getInstance() {
        if(instance == null){
            instance = new DBManager();
        }
        return instance;
    }

    private DBManager(){
        try{
            Class.forName("con.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webbshop", "root", "citronkaramell");
        }catch(SQLException | ClassNotFoundException e){
            System.out.println("Message: " + e.getMessage());

        }
    }

    public static Connection getConnection(){
        return getInstance().con;
    }
}
