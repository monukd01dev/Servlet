package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/HiddenForm")
public class HiddenForm extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Enter</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <form action=\"Welcome\" method=\"post\">\n" +
                "        <input type=\"text\" name=\"username\" value="+ req.getParameter("username")+" hidden>\n" +
                "        <input type=\"submit\" value=\"Enter\">\n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>");
    }
}
