package com.phase_one;

import java.sql.*;

public class Firstsql {
    public static void main(String[] args){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql:///revision", "root", "root");
            Statement s = c.createStatement();
//            s.executeUpdate("insert into accounts values('@monukd','Monu Kumar','admin','my question','my answer')");
            ResultSet rs = s.executeQuery("select * from accounts");
            while (rs.next()) {
                System.out.println(rs.getString("username"));
                System.out.println(rs.getString("NAME"));
                System.out.println(rs.getString("PASSWORD"));
                System.out.println(rs.getString("question"));
                System.out.println(rs.getString("answer"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
