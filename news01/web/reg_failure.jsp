<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录程序之登录成功页面</title>
</head>
<body>
	<center>
  <h1>注册操作</h1>
  <hr>
  <h2><%=session.getAttribute("info")%>请重新<a href="register.jsp">注册</a></h2>
</center>
</body>
</html>