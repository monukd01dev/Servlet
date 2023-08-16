package com.filters;

import com.dao.Dao;
import com.model.Userlogin;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
@WebFilter(filterName = "LoginFilter",urlPatterns ={"/Login1"} )
public class LoginFilter implements Filter {
    private Userlogin login;
    private Dao loginDao;
    private boolean validation;
    void setValidation(boolean validation) {
        this.validation = validation;
    }
    boolean isValidation() {
        return validation;
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        login = new Userlogin();
        loginDao = new Dao();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String fullname;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String username = servletRequest.getParameter("username");
        String password = servletRequest.getParameter("password");

        login.setUsername(username);
        login.setPassword(password);


        try {
            setValidation(loginDao.login(login));

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        if (isValidation()) {
            if (username.equals("monukd")) {
                response.sendRedirect("AdminPanel");
            } else {
                try {
                    fullname = loginDao.getFullName(username);
                    HttpSession session = request.getSession();
                    session.setAttribute("fullname",fullname);
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }

                filterChain.doFilter(servletRequest,servletResponse);
            }
        } else {
//            out.print("seems like you haven't signedup yet!");
            servletRequest.getRequestDispatcher("loginError.html").forward(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
