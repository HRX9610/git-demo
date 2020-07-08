package com.web.news.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.web.news.pojo.Category;
import com.web.news.pojo.News;
import com.web.news.pojo.ResultPage;
import com.web.news.service.NewsQueryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "NewsQueryController",description = "新闻查询微服务接口") //用于类上方
@RestController
public class NewsQueryController {

    @Autowired
    private NewsQueryService newsQueryService;

    @ApiOperation("查询所有新闻") //用于方法上
    @GetMapping("/queryNews")
    public List<News> queryNews(){
        List<News> list = newsQueryService.queryNews();
        System.out.println(list);
        return list;
    }

    @ApiOperation("查询所有新闻类别") //用于方法上
    @GetMapping("/findAllCategory")
    public List<Category> findAllCategory(){
        return newsQueryService.queryAllCategory();
    }

    @ApiOperation("根据ID查询新闻") //用于方法上
    @GetMapping("/findNewsById/{id}")
    public News findNewsById(@PathVariable int id){
        System.out.println("查询news的id: "+ id);
        return newsQueryService.findNewsById(id);
    }

    @ApiOperation("组合条件查询") //用于方法上
    @PostMapping(value = "/findNewsByCondition")
    public List<News> findNewsByCondition(@RequestBody @ApiParam("新闻查询条件对象") News news){
        System.out.println("news id : "+ news.getCategoryid());
        System.out.println("news title : "+ news.getTitle());

        return  newsQueryService.queryNews(news);
    }

    @GetMapping("/findByPage")
    public ResultPage findByPage(int pageNum, int pageSize){
        System.out.println("页码:"+ pageNum);
        System.out.println("每页记录数:"+pageSize);
        PageHelper.startPage(pageNum,pageSize);
        Page<News> page = (Page<News>)newsQueryService.queryNews();

        ResultPage resultPage = new ResultPage();
        resultPage.setRows(page.getResult());
        resultPage.setTotal(page.getTotal());
        return resultPage;
    }

}
