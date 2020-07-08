package com.web.shopping.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.web.shopping.pojo.PageResult;
import com.web.shopping.pojo.RespBean;
import com.web.shopping.pojo.TbBrand;
import com.web.shopping.service.SellerGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "SellerGoodsController",description = "品牌信息管理微服务接口") //用于类上方
@RestController
public class SellerGoodsController {

    @Autowired
    private SellerGoodsService sellerGoodsService;

    @ApiOperation("更新提交品牌信息") //用于方法上
    @PutMapping("/doUpdateSubmit")
    public void doUpdateSubmit(@RequestBody TbBrand tbBrand){
        System.out.println("tbBrand id: "+ tbBrand.getId());
        System.out.println("tbBrand title: "+ tbBrand.getName());
        System.out.println("tbBrand firstChar: "+ tbBrand.getFirstChar());
        sellerGoodsService.updateBrand(tbBrand);
    }

    @ApiOperation("更新品牌信息") //用于方法上
    @PostMapping("/updateBrand")
    public RespBean updateNews(@RequestBody TbBrand tbBrand){
        try {
            System.out.println("tbBrand id: "+ tbBrand.getId());
            System.out.println("tbBrand title: "+ tbBrand.getName());
            System.out.println("tbBrand firstChar: "+ tbBrand.getFirstChar());
            sellerGoodsService.updateBrand(tbBrand);
            return RespBean.ok("修改成功");
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.error("修改失败");
        }

    }

    @ApiOperation("添加品牌信息") //用于方法上
    @PostMapping("/addBrand")
    public RespBean addBrand(@RequestBody TbBrand tbBrand){
        try {
            System.out.println("tbBrand id: "+ tbBrand.getId());
            System.out.println("tbBrand title: "+ tbBrand.getName());
            System.out.println("tbBrand firstChar: "+ tbBrand.getFirstChar());
            sellerGoodsService.addBrand(tbBrand);
            return RespBean.ok("添加成功");
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.error("添加失败");
        }

    }

    @ApiOperation("批量删除品牌信息") //用于方法上
    @GetMapping("/deleteManyBrand")
    public RespBean deleteManyNews(int[] ids){
        try {
            System.out.println("tbBrand id :" + ids[0]);
            sellerGoodsService.deleteManyBrand(ids);
            return RespBean.ok("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.error("删除失败");
        }

    }

    @ApiOperation("查询所有品牌信息") //用于方法上
    @GetMapping("/queryBrand")
    public List<TbBrand> queryBrand(){
        List<TbBrand> list = sellerGoodsService.queryBrand();
        System.out.println(list);
        return list;
    }

    @ApiOperation("根据ID查询品牌信息") //用于方法上
    @GetMapping("/findBrandById/{id}")
    public TbBrand findBrandById(@PathVariable long id){
        System.out.println("查询Brand的id: "+ id);
        return sellerGoodsService.findBrandById(id);
    }

    @ApiOperation("当前查询页信息") //用于方法上
    @GetMapping("/findByPage")
    public PageResult findByPage(int pageNum, int pageSize){
        System.out.println("页码:"+ pageNum);
        System.out.println("每页记录数:"+pageSize);
        PageHelper.startPage(pageNum,pageSize);
        Page<TbBrand> page = (Page<TbBrand>)sellerGoodsService.queryBrand();

        PageResult pageResult = new PageResult();
        pageResult.setRows(page.getResult());
        pageResult.setTotal(page.getTotal());
        return pageResult;
    }

    @GetMapping("/selectOptionList")
    public List<Map> selectOptionList(){
        return sellerGoodsService.selectOptionList();
    }

}
