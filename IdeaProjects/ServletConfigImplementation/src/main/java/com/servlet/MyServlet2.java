package com.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class MyServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        ServletConfig config = getServletConfig();
        String name = " ";
        Enumeration<String> e = config.getInitParameterNames();
        while (e.hasMoreElements()) {
            name = e.nextElement();
            out.print("<img src=\"assets/"+config.getInitParameter(name).trim()+".jpg\" alt=\"meme\">");
        }
    }
}
