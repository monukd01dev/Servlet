package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CookieDemo")
public class CookieDemo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
//        out.print("Check");

        String username,password;

        username = req.getParameter("username");
        password = req.getParameter("password");

        if (password.equals("admin")) {

            Cookie c = new Cookie("username",username);
            resp.addCookie(c);
//            resp.sendRedirect("Welcome");
            req.getRequestDispatcher("Welcome").forward(req,resp);
        } else {
            out.println("<a href='index.html'><button>Retry</button></a>");
        }

    }
}
