package com.freestyle.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class HelloForm extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloForm(){
        super();
    }

    protected void doGet (HttpServletRequest request ,
                          HttpServletResponse response)
        throws SecurityException , IOException{
        //设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        String title = "使用 GET方法读取表单数据";

        //处理中文
        String name = new String(request.getParameter("name").getBytes("ISO8859-1"),
                "UTF-8");
        System.out.println(Arrays.toString(request.getParameter("name").getBytes("ISO8859-1")));
        System.out.println(Arrays.toString(request.getParameter("name").getBytes("utf-8")));
        String docType = "<!DOCTYPE html> \n";
        out.println(
                docType +
                        "<html>\n"+
                        "<head><tittle>"+title+"</tittle></head>\n"+
                        "<body bgcolor=\"#f0f0f0\">\n"+
                        "<h1 align=\"center\">"+title+"</h1>\n"+
                        "<ul>\n"+
                        "   <li><b>站点名称</b></li>"+
                        name + "\n"+
                        "   <li><b>网址</b></li>"+
                        request.getParameter("url")+"\n"+
                        "</ul>\n"+
                        "</body></html>"
        );
    }
}
