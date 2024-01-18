<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录程序之登注册成功页面</title>
</head>
<body>
	<h2>[<%=session.getAttribute("info")%>]恭喜您--注册成功！</h2>
    
    <h4>5秒后自动跳转到登录页面</h4>
<%
	response.setHeader("refresh", "5;login.jsp");
%>    
</body>
</html>