package com.liuyiqing.base;

import java.io.Serializable;

/**
 * Created by miaomiao on 18-2-26.
 */
public class Base  implements Serializable{

    /**
     *  分页页码，默认为1
     */
    protected int page = 1;

    /**
     * 分页每页数量
     */
    protected int size = 20;

    /**
     * 排序列名称，默认为id
     */
    protected String sidx = "id";

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }
}
