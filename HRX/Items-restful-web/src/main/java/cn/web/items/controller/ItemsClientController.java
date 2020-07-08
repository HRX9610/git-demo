package cn.web.items.controller;

import cn.web.items.pojo.Items;
import cn.web.items.pojo.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ItemsClientController {

    @Autowired
    private RestTemplate restTemplate;

    public String baseURL = "http://localhost:8099/";

    @GetMapping("/queryItems")
    public ModelAndView queryItems(){

        List list = restTemplate.getForObject(baseURL+"loadAllItems", List.class);
        ModelAndView mv = new ModelAndView();
        mv.addObject("itemsList",list);
        mv.setViewName("itemsList");
        return mv;
    }

    @PostMapping("/addItemsSubmit")
    public String addItemsSubmit(Items items){
        System.out.println("items name:"+ items.getName());
        RespBean respBean = restTemplate.postForObject(baseURL+"addItems",items, RespBean.class);
        if(respBean.getCode()==200){
            return "redirect:/queryItems";
        }
        return "addItem";
    }

    @GetMapping("/toAdd")
    public String toAdd(){
        return "addItem";
    }
}
