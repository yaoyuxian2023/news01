<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新闻管理系统之用户注册页面</title>
</head>
<body>
	<center>
  <h1>注册操作</h1>
  <hr>
  <form action="register" method="post">
    <table border="1">
      <tr>
        <td colspan="2" align="center">用户注册</td>   
      </tr>
      <tr>
        <td align="right">登录ID：</td>
        <td><input type="text" name="uid"></td>
      </tr>
      <tr>
        <td align="right">真实姓名：</td>
        <td><input type="text" name="uname"></td>
      </tr>      
	  <tr>
		<td align="right">性&nbsp;&nbsp;&nbsp;别：</td>
		<td>
			<input type="radio" name="usex" value="男">男
			<input type="radio" name="usex" value="女">女
		</td>
	  </tr>
	  <tr>
        <td align="right">E-Mail：</td>
        <td><input type="text" name="uemail"></td>
      </tr>      <tr>
        <td align="right">登录密码：</td>
        <td><input type="password" name="upassword"></td>
      </tr>
      <tr>
        <td align="right">确认密码：</td>
        <td><input type="password" name="upassword2"></td>
      </tr>
      <tr>
        <td colspan="2">
          &nbsp;&nbsp;<input type="submit" value="注册">&nbsp;&nbsp;
          <input type="reset" value="重置"> 
        </td>   
      </tr>
    </table>
  </form>
  <h5><a href="login.jsp">&nbsp;返回登录页面&nbsp;</a></h5>
  
</center>
</body>
</html>