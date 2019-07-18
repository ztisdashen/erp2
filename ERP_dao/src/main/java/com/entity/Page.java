package com.entity;

import java.util.List;

/**
 * @program: CRM6
 * @description:
 * @author: zt648
 * @create: 2019-07-06 15:49
 **/
public class Page<T> {
    private Integer currentPage;
    private Integer pageSize;
    private Integer totalSize;
    private Integer totalPage;
    private List<T> list;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Page{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", totalSize=" + totalSize +
                ", totalPage=" + totalPage +
                ", list=" + list +
                '}';
    }
}
