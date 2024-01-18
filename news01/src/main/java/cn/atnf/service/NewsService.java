package cn.atnf.service;

import cn.atnf.daoImpl.NewsNotFoundException;
import cn.atnf.entity.News;
import cn.atnf.entity.PageBean;

import java.util.List;

/**
 * @author Augus
 */
public interface NewsService {

    int addNews(News news);

    List<News> queryAllNews();

    int removeNews(int id);

    News queryOneNews(int id) throws NewsNotFoundException;

    int updateNews(News news);

    int getTotalCount();

    // 声明一个分页查询的方法
    PageBean<News> queryNewsByPage(int currentPage, int pageSize);

}


