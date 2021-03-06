package com.freestyle.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import static java.util.jar.Pack200.Packer.PASS;

@WebServlet("/DatabaseAccess")
public class DatabaseAccess extends HttpServlet {
    private static final long serialVersionUID = 1L;
    //JDBC驱动名及数据库URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String JDBC_URL = "jdbc:mysql://192.168.1.254:3306/test1";
    //com.mysql.jdbc.Driver
    //jdbc:mysql://192.168.1.254:3306/test1

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
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n");
        try{
            // 注册 JDBC 驱动器
            Class.forName(JDBC_DRIVER);

            // 打开一个连接
            conn = DriverManager.getConnection(JDBC_URL,USER,PWD);

            // 执行 SQL 查询
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, t_name, age,price FROM animals";
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String t_name = rs.getString("t_name");
                int age = rs.getInt("age");
                double price = rs.getDouble("price");

                // 输出数据
                out.println("ID: " + id);
                out.println(", 名字: " + t_name);
                out.println(", 年龄: " + age);
                out.println(", 价钱: " + price);
                out.println("<br />");
            }
            out.println("</body></html>");

            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch(Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 最后是用于关闭资源的块
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }

    }
}
