package com.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletContextDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        ServletContext context = getServletContext();
        String value = context.getInitParameter("uncanny");
        out.print("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Document</title>\n" +
                "    <style>\n" +
                "        body{\n" +
                "        display: flex;           /* establish flex container */\n" +
                "        flex-direction: column;  /* make main axis vertical */\n" +
                "        justify-content: center; /* center items vertically, in this case */\n" +
                "        align-items: center;\n" +
                "        height:100vh;\n" +
                "        overflow:hidden;\n" +
                "        background-color: black;\n" +
                "        }\n" +
                "        figcaption{\n" +
                "            color: white;\n" +
                "            text-align: center;\n" +
                "            position: relative;\n" +
                "            bottom: 160px;\n" +
                "            font-size: 22px; background-color:black;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <figure>\n" +
                "        <video src=\"assets/"+value.trim()+"\" autoplay loop controls ></video>\n" +
                "        <figcaption><h1>"+context.getInitParameter("message").trim()+"</h1></figcaption>\n" +
                "    </figure>\n" +
                "</body>\n" +
                "</html>");
    }
}
