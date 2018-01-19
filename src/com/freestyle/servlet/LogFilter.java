package com.freestyle.servlet;

import java.io.IOException;
import javax.servlet.*;

public class LogFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //获取初始化参数
        String site = filterConfig.getInitParameter("Site");
        //输出初始化参数
        //System.out.println("网络名称："+site);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //输出站点名称
        System.out.println("站点网站：http://www.baidu.com");

        //把请求传回过滤器
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {
        /*
        在Filter实例被Web容器从服务移除之前调用
         */
        System.out.println("在Filter实例被Web容器从服务移除之前调用");
    }
}
