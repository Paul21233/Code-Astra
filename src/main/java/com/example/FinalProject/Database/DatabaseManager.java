package com.example.FinalProject.Database;

import java.sql.*;

public class DatabaseManager {

    public Connection databaseConnection;
    public Statement statement;
    public ResultSet resultSet;

    // establishing connection
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

    //Execute method with return data
    public ResultSet executeSQLRS(String sql) throws SQLException {
        statement = databaseConnection.createStatement();
        resultSet = statement.executeQuery(sql);
        return resultSet;
    }

    //Execute method without return data
    public void executeSQL(String sql) throws SQLException {
        statement = databaseConnection.createStatement();
        statement.execute(sql);
    }

    // close connection
    public void endConnection() throws SQLException {
        databaseConnection.close();
    }
}
