package com.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.registration.model.Employee;

public class EmployeeDao {
	public int registerEmployee(Employee emp) throws Exception
	{
		String query = "insert into employee(first_name,last_name,username,password,address,contact) values(?,?,?,?,?,?)";
		
		int result =0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Try with resources
		try(
				Connection con = DriverManager.getConnection("jdbc:mysql:///registration","root","root");
				PreparedStatement stmt = con.prepareStatement(query);
			)
		{
			
			stmt.setString(1, emp.getFirstName());
			stmt.setString(2, emp.getLastName());
			stmt.setString(3, emp.getUsername());
			stmt.setString(4, emp.getPassword());
			stmt.setString(5, emp.getAddress());
			stmt.setString(6, emp.getContact());
			
			result = stmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
}
