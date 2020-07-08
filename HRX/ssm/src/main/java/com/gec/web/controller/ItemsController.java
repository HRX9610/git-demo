package com.gec.web.controller;

import com.gec.web.pojo.Items;
import com.gec.web.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class ItemsController {

    @Autowired
    private ItemService itemService;

    public static final int PAGE_SIZE = 10;

    @GetMapping("/queryItems")
    public ModelAndView queryItems(
            @RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum) {
        ModelAndView mv = new ModelAndView();
        PageHelper.startPage(pageNum,PAGE_SIZE);
        List<Items> list = itemService.queryItems();
        PageInfo pageInfo = new PageInfo<>(list);
        mv.addObject("itemList",list);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("itemsList");
        //postHandle
        return  mv; //afterCompletion
    }

    @RequestMapping("/addItemsSubmit")
    public String addItemsSubmit(Items items, MultipartFile picFile, HttpSession session) {
        try {
            //1. tomcat所在的服务器，部署工程中, 如果工程重新打包，重新部署，会删除上传的图片
            //2. tomcat所在的服务器, 但是不存放到部署工程中，而是存放在某个指定的文件夹,该文件夹要做映射配置
            //3. 专门配置文件服务器
            //String path = session.getServletContext().getRealPath("pic");
            String path = "D:/file";
            File targetFile = new File(path,picFile.getOriginalFilename());
            picFile.transferTo(targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        items.setPic(picFile.getOriginalFilename());
        itemService.addItems(items);
        return "redirect:/queryItems";
    }
}
