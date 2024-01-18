package cn.atnf.dao;

import cn.atnf.daoImpl.NewsNotFoundException;
import cn.atnf.entity.News;

import java.util.List;

/**
 * @author Augus
 */
public interface NewsDao {

    static int getTotalSize() {
        return 0;
    }

    static List<News> queryNewsByPage(int startIndex, int pageSize) {
        return null;
    }

    int insertOne(News news);

    List<News> selectAll();

    int deleteOne(int id);

    News selectOne(int id) throws NewsNotFoundException;

    int updateOne(News news);

}


