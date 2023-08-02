package com.requestdispatcher.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String password = request.getParameter("password");
		
		if(password.equals("admin")) {
			RequestDispatcher rd = request.getRequestDispatcher("Welcome");
			rd.forward(request, response);
		}
		else {
			out.print("<h1 style=\"color: red; text-align: center;\">Worng Username and Password</h1>\r\n"
					+ "<hr style=\"border: 2px solid black;\">");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
	}

}
