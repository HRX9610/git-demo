package cn.web.items.controller;

import cn.web.items.pojo.Items;
import cn.web.items.pojo.RespBean;
import cn.web.items.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "ItemController",description = "产品后台信息服务接口") //用于类上方
@RestController //后台服务一般没有视图渲染，仅提供业务数据，json数据交互
public class ItemsController {

    @Autowired
    private ItemService itemService;

    //@RequestMapping(value = "/loadAllItems",method = RequestMethod.GET)
    @ApiOperation("查询所有产品列表的信息") //用于方法上
    @GetMapping("/loadAllItems")
    public List<Items> loadAllItems(){
        return itemService.findAllItems();
    }

    @ApiOperation("根据ID查询单件产品信息") //用于方法上
    @GetMapping("/loadItemsById/{id}")
    public Items loadItemsById(@PathVariable int id){
        return itemService.findItemsById(id);
    }

    // @PostMapping("/addItems")
    // RequestBody：json对象->java对象，主要用于前端发送的是json数据
    // 如果在单体应用中，就无需添加@RequestBody
    @ApiOperation("添加产品信息") //用于方法上
    @RequestMapping(value = "/addItems",method = RequestMethod.POST)
    public RespBean addItems(@RequestBody @ApiParam("产品对象") Items items){ //ApiParam用于方法参数上
        try{
            System.out.println("id: "+ items.getId());
            System.out.println("name: "+ items.getName());
            itemService.addItems(items);
            return RespBean.ok("添加成功",items);
        }catch (Exception ex){
            ex.printStackTrace();
            return RespBean.error("添加失败");
        }
    }

    @ApiOperation("修改产品信息") //用于方法上
    @RequestMapping(value = "/updateItems",method = RequestMethod.PUT)
    public RespBean updateItems(@RequestBody @ApiParam("产品对象")Items items){
        try{
            System.out.println("id: "+ items.getId());
            System.out.println("name: "+ items.getName());
            itemService.updateItems(items);
            return RespBean.ok("修改成功");
        }catch (Exception ex){
            ex.printStackTrace();
            return RespBean.error("修改失败");
        }
    }

    @ApiOperation("删除产品信息") //用于方法上
    @RequestMapping(value = "/deleteItems/{id}",method = RequestMethod.DELETE)
    public RespBean deleteItems(@PathVariable int id){
        try{
            itemService.deleteItems(id);
            return RespBean.ok("删除成功");
        }catch (Exception ex){
            ex.printStackTrace();
            return RespBean.error("删除失败");
        }
    }
}
