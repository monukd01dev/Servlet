package com.servlet;

import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Employee")
public class Employee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("emp_id"));
		String name = request.getParameter("emp_name");
		String position = request.getParameter("emp_position");
		int decider=0;
		try {
			
		Class.forName("com.mysql.cj.jdbc.Driver");
    	Connection con = DriverManager.getConnection("jdbc:mysql:///employee","root","root");
			
		PreparedStatement stmt = con.prepareStatement("insert into emp_details(emp_id,emp_name,emp_position) values(?,?,?)");
		stmt.setInt(1, id);
		stmt.setString(2, name);
		stmt.setString(3, position);
		decider = stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		if(decider == 1) {
			out.println("<h1 style=\"color:green;text-align:center;\">Registration Successfull</h1>");
		}else {
			out.println("<h1 style=\"color:red;text-align:center;\">Something Went Wrong Try Again</h1>");
		}
	}

}
