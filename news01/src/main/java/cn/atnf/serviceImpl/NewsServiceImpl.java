package cn.atnf.serviceImpl;

import cn.atnf.dao.NewsDao;
import cn.atnf.daoImpl.NewsDaoImpl;
import cn.atnf.daoImpl.NewsNotFoundException;
import cn.atnf.entity.News;
import cn.atnf.entity.PageBean;
import cn.atnf.service.NewsService;

import java.util.List;

public class NewsServiceImpl implements NewsService {
    private NewsDao nd = new NewsDaoImpl();
    @SuppressWarnings("unused")
	private NewsServiceImpl newsDao;

    @Override
    public int addNews(News news) {

        return nd.insertOne(news);
    }
    @Override
    public List<News> queryAllNews() {

        return nd.selectAll();
    }
    @Override
    public int removeNews(int id) {

        return nd.deleteOne(id);
    }
    @Override
    public News queryOneNews(int id) throws NewsNotFoundException {

        return nd.selectOne(id);
    }
    @Override
    public int updateNews(News news) {

        return nd.updateOne(news);
    }

    @Override
    public int getTotalCount() {
        return 0;
    }

    @Override
    public PageBean<News> queryNewsByPage(int currentPage, int pageSize) {
        return null;
    }

    public void setNewsDao(NewsDao newsDao) {
        this.newsDao = (NewsServiceImpl) newsDao;

    }
}


