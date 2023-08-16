package com.filters;

import com.dao.Dao;
import com.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
@WebFilter(filterName = "SignupFilter",urlPatterns ={"/Signup"})
public class SignupFilter implements Filter {
    User user;
    Dao userDao;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        user = new User();
        userDao = new Dao();
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
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

            HttpSession session=request.getSession();
            session.setAttribute("result","yes");
            session.setAttribute("username",username);
            session.setAttribute("firstname",firstname);
            session.setAttribute("lastname",lastname);
            filterChain.doFilter(request,response);
        } else {
            out.print("Something went wrong try again");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
