package com.gec.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserClientController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/loadAllNames")
    @HystrixCommand(fallbackMethod = "loadAllNamesFallback")
    public List<String> loadAllNames(){
        String url = "http://service-provider/findUserList";
        List<String> names = restTemplate.getForObject(url,List.class);
        return names;
    }

    public List<String> loadAllNamesFallback(){
        List<String> list = new ArrayList<>();
        list.add("服务故障");
        return list;
    }
}
