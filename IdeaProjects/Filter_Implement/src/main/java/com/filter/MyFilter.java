package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "MyFilter",urlPatterns ={"/MyServlet"})
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();

        String username = servletRequest.getParameter("username");
        String password = servletRequest.getParameter("password");

        if (password.equals("admin")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            servletRequest.getRequestDispatcher("error.html").forward(servletRequest,servletResponse);
//            out.print("<h2 style='margin:0px;color:red;text-align:center;'>UserNotfound</h2>");
//            servletRequest.getRequestDispatcher("login.html").include(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
