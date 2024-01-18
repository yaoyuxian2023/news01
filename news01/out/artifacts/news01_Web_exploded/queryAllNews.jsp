<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@page import="java.util.*" %>
<%@page import="cn.atnf.service.NewsService"%>
<%@page import="cn.atnf.serviceImpl.NewsServiceImpl"%>
<%@page import="cn.atnf.entity.News"%>
<%@page import="cn.atnf.entity.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>显示所有新闻</title>
    <script type="text/javascript">
        function del(id) {
            var flag = window.confirm("是否真的要删除？");
            if (flag) {
                window.location.href = "deleteNews?id=" + id;
            }
        }

        function update(id) {
            window.location.href = "queryNews?id=" + id + "&flag=1";
        }

        function query(id) {
            window.location.href = "queryNews?id=" + id + "&flag=0";
        }
    </script>
</head>
<body>
    <% if (session.getAttribute("username") == null) {
    response.sendRedirect("login.jsp");
}%>
<table align="center" border="0" width="750px" cellspacing="0">
    <tr>
        <td align="center" style="font-family:'黑体'; font-size:28px;">登录成功！欢迎[<%=session.getAttribute("username")%>]访问新闻管理系统！</td>
    </tr>
    <tr>
        <td><hr></td>
    </tr>
    <tr style="font-family:'宋体'; font-size:24px;">
        <td align="right"><a href="addNews.jsp"><b>增加新闻</b></a>  <a href="logout">安全退出</a></td>
    </tr>
</table>
<table align="center" border="1" width="750px" cellspacing="0">
    <tr>
        <th width="320px">标题</th>
        <th width="120px">作者</th>
        <!-- <th width="600px">内容</th> -->
        <th width="110px">日期</th>
        <th width="50px">热度</th>
        <th width="150px">操作</th>
    </tr>
    <c:forEach items="${pageBean.list}" var="news"> <!-- 遍历当前页数据 -->
    <tr>
        <td>${news.title}</td>
        <td>${news.author}</td>
        <td>${news.enterdate}</td>
        <td>${news.hot}</td>
        <td>
            <a href="javascript:query(${news.id})">查询详情</a>
            <a href="javascript:update(${news.id})">修改</a>
            <a href="javascript:del(${news.id})">删除</a>

        </td>
    </tr>
    </c:forEach>
    <tr>
        <td colspan="5" align="center">
            <span>第${pageBean.currentPage}/${pageBean.totalPage}页 总记录数：${pageBean.totalSize}条 每页${pageBean.pageSize}条</span>

            <c:if test="${pageBean.currentPage > 1}"> <!-- 如果不是第一页，则可以跳转到首页和上一页 -->
            <a href="/queryAllNews?currentPage=1&pageSize=${pageBean.pageSize}">首页</a>

            <a href="/queryAllNews?currentPage=${pageBean.currentPage - 1}&pageSize=${pageBean.pageSize}">上一页</a>

            </c:if>

            <c:if test="${pageBean.currentPage < pageBean.totalPage}"> <!-- 如果不是最后一页，则可以跳转到下一页和末页 -->
            <a href="/queryAllNews?currentPage=${pageBean.currentPage + 1}&pageSize=${pageBean.pageSize}">下一页</a>

            <a href="/queryAllNews?currentPage=${pageBean.totalPage}&pageSize=${pageBean.pageSize}">末页</a>

            </c:if>

            <form action="/queryAllNews" method="get"> <!-- 添加一个表单来实现跳转到指定页 -->
                <input type="text" name="currentPage" size="2"/> <!-- 输入要跳转的页数 -->
                <input type="hidden" name="pageSize" value="${pageBean.pageSize}"/> <!-- 隐藏域保存每页记录数 -->
                <input type="submit" value="跳转"/> <!-- 提交表单 -->
            </form>

            <form action="/queryAllNews" method="get"> <!-- 添加一个表单来实现跳转到指定页 -->
                <input type="text" name="currentPage" size="2"/> <!-- 输入要跳转的页数 -->
                <input type="hidden" name="pageSize" value="${pageBean.pageSize}"/> <!-- 隐藏域保存每页记录数 -->
                <input type="submit" value="跳转"/> <!-- 提交表单 -->
            </form>
        </td> <!-- 结束单元格 -->
    </tr> <!-- 结束表格行 -->
</table> <!-- 结束表格 -->
