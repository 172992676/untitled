package com.freestyle.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletElementPostTest extends HttpServlet {
    public ServletElementPostTest(){

    }

    public void doGet(HttpServletRequest request,HttpServletResponse response)
    throws ServletException,IOException{
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        String title = "使用Post 方法读取表单数据";
        //处理中文
        String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
        String docType = "<!DOCTYPE html> \n";
        out.println(
                docType+
                        "<html>\n"+
                        "<head><title>"+title+"</title>\n"+
                        "<body bgcolor = \"f0f0f0\">\n"+
                        "<h1 align=\"center\">"+title+"</h1>\n"+
                        "<ul>\n"+
                        "  <li><b>姓名</b>：</li>"+ name+
                        "  <li><b>菜鸟按教程标识：</b>: "
                        + request.getParameter("runoob") + "\n" +
                        "  <li><b>Google 标识：</b>: "
                        + request.getParameter("google") + "\n" +
                        "  <li><b>淘宝标识：</b>: "
                        + request.getParameter("taobao") + "\n" +
                        "</ul>\n" +
                        "</body></html>"
        );
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response)
    throws IOException,ServletException{
        doGet(request,response);
    }


}
