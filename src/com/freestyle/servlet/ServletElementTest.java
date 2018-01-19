package com.freestyle.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletElementTest extends HttpServlet{
    private String message;
    public void init() throws ServletException{
        //执行必须的初始化
        message = "Hello World";
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException,IOException
    {
        //设置响应内容类型
        response.setContentType("text/html");

        //实际的逻辑
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
    }

    public void destory(){
        //什么也不做
    }

}
