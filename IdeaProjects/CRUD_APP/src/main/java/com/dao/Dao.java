package com.dao;

import com.model.User;
import com.model.Userlogin;
import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
        String query = "SELECT * FROM employee WHERE username = ? AND PASSWORD = ?";
        stmt = con.prepareStatement(query);

        stmt.setString(1,userlogin.getUsername());
        stmt.setString(2,userlogin.getPassword());


        ResultSet rs = stmt.executeQuery();

        result = rs.next();

        //error solving approach
//        System.out.println(stmt);
//        System.out.println(result);

        return result;
    }

    public String getFullName(String username) throws SQLException {
        String fullname;
        stmt = con.prepareStatement("select * from employee where username = '"+username+"'");
        ResultSet rs = stmt.executeQuery();
        rs.next();
        fullname = rs.getString("first_name")+" "+rs.getString("last_name");
        return fullname;
    }

    public List getAll() throws SQLException {

        List<User> usrList = new ArrayList<User>();

//        sql code
        stmt = con.prepareStatement("select * from employee");
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            User usr = new User();
//(first_name,last_name,username,password,address,contact)
            usr.setFirstname(rs.getString("first_name"));
            usr.setLastname(rs.getString("last_name"));
            usr.setUsername(rs.getString("username"));
            usr.setAddress(rs.getString("address"));
            usr.setEmail(rs.getString("contact"));
            usrList.add(usr);
        }
        return usrList;
    }

}
