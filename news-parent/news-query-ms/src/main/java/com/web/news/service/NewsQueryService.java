package com.web.news.service;

import com.web.news.pojo.Category;
import com.web.news.pojo.News;
import org.apache.catalina.LifecycleState;

import java.util.List;
import java.util.Locale;

public interface NewsQueryService {

    public List<News> queryNews();

    public List<Category> queryAllCategory();

    public News findNewsById(int id);

    public List<News> queryNews(News news);
}
