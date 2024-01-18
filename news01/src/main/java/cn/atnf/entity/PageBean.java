package cn.atnf.entity;

import java.util.List;

/**
 * @author Augus
 */
public class PageBean<T> {
    private Integer currentPage; // 当前页数
    private Integer totalPage; // 总页数
    private Integer totalSize; // 总记录数
    private Integer pageSize; // 每页记录数
    private List<T> list; // 当前页数据

    // 构造方法，根据总记录数、当前页数和每页记录数计算总页数
    public PageBean() {
        this.totalSize = totalSize;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalPage = (totalSize % pageSize == 0) ? (totalSize / pageSize) : (totalSize / pageSize + 1);
    }

    // getter和setter方法
    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}

