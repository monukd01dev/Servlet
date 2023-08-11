package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UrlRewriting")
public class UrlRewriting extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
//        out.print("Check");

        String username,password;

        username = req.getParameter("username");
        password = req.getParameter("password");

        if (password.equals("admin")) {

            req.getRequestDispatcher("Welcome?username="+username).forward(req,resp);
        } else {
            out.println("<a href='index.html'><button>Retry</button></a>");
        }

    }
}
