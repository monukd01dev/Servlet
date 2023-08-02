package com.registration.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.registration.dao.EmployeeDao;
import com.registration.model.Employee;

@WebServlet("/EmployeeLServlet")
public class EmployeeLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmployeeDao empDao; 
    private Employee emp;
    
    public EmployeeLServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		empDao = new EmployeeDao();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int result =0;
		
		//extracting data from form
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		
		
		//setting value into the Employee
		emp = new Employee();
		
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setUsername(username);
		emp.setPassword(password);
		emp.setAddress(address);
		emp.setContact(contact);
		
		//invoking registerEmployee method of EmployeeDao class
		try {
			
			result = empDao.registerEmployee(emp);
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		//condition for output
		
		if(result == 1) {
			out.println("<h1 style=\"color:green;text-align:center;\">Registration Successfull</h1>");
		}else {
			out.println("<h1 style=\"color:red;text-align:center;\">Something Went Wrong Try Again</h1>");
		}
		
		
	}

}
