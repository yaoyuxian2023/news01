package cn.atnf.entity;

import java.util.Date;

/**
 * @author Augus
 */
public class News {
    private static int id;
    private String title;
    private String author;
    private String content;
    private Date enterdate;
    private int hot;
    public News(int id, String title, String author, String content, Date enterdate, int hot) {
        super();
        News.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.enterdate = enterdate;
        this.hot = hot;
    }
    public static int getId() {
        return id;
    }
    public void setId(int id) {
        News.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Date getEnterdate() {
        return enterdate;
    }
    public void setEnterdate(Date enterdate) {
        this.enterdate = enterdate;
    }
    public int getHot() {
        return hot;
    }
    public void setHot(int hot) {
        this.hot = hot;
    }
    @Override
    public String toString() {
        return "News [id=" + id + ", title=" + title + ", author=" + author + ", content=" + content + ", enterdate="
                + enterdate + ", hot=" + hot + "]";
    }

}

