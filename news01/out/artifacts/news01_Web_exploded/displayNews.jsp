<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.sql.*"%>
<%@page import="cn.atnf.entity.News"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查询新闻详情</title>
</head>
<body>
<% 
	News news = (News)request.getAttribute("news");

	if(news != null){
%>
		<table align="center">
		<tr>
			<td>新闻题目</td>
			<td><input type="text" readonly="readonly"  value="<%=news.getTitle() %>"></td>
		</tr>
		<tr>
			<td>新闻作者</td>
			<td><input type="text" readonly="readonly"  value="<%=news.getAuthor() %>"></td>
		</tr>
		<tr>
		<td>新闻内容</td>
		<td><textarea rows="5" cols="70" readonly="readonly"><%=news.getContent() %></textarea> </td>
		</tr>
		<tr>
			<td>新闻日期</td>
			<td><input type="date" readonly="readonly"  value="<%=news.getEnterdate() %>"></td>
		</tr>
		<tr>
			<td>新闻热度</td>
			<td><input type="number" readonly="readonly" value="<%=news.getHot() %>"></td>
		</tr>
	</table>
<%
	}
%>
<br>
<center>
	<a href="queryAllNews">返回</a>
</center>
</body>
</html>