package com.web.news.controller;

import com.web.news.pojo.NewsCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class NewsController {

    @Autowired
    private RestTemplate restTemplate;

    public static final String QUERY_URL = "http://localhost:8899/news-query/";

    public static final String EDIT_URL = "http://localhost:8899/news-edit/";

    @GetMapping("/queryNews")
    public ModelAndView queryNews(@ModelAttribute("newsCondition") NewsCondition news){
        List newsList = restTemplate.getForObject(QUERY_URL+"queryNews",List.class);
        List cateList = restTemplate.getForObject(QUERY_URL+"findAllCategory",List.class);
        ModelAndView mv = new ModelAndView();
        mv.addObject("newsList",newsList);
        mv.addObject("cateList",cateList);
        mv.setViewName("index");
        return mv;
    }

    @PostMapping("/queryByCondition") //不用加@RequestBody ,在同一个应用中以key/value
    public ModelAndView queryNewsByCondition(@ModelAttribute("newsCondition") NewsCondition news){
        ModelAndView mv = new ModelAndView();
        System.out.println(news.getCategoryid());
        System.out.println(news.getTitle());

        List categoryList = this.restTemplate.getForObject(QUERY_URL+"findAllCategory",List.class);
        List newsList = this.restTemplate.postForObject(QUERY_URL+"findNewsByCondition",news,List.class);

        mv.addObject("newsList", newsList);
        mv.addObject("cateList",categoryList);
        mv.setViewName("index");
        return mv;
    }

    @GetMapping("/toUpdate/{id}")
    public ModelAndView toUpdate(@PathVariable int id){

        NewsCondition newsDetail = this.restTemplate.getForObject(QUERY_URL+"findNewsById/"+id, NewsCondition.class);
        List categoryList = this.restTemplate.getForObject(QUERY_URL+"findAllCategory", List.class);

        ModelAndView mv = new ModelAndView();
        mv.addObject("newsDetail", newsDetail);
        mv.addObject("categoryList", categoryList);
        mv.setViewName("updateNews");
        return mv;
    }

    @RequestMapping("/doUpdateSubmit")
    public String doUpdateSubmit(NewsCondition news){
        this.restTemplate.put(EDIT_URL+"doUpdateSubmit", news);
        return "redirect:/queryNews";
    }

}
