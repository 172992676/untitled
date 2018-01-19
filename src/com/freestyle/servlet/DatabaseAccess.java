package com.freestyle.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

public class DatabaseAccess extends HttpServlet {
    private static final long serialVersionUID = 1L;
    //JDBC驱动名及数据库URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String JDBC_URL = "jdbc:mysql://192.168.1.254:3306/test1";

    //数据库的用户名和密码，需要根据自己的设置
    static final String USER = "sa";
    static final String PWD = "123";

    public DatabaseAccess(){

    }

    public void doGet(HttpServletRequest request , HttpServletResponse response)
        throws ServletException,IOException{
        Connection conn = null;
        Statement stmt = null;

        //设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        String title = "Servlet Mysql 测试教程";
        String docType = "<!DOCTYPE html>";

    }
}
