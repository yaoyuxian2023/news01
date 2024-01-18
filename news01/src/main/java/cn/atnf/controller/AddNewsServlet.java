package cn.atnf.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * 新增新闻
 */
@WebServlet("/addNews")
public class AddNewsServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、解决编码问题
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //2、接受前台数据，并将前台数据封装成一个News对象
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String content = req.getParameter("content");
        String date_str = req.getParameter("enterdate");
        String hot_str = req.getParameter("hot");
        // String-->Util.Date
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        int hot;
        News news = null;
        try {
            date = df.parse(date_str);
            hot = Integer.parseInt(hot_str);
            news = new News(0, title, author, content, date, hot);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // 3、调用service层，然后传入news
        NewsService ns = new NewsServiceImpl();

        int n = ns.addNews(news);

        // 4、处理结果
        if(n >0) {
            //插入成功
            resp.sendRedirect("queryAllNews");
        }else {
            // 插入失败
            req.getRequestDispatcher("addNews.jsp").forward(req, resp);

        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(req, resp);
    }

}


