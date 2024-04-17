package com.example.FinalProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {

    public Connection databaseConnection;

    public Connection getConnection() {
        String databaseName = "CodeAstra";
        String username = "root";
        String password = "pizza123";
        String url = "jdbc:mysql://localhost:3307/" + databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseConnection = DriverManager.getConnection(url, username, password);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return databaseConnection;
    }
}
