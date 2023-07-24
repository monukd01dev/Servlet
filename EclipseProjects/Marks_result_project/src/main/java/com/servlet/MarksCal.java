package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MarksCal
 */
//@WebServlet("/MarksCal")
public class MarksCal extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MarksCal() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Result</title>\r\n"
				+ "    <style>\r\n"
				+ "        .outer{\r\n"
				+ "            padding-top: 5vh;\r\n"
				+ "            display: flex;\r\n"
				+ "            justify-content: center;\r\n"
				+ "        }\r\n"
				+ "        .container{\r\n"
				+ "            width: 23.5rem;\r\n"
				+ "            border: 1px solid red;\r\n"
				+ "            padding: 10px;\r\n"
				+ "        }\r\n"
				+ "        .detail{\r\n"
				+ "            /* border: 1px solid red; */\r\n"
				+ "            /* border: 1px solid blue; */\r\n"
				+ "            height: 11.6em;\r\n"
				+ "            width: auto;\r\n"
				+ "            display: flex;\r\n"
				+ "            justify-content: space-between;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        img{\r\n"
				+ "            height: 2em;\r\n"
				+ "            width: 2em;\r\n"
				+ "            /* border-radius: 100px; */\r\n"
				+ "        }\r\n"
				+ "        .profile{\r\n"
				+ "            height: 10rem;\r\n"
				+ "            width: 10rem;\r\n"
				+ "            margin-top: auto;\r\n"
				+ "            margin-bottom: auto;\r\n"
				+ "            border-radius: 100px;\r\n"
				+ "        }\r\n"
				+ "        .img{\r\n"
				+ "            height: 100%;\r\n"
				+ "            width: auto;\r\n"
				+ "            border: 1px solid red;\r\n"
				+ "            position: relative;\r\n"
				+ "            display: flex;\r\n"
				+ "            justify-content: center;\r\n"
				+ "            align-items: center;\r\n"
				+ "        }\r\n"
				+ "        .marks{\r\n"
				+ "            border: 1px solid greenyellow;\r\n"
				+ "        }\r\n"
				+ "        table{\r\n"
				+ "            width: 100%;\r\n"
				+ "            border: 1px solid black;\r\n"
				+ "        }\r\n"
				+ "        .info{\r\n"
				+ "            text-align: left;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        /* text sizing */\r\n"
				+ "        h1{\r\n"
				+ "            font-size: 2rem;\r\n"
				+ "            margin-bottom: 0.05rem;\r\n"
				+ "        }\r\n"
				+ "        \r\n"
				+ "        .info>h3{\r\n"
				+ "            margin-top: 0;\r\n"
				+ "            font-size: 0.9em ;\r\n"
				+ "            font-style: italic ;\r\n"
				+ "            text-decoration: underline;\r\n"
				+ "            text-transform: capitalize;\r\n"
				+ "        }\r\n"
				+ "        .links{\r\n"
				+ "            /* border: 1px solid red; */\r\n"
				+ "            display: flex;\r\n"
				+ "            justify-content: space-evenly;\r\n"
				+ "            align-items: center;\r\n"
				+ "            margin-top: 1.8em;\r\n"
				+ "            margin-bottom: 1.8em;\r\n"
				+ "            margin-right: 2em;\r\n"
				+ "        }\r\n"
				+ "    </style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <div class=\"outer\">\r\n"
				+ "        <div class=\"container\">\r\n"
				+ "            <div class=\"detail\">\r\n"
				+ "                <div class=\"img\">\r\n"
				+ "                    <img src=\"profile_img.jpeg\" class=\"profile\" alt=\"\">\r\n"
				+ "                </div>\r\n"
				+ "                <div class=\"info\">\r\n"
				+ "                    <h1>Monu Kumar</h1>\r\n"
				+ "                    <h3>learning java fullstack</h3>\r\n"
				+ "                    <div class=\"links\">\r\n"
				+ "                        <a href=\"#\" title=\"Follow me on Twitter\"><img src=\"https://www.freeiconspng.com/uploads/logo-twitter-circle-png-transparent-image-1.png\" width=\"350\" alt=\"Logo Twitter Circle PNG Transparent Image\" /></a>\r\n"
				+ "                        <a href=\"#\" title=\"Follow me on Github\"><img src=\"https://www.freeiconspng.com/uploads/github-logo-icon-32.jpg\" width=\"350\" alt=\"Transparent Github Logo Icon\" /></a>\r\n"
				+ "                        <a href=\"#\" title=\"Follow me on LinkedIn\"><img src=\"https://www.freeiconspng.com/uploads/linkedin-logo-3.png\" width=\"350\" alt=\"Linkedin Logo Png Available In Different Size\" /></a>\r\n"
				+ "                    </div>\r\n"
				+ "                    \r\n"
				+ "                </div>\r\n"
				+ "            </div>\r\n"
				+ "            <div class=\"marks\">\r\n"
				+ "                <h2>Result </h2>\r\n"
				+ "                <table>\r\n"
				+ "                    <tr>\r\n"
				+ "                        <th>Math</th>\r\n"
				+ "                        <td>50</td>\r\n"
				+ "                    </tr>\r\n"
				+ "                    <tr>\r\n"
				+ "                        <th>Science</th>\r\n"
				+ "                        <td>80</td>\r\n"
				+ "                    </tr>\r\n"
				+ "                    <tr>\r\n"
				+ "                        <th>Hindi</th>\r\n"
				+ "                        <td>94</td>\r\n"
				+ "                    </tr>\r\n"
				+ "                </table>\r\n"
				+ "            </div>\r\n"
				+ "        </div>\r\n"
				+ "    </div>\r\n"
				+ "</body>\r\n"
				+ "</html>");
	}

}
