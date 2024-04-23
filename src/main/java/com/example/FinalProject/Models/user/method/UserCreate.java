package com.example.FinalProject.Models.user.method;

import com.example.FinalProject.Database.DatabaseManager;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserCreate extends Method{

    //Constructor
    public UserCreate(String username, String password) {
        super(username, password);
    }

    //Check if username already exist
    public boolean isExist() throws SQLException {
        DatabaseManager db_con = new DatabaseManager();
        db_con.getConnection();
        String result;

        String sql = "SELECT `username` FROM `users` WHERE username = '" + getUsername() + "'";
        ResultSet rs = db_con.executeSQLRS(sql);

        while(rs.next()){
            result = rs.getString("username");
            if(result.equals(getUsername())){
                db_con.endConnection();
                return true;
            }
        }
        db_con.endConnection();
        return false;
    }

    //Insert user to database
    public void insertUser() throws SQLException {
        DatabaseManager db_con = new DatabaseManager();
        db_con.getConnection();

        String sql = "INSERT INTO `users` (`username`, `password`, `joinedSpots`, `upPost`, `upComment`, `downPost`, `downComment`) " +
                "VALUES ('" + getUsername() + "', '" + getEncryptedPassword() + "', '', '', '', '', '')";
        db_con.executeSQL(sql);

        System.out.println("CREATE USER: SUCCESS");
        db_con.endConnection();
    }
}
