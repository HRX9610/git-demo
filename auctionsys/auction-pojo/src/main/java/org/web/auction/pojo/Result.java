package org.web.auction.pojo;

import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

//分页数据包装类
public class Result implements Serializable {

    private List data;
    private PageInfo pageInfo;

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }
}
