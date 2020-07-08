package com.gec.search.controller;

import com.gec.search.service.ItemSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ItemSearchController {

    @Autowired
    private ItemSearchService itemSearchService;
    @RequestMapping("/search")
    public Map search(@RequestBody Map searchMap){
        System.out.println(searchMap);

        return itemSearchService.search(searchMap);
    }
}
