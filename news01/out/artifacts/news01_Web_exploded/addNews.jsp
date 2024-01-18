<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>增加新闻</title>
</head>
<body>
		<form action="addNews" method="post">
		<table align="center">
			<tr>
				<td>新闻题目</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>新闻作者</td>
				<td><input type="text" name="author"></td>
			</tr>
			<tr>
				<td>新闻内容</td>
				<td><textarea rows="5" cols="70" name="content"></textarea> </td>
			</tr>
			<tr>
				<td>新闻日期</td>
				<td><input type="date" name="enterdate"></td>
			</tr>
			<tr>
				<td>新闻热度</td>
				<td><input type="number" name="hot"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="添加">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>