package com.freestyle.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/CurrentDate")
public class CurrentDate extends HttpServlet {
    public CurrentDate(){}
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String title = "显示当前的日期和时间";
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd");
        String docType = "<!DOCTYPE html> \n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<h2 align=\"center\">" + ft.format(date) + "</h2>\n" +
                "</body></html>");
    }
}
