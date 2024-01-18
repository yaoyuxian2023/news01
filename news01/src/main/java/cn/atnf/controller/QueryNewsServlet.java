package cn.atnf.controller;

import java.io.IOException;

import cn.atnf.daoImpl.NewsNotFoundException;
import cn.atnf.entity.News;
import cn.atnf.service.NewsService;
import cn.atnf.serviceImpl.NewsServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author Augus
 * 查询指定id的新闻信息
 */
@WebServlet("/queryNews")
public class QueryNewsServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、解决编码问题
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //2、接受前台数据
        int id = Integer.parseInt(req.getParameter("id"));
        int flag = Integer.parseInt(req.getParameter("flag"));

        // 3、调用service层，查询指定id的新闻信息
        NewsService ns = new NewsServiceImpl();

        News news = null;
        try {
            news = ns.queryOneNews(id);
        } catch (NewsNotFoundException e) {
            throw new RuntimeException(e);
        }

        // 4、处理结果
        if(news != null) {
            req.setAttribute("news", news);
            if(flag == 1) {
                req.getRequestDispatcher("updateNews.jsp").forward(req, resp);
            }else {
                req.getRequestDispatcher("displayNews.jsp").forward(req, resp);
            }
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(req, resp);
    }

}


