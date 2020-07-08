package com.web.shopping.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.web.shopping.pojo.PageResult;
import com.web.shopping.pojo.RespBean;
import com.web.shopping.pojo.TbSpecification;
import com.web.shopping.pojogroup.Specification;
import com.web.shopping.service.SpecificationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "SpecificationController",description = "规格信息管理微服务接口") //用于类上方
@RestController
public class SpecificationController {

    @Autowired
    private SpecificationService specificationService;

    @RequestMapping("/findAll")
    public List<TbSpecification> findAll(){
        List<TbSpecification> list = specificationService.findAll();
        System.out.println(list);
        return list;
    }

    @RequestMapping("/addSpecification")
    public RespBean addSpecification(@RequestBody Specification specification){
        System.out.println(specification.getSpecification());
        System.out.println(specification.getSpecificationOptionList());
        try {
            specificationService.add(specification);
            return RespBean.ok("添加成功");
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.error("添加失败");
        }
    }

    @RequestMapping("/updateSpecification")
    public RespBean updateSpecification(@RequestBody Specification specification){
        try {
            specificationService.update(specification);
            return RespBean.ok("添加成功");
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.error("添加失败");
        }
    }

    @ApiOperation("更新提交品牌信息") //用于方法上
    @PutMapping("/doUpdateSubmitSpecification")
    public void doUpdateSubmitSpecification(@RequestBody Specification specification){
        System.out.println("tbSpecification id: "+ specification.getSpecification());
        System.out.println("tbSpecification specName: "+ specification.getSpecificationOptionList());
        specificationService.update(specification);
    }

    @ApiOperation("批量删除品牌信息") //用于方法上
    @GetMapping("/deleteManySpecification")
    public RespBean deleteManySpecification(int[] ids){
        try {
            System.out.println("tbSpecification id :" + ids[0]);
            specificationService.deleteManySpecific(ids);
            return RespBean.ok("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.error("删除失败");
        }

    }

    @ApiOperation("根据ID查询品牌信息") //用于方法上
    @GetMapping("/findSpecificationById/{id}")
    public Specification findSpecificationById(@PathVariable long id){
        System.out.println("查询Specification的id: "+ id);
        return specificationService.findSpecificationById(id);
    }

    @ApiOperation("当前查询页信息") //用于方法上
    @GetMapping("/findByPageSpecification")
    public PageResult findByPageSpecification(int pageNum, int pageSize, String searchName){
        System.out.println("页码:"+ pageNum);
        System.out.println("每页记录数:"+pageSize);
        PageHelper.startPage(pageNum,pageSize);
        Page<TbSpecification> page = null;
        if(searchName != null && !"".equals(searchName)){
            page = (Page<TbSpecification>)specificationService.querySpecificationByName(searchName);
        }else{
            page = (Page<TbSpecification>)specificationService.findAll();
        }

        PageResult pageResult = new PageResult();
        pageResult.setRows(page.getResult());
        pageResult.setTotal(page.getTotal());
        return pageResult;
    }

    @GetMapping("/selectSpecificationsOptionList")
    public List<Map> selectSpecificationsOptionList(){
        return specificationService.selectSpecificationsOptionList();
    }

}
