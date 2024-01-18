<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录程序之表单页面</title>
</head>
<body>
	<%
	String id = "";
	String password = "";
	String remenber = null;
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		for(int i=0; i<cookies.length; i++){
			if (cookies[i].getName().equals("Cookie2020")) {
		           //如果cookie对象的名称为Cookie2019
				id = cookies[i].getValue().split("#")[0];  //获取用户名
				password = cookies[i].getValue().split("#")[1];  //获取密码
				remenber = cookies[i].getValue().split("#")[2];  //获取remenber
			}
		}
	}
%>

<center>
  <h1>登录操作</h1>
  <hr>
  <form action="login" method="post">
    <table border="1">
      <tr>
        <td colspan="2">用户登录</td>   
      </tr>
      <tr>
        <td>登录ID：</td>
        <td><input type="text" name="id" value="<%=id %>"></td>
      </tr>
      <tr>
        <td>登录密码：</td>
        <td><input type="password" name="password" value="<%=password %>"></td>
      </tr>
      <tr>
        <td colspan="2">
          &nbsp;&nbsp;<input type="submit" value="登录">&nbsp;&nbsp;
          <input type="reset" value="重置">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <input type="checkbox" name="remenber"  <%if(remenber!=null){%> checked <%}%>>记住我	 
        </td>   
      </tr>
    </table>
  </form>
  <h5>如果您尚未注册，请先进行<a href="register.jsp">&nbsp;注册&nbsp;</a></h5>
</center>
</body>
</html>