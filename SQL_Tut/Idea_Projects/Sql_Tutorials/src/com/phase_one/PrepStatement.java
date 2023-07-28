package com.phase_one;
import java.util.*;
import java.sql.*;

public class PrepStatement {

    private Connection con;
    private PreparedStatement st;
    private Scanner sc;

    PrepStatement() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///GITM","root","root");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void showTables() {
        try {

         st = con.prepareStatement("show tables");
         ResultSet rs = st.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    int id,String name,int rollno,String email
    int insertIntoStudent() throws SQLException{
        st = con.prepareStatement("insert into student(id,name,rollno,email) values(?,?,?,?)");
        sc = new Scanner(System.in);

        System.out.print("Enter Student ID       : ");
        int id = sc.nextInt();
        System.out.print("Enter Student Name     : ");
        String name = sc.next();
        System.out.print("Enter Student Roll No  : ");
        int rollno = sc.nextInt();
        System.out.print("Enter Student E-mail   : ");
        String email = sc.next();

        st.setInt(1,id);
        st.setString(2, name);
        st.setInt(3,rollno);
        st.setString(4,email);

        return st.executeUpdate();
    }

    int insertIntoCourse() throws SQLException {
        st = con.prepareStatement("insert into course(name,duration,price) values(?,?,?)");
        sc = new Scanner(System.in);
        System.out.print("Enter Student Course       : ");
        String name = sc.next();
        System.out.print("Enter Student Duration     : ");
        int duration = sc.nextInt();
        System.out.print("Enter Student Price        : ");
        double price = sc.nextDouble();

        st.setString(1,name);
        st.setInt(2,duration);
        st.setDouble(3,price);


        return st.executeUpdate();
    }

    int deletePrompt() {
        sc = new Scanner(System.in);
        System.out.println("---------Delete Student---------");
        System.out.print("Enter the Roll No : ");
        int rollno = sc.nextInt();
        try {
           return deleteStudent(rollno);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;

    }

    int showStudent(int rollno) throws SQLException{
        st = con.prepareStatement("select * from student where rollno = ?");
        st.setInt(1,rollno);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            System.out.println("Student Name    : " + rs.getString("name") + "\nStudent Id     : " + rs.getInt("id") + "\nStudent E-mail    : " + rs.getString("email"));
            return 1;
        } else {
            System.out.println("Please enter correct RollNo :( ");
            return 0;
        }
    }

    int deleteStudent(int rollno)throws SQLException {

        showStudent(rollno);
        sc = new Scanner(System.in);
        System.out.print("\n Are you sure you want to delete this student details...(y/n) : ");

        char ans = sc.next().trim().charAt(0);
        if (ans == 'y') {
            st = con.prepareStatement("delete from student where rollno ='?'");
            st.setInt(1, rollno);
            return st.executeUpdate();
        } else {
            System.out.print("Do you want to search again (y/n) : ");
            char ans1 = sc.next().trim().charAt(0);
            if (ans1 == 'y') {
                deletePrompt();
            }
        }


        return 0;
    }

    public static void main(String[] args) {
        PrepStatement myobj = new PrepStatement();
        myobj.showTables();
        try {
            int ans = myobj.insertIntoStudent();
            int ans1 = myobj.deletePrompt();
            System.out.println(ans+"    "+ans1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
