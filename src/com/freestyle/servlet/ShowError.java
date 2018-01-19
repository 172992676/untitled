package com.freestyle.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showError")
public class ShowError extends HttpServlet {
    public void doGet(HttpServletRequest requeest, HttpServletResponse response)
        throws ServletException,IOException {
        response.sendError(407,"Need authenticationo!!!");
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException{
        doGet(request,response);
    }
}
