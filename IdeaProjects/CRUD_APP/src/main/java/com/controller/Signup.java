package com.controller;

import com.dao.Dao;
import com.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


@WebServlet("/Signup")
public class Signup extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//        The above line is commented because of this forward and sendRedirect method giving "java.lang.IllegalStateException: Cannot call sendRedirect()/forward(req,rap) after the response has been committed"
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession(false);
        String result = (String) session.getAttribute("result");
        String username = (String) session.getAttribute("username");
        /* Cookie code
        String fn = (String) session.getAttribute("firstname");
        String ln = (String) session.getAttribute("lastname");
        Cookie ck1 = new Cookie("fn",fn);
        Cookie ck2 = new Cookie("ln",ln);
        resp.addCookie(ck1);
        resp.addCookie(ck2);
        */
        if (result.equals("yes")) {

            out.print("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "    <link rel=\"shortcut icon\" href=\"asset/icon/password.ico\" type=\"image/x-icon\">\n" +
                    "    <title> Log In</title>\n" +
                    "    <style>\n" +
                    "        @import url('https://fonts.googleapis.com/css2?family=Poppins&display=swap');\n" +
                    "        body{\n" +
                    "            background-color: #9fd4b3;\n" +
                    "            font-family: 'Poppins', sans-serif;\n" +
                    "        }\n" +
                    "        input{\n" +
                    "            outline: none;\n" +
                    "\n" +
                    "        }\n" +
                    "        .outer{\n" +
                    "            display: flex;\n" +
                    "            justify-content: center;\n" +
                    "        }\n" +
                    "        .container{\n" +
                    "            margin-top: 5vh;\n" +
                    "            background-color: white;\n" +
                    "            width: 300px;\n" +
                    "            height: 300px;\n" +
                    "            padding: 0px;\n" +
                    "            border-radius: 5px;\n" +
                    "            box-shadow: 16px 16px 40px rgba(0, 0, 0, 0.38);\n" +
                    "\n" +
                    "        }\n" +
                    "        .label{\n" +
                    "            background-color: #27b42e;\n" +
                    "            color: white;\n" +
                    "            box-sizing: border-box;\n" +
                    "            width: 100%;\n" +
                    "            height: 80px;\n" +
                    "            /* margin-top: 0px; */\n" +
                    "            /* padding-top: auto ;\n" +
                    "            padding-bottom: auto; */\n" +
                    "            display: flex;\n" +
                    "            align-items:center ;\n" +
                    "            padding-left: 30px;\n" +
                    "            font-weight: 900;\n" +
                    "            font-size: 20px;\n" +
                    "            border-top-left-radius: 5px;\n" +
                    "            border-top-right-radius: 5px;\n" +
                    "\n" +
                    "\n" +
                    "        }\n" +
                    "        p{\n" +
                    "            margin: 0px;\n" +
                    "        }\n" +
                    "        .formCon{\n" +
                    "            display: flex;\n" +
                    "            flex-direction: column;\n" +
                    "            align-items: center;\n" +
                    "            margin-top: 15px;\n" +
                    "            /* justify-content: center; */\n" +
                    "        }\n" +
                    "        .inp{\n" +
                    "            width: 220px;\n" +
                    "            height: 37px;\n" +
                    "            margin: 9px;\n" +
                    "            border: 2px solid #d0d4d8;\n" +
                    "            padding-left: 12px;\n" +
                    "            font-size: medium;\n" +
                    "\n" +
                    "        }\n" +
                    "        .inp::placeholder{\n" +
                    "            color: #18232a;\n" +
                    "        }\n" +
                    "        .btn{\n" +
                    "            margin-top: 10px;\n" +
                    "            width: 238px;\n" +
                    "            height: 43px;\n" +
                    "            background-color: #57b279;\n" +
                    "            border: none;\n" +
                    "            color: white;\n" +
                    "            font-size: larger;\n" +
                    "        }\n" +
                    "        .btn:hover{\n" +
                    "            background-color: black;\n" +
                    "        }\n" +
                    "        .inp,.btn{\n" +
                    "            border-radius: 6px;\n" +
                    "        }\n" +
                    "    </style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<div class=\"outer\">\n" +
                    "    <div class=\"container\">\n" +
                    "        <form action=\"Login1\" method=\"post\">\n" +
                    "            <div class=\"label\">\n" +
                    "                <p>LogicMethods</p>\n" +
                    "            </div>\n" +
                    "            <div class=\"formCon\">\n" +
                    "                <input class=\"inp\" type=\"text\" name=\"username\" value="+username.trim()+" placeholder=\"Username\"   required>\n" +
                    "                <input class=\"inp\" type=\"password\" name=\"password\" placeholder=\"Password\"   required>\n" +
                    "                <input class=\"btn \" type=\"submit\" value=\"Log In\" >\n" +
                    "            </div>\n" +
                    "        </form>\n" +
                    "    </div>\n" +
                    "</div>\n" +
                    "</body>\n" +
                    "</html>");

        } else {
            out.print("Something went wrong try again");
        }
    }
}
