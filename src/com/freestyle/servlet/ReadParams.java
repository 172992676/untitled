package com.freestyle.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/ReadParams")
public class ReadParams extends HttpServlet{
    private static final long serialVersionUID = 1L;
    public ReadParams(){
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String title = "读取所有的表单数据";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0"+
                "transitional//en\">\n";
        out.println(docType+
                "<html>\n"+
                "<head><meta charset=\"#f0f0f0\">\n"+
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<table width=\"100%\" border=\"1\" align=\"center\">\n" +
                "<tr bgcolor=\"#949494\">\n" +
                "<th>参数名称</th><th>参数值</th>\n"+
                "</tr>\n"
        );
        Enumeration parameterNames = request.getParameterNames();
        Enumeration headerNames = request.getHeaderNames();

        while(parameterNames.hasMoreElements()){
            String paraName = (String)parameterNames.nextElement();
            out.print("<tr><td>"+paraName+"</td>");
            String[] paramValues = request.getParameterValues(paraName);
            //读取单个数据
            if(paramValues.length==1){
                String paramValue = paramValues[0];
                if(paramValue.length() == 0)
                    out.print("<td>没有数值</td>");
                else{
                    out.print("<td>"+paramValue+"</td>");
                }
            }else{
                //读取多个数值的数据
                out.print("<td><ul>");
                for (int i=0;i<paramValues.length;i++){
                    out.print("<li>"+paramValues[i]+"</li>");
                }
                out.print("</ul></td>");
            }
            out.print("</tr>");
        }

        while(headerNames.hasMoreElements()){
            String headName = (String)headerNames.nextElement();
            out.print("<tr><td>"+headName+"</td>\n");
            String headValue = request.getHeader(headName);
            out.print("<td>"+headValue+"</td></tr>");
        }

        out.print("\n</table>\n</body></html>");
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException{
        doGet(request,response);
        System.out.println("保护 Servlet 的身份验证方案的名称"+request.getAuthType());
        System.out.println("cookies"+request.getCookies());
        System.out.println("属性名称"+request.getAttributeNames());
        System.out.println("所有的头名"+request.getHeaderNames());
        System.out.println("客户端接受内容的首选的区域设置"+request.getLocale());
        System.out.println("请求主体中使用的字符编码名称"+request.getCharacterEncoding());
        System.out.println("请求主体的MIME类型"+request.getContentType());
        System.out.println("请求上下文的请求URL部分"+request.getContextPath());
        System.out.println("请求方法名称"+request.getMethod());
        System.out.println("客户端发送的URL相关的任何额外的路径信息"+request.getPathInfo());
        System.out.println("请求协议的名称和版本"+request.getProtocol());
        System.out.println("包含在路径后的请求 URL 中的查询字符串"+request.getQueryString());
        System.out.println("发送请求的客户端的互联网协议（IP）地址"+request.getRemoteAddr());
        System.out.println("发送请求的客户端的完全限定名称"+request.getRemoteHost());
        System.out.println("用户已通过身份验证，则返回发出请求的登录用户，或者如果用户未" +
                "通过身份验证，则返回 null"+request.getRemoteUser());
        System.out.println("从协议名称直到 HTTP 请求的第一行的查询字符串" +
                "中，返回该请求的 URL 的一部分"+request.getRequestURI());
        System.out.println("由客户端指定的 session 会话 ID"+request.getRequestedSessionId());
        System.out.println("调用 JSP 的请求的 URL 的一部分"+request.getServletPath());
        System.out.println("一个字符串对象的数组，包含所有给定的请求参数的值");
        System.out.println("指示请求是否使用安全通道，如 HTTPS"+request.isSecure());
        System.out.println("以字节为单位返回请求主体的长度，并提供输入流，或者如果长度未知则返回 -1"+
        request.getContentLength());
        //System.out.print("指定的请求头的值为一个 int 值"+request.getIntHeader());
        System.out.println("接收到这个请求的端口号"+request.getServerPort());
        System.out.println("将参数封装成 Map 类型"+request.getParameterMap());
        System.out.println("");
        System.out.println("");
    }
}
