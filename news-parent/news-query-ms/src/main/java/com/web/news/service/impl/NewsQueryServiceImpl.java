package com.web.news.service.impl;

import com.web.news.mapper.CategoryMapper;
import com.web.news.mapper.NewsMapper;
import com.web.news.pojo.Category;
import com.web.news.pojo.News;
import com.web.news.pojo.NewsExample;
import com.web.news.service.NewsQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class NewsQueryServiceImpl implements NewsQueryService {

    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<News> queryNews(){
        return newsMapper.selectByExample(null);
    }

    @Override
    public List<Category> queryAllCategory() {
        return categoryMapper.selectByExample(null);
    }

    @Override
    public News findNewsById(@PathVariable int id) {
        return newsMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<News> queryNews(News news) {
        NewsExample example = new NewsExample();
        NewsExample.Criteria criteria = example.createCriteria();
        if(news != null){
            if(news.getCategoryid()!=0){
                criteria.andCategoryidEqualTo(news.getCategoryid());
            }
            if(news.getTitle()!=null && !"".equals(news.getTitle())){
                criteria.andTitleLike("%"+news.getTitle()+"%");
            }
        }
        List<News> list = newsMapper.selectByExample(example);
        return list;
    }
}
