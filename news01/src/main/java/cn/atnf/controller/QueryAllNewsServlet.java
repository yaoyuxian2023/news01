package cn.atnf.controller;

import java.io.IOException;

import cn.atnf.entity.News;
import cn.atnf.entity.PageBean;
import cn.atnf.service.NewsService;
import cn.atnf.serviceImpl.NewsServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author Augus
 * 查询所有新闻
 */
@WebServlet("/queryAllNews")
public class QueryAllNewsServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

		// 1、调用service层，查询新闻
		NewsService ns = new NewsServiceImpl();
		int currentPage = 1; // 默认为第一页
		int pageSize = 10; // 默认每页显示10条
		String currentPageStr = req.getParameter("currentPage"); // 获取请求参数中的当前页数
		if (currentPageStr != null && !"".equals(currentPageStr)) { // 如果不为空，则转换为整数
			currentPage = Integer.parseInt(currentPageStr);
		}
		String pageSizeStr = req.getParameter("pageSize"); // 获取请求参数中的每页记录数
		if (pageSizeStr != null && !"".equals(pageSizeStr)) { // 如果不为空，则转换为整数
			pageSize = Integer.parseInt(pageSizeStr);
		}
		PageBean<News> pageBean = ns.queryNewsByPage(currentPage, pageSize); // 调用service层的方法获取PageBean对象
		// 2、处理结果
		req.setAttribute("pageBean", pageBean); // 将PageBean对象存入request域中
		req.getRequestDispatcher("queryAllNews.jsp").forward(req, resp); // 转发到JSP页面显示数据
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}


