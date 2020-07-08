package com.web.news.controller;

import com.web.news.pojo.News;
import com.web.news.pojo.RespBean;
import com.web.news.service.NewsEditService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "NewsEditController",description = "新闻编辑微服务接口") //用于类上方
@RestController
public class NewsEditController {

    @Autowired
    private NewsEditService newsEditService;

    @ApiOperation("更新新闻信息") //用于方法上
    @PutMapping("/doUpdateSubmit")
    public void doUpdateSubmit(@RequestBody News news){
        System.out.println("news id: "+ news.getId());
        System.out.println("news title: "+ news.getTitle());
        newsEditService.updateNews(news);
    }

    @PostMapping("/updateNews")
    public RespBean updateNews(@RequestBody News news){
        try {
            System.out.println("news id :" + news.getId());
            System.out.println("news title :" + news.getTitle());
            newsEditService.updateNews(news);
            return RespBean.ok("修改成功");
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.error("修改失败");
        }

    }

    @PostMapping("/addNews")
    public RespBean addNews(@RequestBody News news){
        try {
            System.out.println("news id :" + news.getId());
            System.out.println("news title :" + news.getTitle());
            newsEditService.addNews(news);
            return RespBean.ok("添加成功");
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.error("添加失败");
        }

    }

    @GetMapping("/deleteManyNews")
    public RespBean deleteManyNews(int[] ids){
        try {
            System.out.println("news id :" + ids[0]);
            newsEditService.deleteManyNews(ids);
            return RespBean.ok("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.error("删除失败");
        }

    }

}
