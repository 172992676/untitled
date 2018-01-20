<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>第一个web项目</title>
  </head>
  <body>
    Hello World
      <hr>
  <form action="com.freestyle.servlet.ServletElementPostTest" method="post">
        名称<input type="text" name="name" /><br />
        标识<input type="text" name="runoob" /><br />
        google标识<input type="text" name="google" /><br />
        淘宝标识<input type="text" name="taobao" /><br />
      <input type="submit" value="提交"/>
  </form>
      <hr>
  <form action="ReadParams" method="post" target="_blank">
      <input type="checkbox" name="maths" checked="checked"/>数学
      <input type="checkbox" name="physics" />物理
      <input type="checkbox" name="chemistry"/>化学
      <input type="submit" value="选择学科"/>
  </form>
      <hr>
      <h1>文件上传实例</h1>
    <form method="post" action="/UploadServlet" enctype = "multipart/form-data">
        选择一个文件：
        <input type = "file" name = "uploadFile" />
        <br ／>
        <input type = "submit" value = "上传"/>
    </form>
    <hr/>
  </body>
</html>
