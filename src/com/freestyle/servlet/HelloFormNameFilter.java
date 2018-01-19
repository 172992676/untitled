package com.freestyle.servlet;


import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloFormNameFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String name = new String (servletRequest.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
        if("123".equals(name)){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            //设置返回内容
            servletResponse.setContentType("text/html;charset=UTF-8");
            PrintWriter out = servletResponse.getWriter();
            out.println("<b>姓名不正确，请求被拦截，不能访问web资源</b>");
            System.out.println("姓名不正确，请求被拦截，不能访问web资源");
        }
    }

    @Override
    public void destroy() {

    }
}
