package com.controller;

import com.dao.Dao;
import com.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/AdminPanel")
public class AdminPanel extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        int count = 1;
        Dao userdb = new Dao();
        List<User> user = null;
        try {
            user = userdb.getAll();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        out.print("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <link rel=\"shortcut icon\" href=\"asset/icon/admin.ico\" type=\"image/x-icon\">\n" +
                "    <link rel=\"stylesheet\" href=\"style.css\">\n" +
                "    <title>Admin</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <nav class=\"displayFlex\">\n" +
                "        <div class=\"img\"><h2>LogicMethods</h2></div>\n" +
                "        <div class=\"navbtn displayFlex\">\n" +
                "            <div class=\"btnav btnAll\"><a href=\"#\">Add</a></div>\n" +
                "            <div class=\"btnav btnAll\"><a href=\"#\">Logout</a></div>\n" +
                "            <div class=\"btnav btnAll\"><a href=\"#\">About</a></div>\n" +
                "        </div>\n" +
                "    </nav>\n" +
                "    <main>\n" +
                "        <div class=\"outer displayFlex\">");
//        outerdivEnd

        for (User e : user) {

            out.print("<div class=\"details displayFlex border\">\n" +
                    "                <div class=\"id displayFlex\"><span>"+count+"</span></div>\n" +
                    "                <div class=\"name displayFlex\">"+e.getFirstname().trim()+" "+e.getLastname().trim()+"</div>\n" +
                    "                <div class=\"email displayFlex\"><a href=\"#\">"+e.getEmail().trim()+"</a></div>\n" +
                    "                <div class=\"address displayFlex\">"+e.getAddress().trim()+"</div>\n" +
                    "                <div class=\"dualbtn displayFlex\">\n" +
                    "                    <a href=\"\"><button class=\"btnAll btnav Edit\">Edit</button></a>\n" +
                    "                    <a href=\"\"><button class=\"btnAll btnav Delete\">Delete</button></a>\n" +
                    "                </div>\n" +
                    "            </div>");

            count++;
        }

//        3rd part of code
        out.print(" </div>\n" +
                "    </main>\n" +
                "    <footer class=\"displayFlex\">\n" +
                "            <span>By <a href=\"\">monukd01dev</a></span>\n" +
                "    </footer>\n" +
                "</body>\n" +
                "</html>");
    }
}
