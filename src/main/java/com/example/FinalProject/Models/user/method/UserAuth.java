package com.example.FinalProject.Models.user.method;

import com.example.FinalProject.Database.DatabaseManager;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAuth extends Method{
    private String userID;

    //Constructor
    public UserAuth(String username, String password) {
        super(username, password);
    }

    public String getUserID() {
        return userID;
    }

    //Check if username already exist and password matches
    public boolean isExist() throws SQLException {
        DatabaseManager db_con = new DatabaseManager();
        db_con.getConnection();
        String pass, user;

        String sql = "SELECT `id`, `username`, `password` FROM `users` WHERE username = '" + getUsername() + "'";
        ResultSet rs = db_con.executeSQLRS(sql);

        while(rs.next()){
            user = rs.getString("username");
            pass = rs.getString("password");
            if(pass.equals(getEncryptedPassword()) &&  user.equals(getUsername())){
                userID = rs.getString("id");
                db_con.endConnection();
                return true;
            }
        }

        db_con.endConnection();
        return false;
    }

}
