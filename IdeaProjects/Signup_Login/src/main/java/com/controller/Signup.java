package com.controller;

import com.dao.Dao;
import com.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


@WebServlet("/Signup")
public class Signup extends HttpServlet {
    User user;
    Dao userDao;
    @Override
    public void init() throws ServletException {
        super.init();
        user = new User();
        userDao = new Dao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//        The above line is commented because of this forward and sendRedirect method giving "java.lang.IllegalStateException: Cannot call sendRedirect()/forward(req,rap) after the response has been committed"
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        int result = 0;

        //getting data from form
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String address = req.getParameter("address");
        String email = req.getParameter("email");

        //setting data into user
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setUsername(username);
        user.setPassword(password);
        user.setAddress(address);
        user.setEmail(email);

        //calling dao class method
        try {
           result = userDao.register(user);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        if (result == 1) {

//            RequestDispatcher dispatcher = req.getRequestDispatcher("View/LogIn.html");
//            dispatcher.forward(req,resp);
            resp.sendRedirect("LogIn.html");

        } else {
            out.print("Something went wrong try again");
        }
    }
}
