package com.freestyle.servlet;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

@WebServlet("/SendEmail")
public class SendEmail extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,IOException{
        //收件人的电子邮箱 ID
        String to = "278730668@qq.com";
        //发件人的电子邮箱ID
        String from = "172992676@qq.com";

        //假设从本地主机发送电子邮件
        String host = "192.168.1.78";

        //获取系统的属性
        Properties properties = System.getProperties();

        //设置邮件服务器
        properties.setProperty("mail.smtp.host",host);

        //用户身份认证
        properties.setProperty("mail.user", "user");
        properties.setProperty("mail.password", "pwd");

        //获取默认的Session对象
        Session session = Session.getDefaultInstance(properties);
        //设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            //创建一个默认的MimeMessaga 对象
            MimeMessage message = new MimeMessage(session);
            //设置From:header field of the header.
            message.setFrom(new InternetAddress(from));
            //设置TO:header field of the header.
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            //设置Subject:header field
            message.setSubject("This is the Subject Line!");
            //现在设置实际消息
            message.setText("This is actual message");
            //发送消息
            Transport.send(message);
            String title = "发送电子邮件";
            String res = "成功发送消息...";
            String docType = "<!DOCTYPE html>";
            out.println(docType +
                    "<html>\n" +
                    "<head><title>" + title + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" +
                    "<h1 align=\"center\">" + title + "</h1>\n" +
                    "<p align=\"center\">" + res + "</p>\n" +
                    "</body></html>");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
