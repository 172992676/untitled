package com.freestyle.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/PageRedirect")
public class PageRedirect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        //要重定向的新位置
        String site = new String("https://www.baidu.com");

        resp.setStatus(resp.SC_MOVED_TEMPORARILY);
        resp.setHeader("Location",site);
    }
}
