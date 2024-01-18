package cn.atnf.controller;

import java.io.IOException;

import cn.atnf.service.NewsService;
import cn.atnf.serviceImpl.NewsServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author Augus
 * 删除新闻
 */
@WebServlet("/deleteNews")
public class DeleteNewsServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、解决编码问题
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 2、获取前台传过来的id
        int id = Integer.parseInt(req.getParameter("id"));
        // 3、调用Service层
        NewsService ns = new NewsServiceImpl();
        int n = ns.removeNews(id);
        // 4、处理结果
        if(n>0) {
            //删除成功，则直接刷新页面
            resp.sendRedirect("queryAllNews");
        }else {
            resp.getWriter().println("fail to delete！删除失败！");
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(req, resp);
    }

}


