package cn.atnf.daoImpl;

import cn.atnf.dao.NewsDao;
import cn.atnf.entity.News;
import cn.atnf.entity.PageBean;
import cn.atnf.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Augus
 */
public class NewsDaoImpl implements NewsDao {

@Override
public int insertOne(News news) {
    if (news == null) {
        throw new IllegalArgumentException("News cannot be null");
    }
    String sql = "insert into t_news values(?,?,?,?,?,?)";
    Object[] objs = {News.getId(), news.getTitle(), news.getAuthor(), news.getContent(), news.getEnterdate(), news.getHot()};
    int n;
    n = DBUtil.executeDML(sql, objs);
    return n;
}


@Override
public List<News> selectAll() {
    String sql = "select * from t_news";
    try (Connection conn = DBUtil.getConnection();
         PreparedStatement ps = DBUtil.getPreparedStatement(conn, sql);
         ResultSet rs = ps.executeQuery()) {
        List<News> list = new ArrayList<>();
        while (rs.next()) {
            News news = new News(rs.getInt("id"), rs.getString("title"),
                    rs.getString("author"), rs.getString("content"),
                    rs.getDate("enterdate"), rs.getInt("hot"));
            list.add(news);
        }
        return list;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return Collections.emptyList();
}


 @Override
public int deleteOne(int id) {
    String sql = "delete from t_news where id=?";
    Object[] objs = {id};
    int n = 0;
    try {
        Connection connection = null;
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, id);
        n = pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return n;
}

    @Override
    public News selectOne(int id) throws NewsNotFoundException {
        String sql = "select * from t_news where id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = DBUtil.getPreparedStatement(conn, sql);
             ResultSet rs = ps.executeQuery()) {
            ps.setInt(1, id);
            if(rs.next()) {
                return new News(rs.getInt("id"), rs.getString("title"),
                        rs.getString("author"), rs.getString("content"),
                        rs.getDate("enterdate"), rs.getInt("hot"));
            } else {
                throw new NewsNotFoundException("News with id " + id + " not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Database error", e);
        }
    }
        
    @Override
    public int updateOne(News news) {
        String sql = "update t_news set title=?,author=?,content=?,enterdate=?,hot=? where id=?";
        Object[] objs = {news.getTitle(), news.getAuthor(), news.getContent(),
                news.getEnterdate(), news.getHot(), News.getId()};
        int n = DBUtil.excuteDML(sql, objs);
        return n;
    }

    public PageBean<News> queryNewsByPage(int currentPage, int pageSize) {
        // 创建一个PageBean对象
        PageBean<News> pageBean = new PageBean<News>();
        // 设置当前页数和每页记录数
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        // 调用dao层的方法获取总记录数
        int totalSize = NewsDao.getTotalSize();
        // 设置总记录数
        pageBean.setTotalSize(totalSize);
        // 计算总页数
        int totalPage = (totalSize % pageSize == 0) ? (totalSize / pageSize) : (totalSize / pageSize + 1);
        // 设置总页数
        pageBean.setTotalPage(totalPage);
        // 计算开始索引
        int startIndex = (currentPage - 1) * pageSize;
        // 调用dao层的方法获取当前页数据
        List<News> list = NewsDao.queryNewsByPage(startIndex, pageSize);
        // 设置当前页数据
        pageBean.setList(list);
        // 返回PageBean对象
        return pageBean;


    }


}


