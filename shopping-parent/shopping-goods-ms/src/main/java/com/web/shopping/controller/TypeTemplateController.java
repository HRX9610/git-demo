package com.web.shopping.controller;

import java.util.List;
import java.util.Map;

import com.web.shopping.pojo.PageResult;
import com.web.shopping.pojo.Result;
import com.web.shopping.pojo.TbTypeTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.web.shopping.service.TypeTemplateService;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
public class TypeTemplateController {

    @Autowired
    private TypeTemplateService typeTemplateService;

    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/findAllTypeTemplates")
    public List<TbTypeTemplate> findAllTypeTemplates(){
        return typeTemplateService.findAll();
    }


    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/findByTbTypeTemplatePage")
    public PageResult findPage(int pageNum, int pageSize){
        return typeTemplateService.findPage(pageNum, pageSize);
    }

    /**
     * 增加
     * @param typeTemplate
     * @return
     */
    @RequestMapping("/addTypeTemplates")
    public Result addTypeTemplates(@RequestBody TbTypeTemplate typeTemplate){

        try {
            typeTemplateService.add(typeTemplate);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     * @param typeTemplate
     * @return
     */
    @RequestMapping("/UpdateTypeTemplates")
    public Result UpdateTypeTemplates(@RequestBody TbTypeTemplate typeTemplate){
        try {
            typeTemplateService.update(typeTemplate);
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
    @RequestMapping("/findTypeTemplatesById/{id}")
    public TbTypeTemplate findTypeTemplatesById(@PathVariable Long id){
        return typeTemplateService.findOne(id);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/deleManyTypeTemplatesList")
    public Result findByTbTypeTemplatePage(Long [] ids){
        try {
            typeTemplateService.delete(ids);
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
    public PageResult search(@RequestBody TbTypeTemplate typeTemplate, int page, int rows  ){
        return typeTemplateService.findPage(typeTemplate, page, rows);
    }

    @RequestMapping("/findBySpecList")
    public List<Map> findSpecList(Long id){
        return typeTemplateService.findSpecList(id);
    }


}
