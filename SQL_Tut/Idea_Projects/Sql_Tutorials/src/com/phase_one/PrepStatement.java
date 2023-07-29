package com.phase_one;
import java.util.*;
import java.sql.*;


public class PrepStatement {

    private Connection con;
    private PreparedStatement st;
    private Scanner sc;

    PrepStatement() {
        sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///GITM","root","root");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //menu prompt
    int choiceSelector() {
        int choice =0;
        System.out.print("--> What do you want to do : ");
        choice = sc.nextInt();

        return choice;
    }

    //insert Prompt
    int insertPrompt() throws SQLException {
        System.out.print("Enter the number of student you want to add : ");
        int number = sc.nextInt();
        if (number == 0) {
            System.out.println("Oky.. :( ");
            return 0;
        } else {
            for (int i = 1; i<=number; i++) {
                System.out.println("---> Student : "+i);
                insertIntoStudent();
            }
            return 1;
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

    int insertIntoStudent() throws SQLException{
        st = con.prepareStatement("insert into student(id,name,rollno,email) values(?,?,?,?)");

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

    int showStudentPrompt() throws SQLException {
        System.out.print("Enter the roll no of Student : ");
        int rollno = sc.nextInt();
        int ans = showStudent(rollno);

        if (ans == 1) {
            System.out.print("See another (y/n) : ");
            char ans1 = sc.next().trim().charAt(0);
            if (ans1 == 'y' || ans1 == 'Y') {
                showStudentPrompt();
            } else {
                return 1;
            }
        } else {
            System.out.println("<--Please enter the correct roll no-->");
            showStudentPrompt();
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
        }

        return 0;

    }
    // Deleting
    int deletePrompt()throws SQLException {
        System.out.println("---------Delete Student---------");
        System.out.print("Enter the Roll No : ");
        int rollno = sc.nextInt();

    return deleteStudent(rollno);
}

    int deleteStudent(int rollno)throws SQLException {

        int res = showStudent(rollno);
        if (res != 1) {
            System.out.println("Please enter correct RollNo :( ");
            deletePrompt();
        }
        System.out.print("\nAre you sure you want to delete this student details...(y/n) : ");

        char ans = sc.next().trim().charAt(0);
        if (ans == 'y') {
            st = con.prepareStatement("delete from student where rollno = ? ");
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

    void utility(int ans , String message ) {
        if (ans == 1) {
            System.out.println(message);
        } else {
            System.out.println("Seems like we have encountered a problem...");
        }
    }

    public static void main(String[] args) throws Exception {
        PrepStatement myobj = new PrepStatement();
        for (;;) {
        System.out.println("|-_-_-_-_-_-_--< Admin Panel >--_-_-_-_-_-_-_-|");
        System.out.println("|                                             |");
        System.out.println("|       1. Insert Student Details             |");
        System.out.println("|       2. Show Student Details               |");
        System.out.println("|       3. Delete Student Details             |");
        System.out.println("|                                             |");
        System.out.println("|_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_|");

        switch (myobj.choiceSelector()) {
            case 1 -> myobj.utility(myobj.insertPrompt(), "Details Inserted Successfully...");
            case 2 -> myobj.utility(myobj.showStudentPrompt(), "");
            case 3 -> myobj.utility(myobj.deletePrompt(), "Details Deleted Successfully");
            default -> {
                System.out.println("Please enter the correct value...");
            }
            //well that's right
        }

            System.out.print("\nExit or Continue (e/c) : ");
            char exit = myobj.sc.next().trim().charAt(0);
            if (exit == 'e' || exit == 'E') {
                break;
            }

        }

    }
}
