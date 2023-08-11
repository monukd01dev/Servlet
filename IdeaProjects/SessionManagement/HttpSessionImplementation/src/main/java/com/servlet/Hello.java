package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Hello")
public class Hello extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
//        out.print("hellow");
        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <link rel=\"shortcut icon\" href=\"asset/icon/checked.ico\" type=\"image/x-icon\">\n" +
                "    <title>Hello!</title>\n" +
                "\n" +
                "    <style>\n" +
                "        @import url('https://fonts.googleapis.com/css2?family=Edu+SA+Beginner:wght@500&display=swap');\n" +
                "     .outer{\n" +
                "\n" +
                "       width: 100%;\n" +
                "       height:50%;\n" +
                "       display: flex;\n" +
                "       justify-content: center;\n" +
                "\n" +
                "\n" +
                "     }\n" +
                "     img{\n" +
                "     width : 500px;\n" +
                "     height: auto;\n" +
                "      }\n" +
                "      .buttons{\n" +
                "       /* border: 1px solid black; */\n" +
                "         width: 100%;\n" +
                "         display: flex;\n" +
                "         justify-content: center;\n" +
                "      }\n" +
                "      figcaption{\n" +
                "         position: relative;\n" +
                "         bottom: 230px;\n" +
                "         left: 300px;\n" +
                "         /* font-family: 'Grechen Fuemen', cursive; */\n" +
                "         font-family: 'Edu SA Beginner', cursive;\n" +
                "         text-transform: capitalize;\n" +
                "      }\n" +
                "\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"outer\">\n" +
                "    <figure>\n" +
                "        <img src=\"asset/hello.png\" alt=\"\">\n" +
                "        <figcaption>\n" +
                "            <h1>"+req.getSession().getAttribute("user")+"</h1>\n" +
                "        </figcaption>\n" +
                "    </figure>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>");
    }
}
