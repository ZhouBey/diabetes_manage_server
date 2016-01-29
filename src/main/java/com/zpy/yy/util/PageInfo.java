package com.zpy.yy.util;

import java.io.Serializable;

public class PageInfo implements Serializable {

    private static final long serialVersionUID = 587754556498974978L;

    //每一页显示多少
    private int showCount = 15;
    //总页数
    private int totalPage;
    //总记录数
    private int totalResult;
    //当前页数
    private int currentPage = 1;

//    private int currentResult = 0;

//    public int getCurrentResult() {
//        return currentResult;
//    }
//
//    public void setCurrentResult(int currentResult) {
//        this.currentResult = currentResult;
//    }

    public int getShowCount() {
        return showCount;
    }

    public void setShowCount(int showCount) {
        this.showCount = showCount;
//        this.currentResult = (currentPage - 1) * showCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(int totalResult) {
        this.totalResult = totalResult;
        if (totalResult % showCount == 0) {
            this.setTotalPage(totalResult / showCount);
        } else {
            this.setTotalPage(totalResult / showCount + 1);
        }
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
//        this.currentResult = (currentPage - 1) * showCount;
    }
}
