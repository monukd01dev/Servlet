package com.dao;

import com.model.User;
import com.model.Userlogin;
import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class Dao {
    private Connection con;
    private PreparedStatement stmt;
    private String url = "jdbc:mysql:///registration";
    private String user = "root";
    private String pass = "root";

    public Dao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,user,pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Register method
    public int register(User user) throws SQLException {
        int result =0;
        String query = "insert into employee(first_name,last_name,username,password,address,contact) values(?,?,?,?,?,?)";
        stmt = con.prepareStatement(query);

        stmt.setString(1, user.getFirstname());
        stmt.setString(2, user.getLastname());
        stmt.setString(3, user.getUsername());
        stmt.setString(4, user.getPassword());
        stmt.setString(5, user.getAddress());
        stmt.setString(6, user.getEmail());

        result = stmt.executeUpdate();

        return result;
    }

    //Userlogin method
    public boolean login(Userlogin userlogin) throws SQLException {
        boolean result = false;
        String query = "select * from employee where username = '?' and password = '?'";
        stmt = con.prepareStatement(query);

        stmt.setString(1,userlogin.getUsername());
        stmt.setString(2,userlogin.getPassword());

        ResultSet rs = stmt.executeQuery();

        result = rs.next();

        return result;
    }

}
