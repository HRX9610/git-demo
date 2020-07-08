package com.gec.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Value("${server.port}")
    private String port;

    //服务接口提供的URL
    @GetMapping("/findUserList")
    public List<String> findUserList(){
        List<String> names = new ArrayList<>();
        names.add("Mike");
        names.add("Danny");
        names.add("Jerry");
        names.add(port);
        return names;
    }
}
