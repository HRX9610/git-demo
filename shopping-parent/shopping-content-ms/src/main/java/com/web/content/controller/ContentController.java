package com.web.content.controller;

import com.web.content.service.ContentService;
import com.web.shopping.pojo.PageResult;
import com.web.shopping.pojo.Result;
import com.web.shopping.pojo.TbContent;
import com.web.shopping.pojo.TbContentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
public class ContentController {

    @Autowired
    private ContentService contentService;

    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/findAllContent")
    public List<TbContent> findAllContent(){
        return contentService.findAll();
    }

    @RequestMapping("/findAllContentCategory")
    public List<TbContentCategory> findAllContentCategory(){
        return contentService.findAllContentCategory();
    }

    @RequestMapping("/findByCategoryId")
    public List<TbContent> findByCategoryId(Long categoryId){
        return contentService.findByCategoryId(categoryId);
    }
    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/findByPageContent")
    public PageResult findByPageContent(int pageNum, int pageSize){
        return contentService.findPage(pageNum, pageSize);
    }

    /**
     * 增加
     * @param content
     * @return
     */
    @RequestMapping("/addContent")
    public Result addContent(@RequestBody TbContent content){
        try {
            contentService.add(content);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     * @param content
     * @return
     */
    @RequestMapping("/updateContent")
    public Result updateContent(@RequestBody TbContent content){
        try {
            contentService.update(content);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    /**
     * 获取实体
     * @param id
     * @return
     */
    @RequestMapping("/findOne/{id}")
    public TbContent findOne(@PathVariable Long id){
        return contentService.findOne(id);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/deleteContent")
    public Result deleteContent(Long [] ids){
        try {
            contentService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    /**
     * 查询+分页
     * @param brand
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/search")
    public PageResult search(@RequestBody TbContent content, int page, int rows  ){
        return contentService.findPage(content, page, rows);
    }

}

