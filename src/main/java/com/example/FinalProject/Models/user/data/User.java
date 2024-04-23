package com.example.FinalProject.Models.user.data;

import com.example.FinalProject.Database.DatabaseManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class User {

    //STATES
    private final String userID;
    private String username;
    private String role;
    private int countJoinedSpots;
    private ArrayList<String> joinedSpots = new ArrayList<>();
    private ArrayList<String> upPost = new ArrayList<>();
    private ArrayList<String> downPost = new ArrayList<>();
    private ArrayList<String> upComment = new ArrayList<>();
    private ArrayList<String> downComment = new ArrayList<>();

    //CONSTRUCTOR
    public User(String userID) {
        this.userID = userID;
    }

    //GETTERS
    public String getUserID() { return userID; }
    public String getUsername() { return username; }
    public String getRole() { return role; }
    public int getCountJoinedSpots() { return countJoinedSpots; }
    public ArrayList<String> getJoinedSpots() { return joinedSpots; }
    public ArrayList<String> getUpPost() { return upPost; }
    public ArrayList<String> getUpComment() { return upComment; }
    public ArrayList<String> getDownPost() { return downPost; }
    public ArrayList<String> getDownComment() { return downComment; }


    public void updateData() throws SQLException {
        DatabaseManager db_con = new DatabaseManager();
        db_con.getConnection();

        String jSpots, uPost, dPost, uComment, dComment;

        String sql = "SELECT * FROM `users` WHERE id = '" + getUserID() + "'";
        ResultSet rs = db_con.executeSQLRS(sql);

        while(rs.next()){
            this.username = rs.getString("username");
            this.role = rs.getString("role");
            this.countJoinedSpots =  Integer.parseInt(rs.getString("countJoinedSpots"));

            jSpots = rs.getString("joinedSpots");
            this.joinedSpots.clear();
            this.joinedSpots.addAll(List.of(jSpots.split(",")));
            joinedSpots.remove("");

            uPost = rs.getString("upPost");
            this.upPost.clear();
            this.upPost.addAll(List.of(uPost.split(",")));
            upPost.remove("");

            dPost = rs.getString("downPost");
            this.downPost.clear();
            this.downPost.addAll(List.of(dPost.split(",")));
            downPost.remove("");

            uComment = rs.getString("upComment");
            this.upComment.clear();
            this.upComment.addAll(List.of(uComment.split(",")));
            upComment.remove("");

            dComment = rs.getString("downComment");
            this.downComment.clear();
            this.downComment.addAll(List.of(dComment.split(",")));
            downComment.remove("");
        }

        db_con.endConnection();
    }

}
