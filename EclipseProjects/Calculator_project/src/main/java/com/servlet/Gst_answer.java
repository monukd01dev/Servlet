package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Gst_answer extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		double amount = Double.parseDouble(req.getParameter("amount"));
		double rate = Double.parseDouble(req.getParameter("rate"));
		String tax = req.getParameter("tax");
		
		//inclusive
//		GST Amount = (Original Cost * GST Rate) / 100
//		Inclusive Price = Original Cost + GST Amount
		
//		exclusive
//		GST Amount = Inclusive Price * GST Rate / (100 + GST Rate)
//		Exclusive Price = Inclusive Price - GST Amount
		
		double gst_amount = (amount * rate)/100.0;
		double inclusive_price = amount+gst_amount;
		double answer;
		
		if(tax.equals("ex")) {
			gst_amount = (inclusive_price*rate)/(100.0+rate);
			double exclusive_price = inclusive_price-gst_amount;
			answer = exclusive_price;
		}else {
			answer = inclusive_price;
		}
		
//		out.println("<html><body><h1>"+amount+"	"+tax+""+rate+"GST AMount"+gst_amount+"		Your GST Inclusive : "+inclusive_price+"</h1></body></html>");
		
		out.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>GST result</title>\r\n"
				+ "    <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n"
				+ "<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n"
				+ "<link href=\"https://fonts.googleapis.com/css2?family=Poppins:wght@100;300&display=swap\" rel=\"stylesheet\">\r\n"
				+ "    <style>\r\n"
				+ "        body{\r\n"
				+ "            background-color: black;\r\n"
				+ "            /* color: white; */\r\n"
				+ "            text-align: center;\r\n"
				+ "            font-family: 'Poppins', sans-serif;\r\n"
				+ "            \r\n"
				+ "\r\n"
				+ "        }\r\n"
				+ "        .outer {\r\n"
				+ "            display: flex;\r\n"
				+ "            justify-content: center;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        .resutl_con {\r\n"
				+ "            margin-top: 100px;\r\n"
				+ "            width: auto;\r\n"
				+ "            display: flex;\r\n"
				+ "            flex-direction: column;\r\n"
				+ "            /* justify-content: center; */\r\n"
				+ "            align-items: center;\r\n"
				+ "            background-color: aquamarine;\r\n"
				+ "            /* width: 500px;\r\n"
				+ "            height: 600px; */\r\n"
				+ "            border: 1px solid black;\r\n"
				+ "            border-radius: 20px;\r\n"
				+ "            padding-bottom: 15px;\r\n"
				+ "        }\r\n"
				+ "        .num{\r\n"
				+ "            display: flex;\r\n"
				+ "            background-color: rgb(255, 255, 255);\r\n"
				+ "            border: px solid black;\r\n"
				+ "            margin: 10px 40px;\r\n"
				+ "            padding: 10px 35px;\r\n"
				+ "            border-radius: 25px;\r\n"
				+ "            width: 300px;\r\n"
				+ "            font-size: 20px;\r\n"
				+ "            /* justify-content: space-around; */\r\n"
				+ "            justify-content: space-between;\r\n"
				+ "        }\r\n"
				+ "        .btn{\r\n"
				+ "            width: 120px;\r\n"
				+ "            margin: 15px auto;\r\n"
				+ "            padding: 15px 25px;\r\n"
				+ "            border-radius: 15px;\r\n"
				+ "            border: none;\r\n"
				+ "            background-color: red;\r\n"
				+ "            \r\n"
				+ "        }\r\n"
				+ "        a{\r\n"
				+ "            text-decoration: none;\r\n"
				+ "            color: white;\r\n"
				+ "            font-size: 15px;\r\n"
				+ "            font-weight: bold;\r\n"
				+ "        }\r\n"
				+ "        .key{\r\n"
				+ "            font-weight: bold;\r\n"
				+ "        }\r\n"
				+ "    </style>\r\n"
				+ "</head>\r\n"
				+ "\r\n"
				+ "<body>\r\n"
				+ "    <div class=\"outer\">\r\n"
				+ "        <div class=\"resutl_con\">\r\n"
				+ "            <h1>YOUR GST</h1>\r\n"
				+ "\r\n"
				+ "            <div class=\"num\">\r\n"
				+ "                <span class=\"key\">Actual Amount</span>\r\n"
				+ "                <span class=\"value\">"+amount+"</span>\r\n"
				+ "            </div>\r\n"
				+ "\r\n"
				+ "            <div class=\"num\">\r\n"
				+ "                <span class=\"key\">GST Amount</span>\r\n"
				+ "                <span class=\"value\">"+gst_amount+"</span>\r\n"
				+ "            </div>\r\n"
				+ "\r\n"
				+ "            <div class=\"num\">\r\n"
				+ "                <span class=\"key\">Total Amount</span>\r\n"
				+ "                <span class=\"value\">"+answer+"</span>\r\n"
				+ "            </div>\r\n"
				+ "\r\n"
				+ "            <button class=\"btn\">\r\n"
				+ "                <a href=\"gstcal.html\">BACK</a>\r\n"
				+ "            </button>\r\n"
				+ "\r\n"
				+ "        </div>\r\n"
				+ "    </div>\r\n"
				+ "</body>\r\n"
				+ "\r\n"
				+ "</html>");
	}

}
